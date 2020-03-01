package com.printonline.demo.security;


import com.printonline.demo.pojo.Account;
import com.printonline.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.Collection;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // 从数据库中取出用户信息
        Account user = null;
        try {
            user = accountService.findAccountByUsername(username);
        } catch (ServletException e) {
            e.printStackTrace();
        }
//        // 判断用户是否存在
        if(user==null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
//      返回UserDetails实现类

        return new User(user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getIdentity()));
    }
}