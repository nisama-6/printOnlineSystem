package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.Account;
import com.printonline.demo.repository.AccountRepository;
import com.printonline.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @ClassName : AccountServiceImpl
 * @Description : TODO AccountService的实现类
 * @Author : niran
 * @Date : 2020/1/28
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account findAccountByUsername(String username) throws ServletException {
        Account account = accountRepository.findAccountByUsername(username);
        if(account==null){
            throw new ServletException("账户不存在");
        }
        return account;
    }
}
