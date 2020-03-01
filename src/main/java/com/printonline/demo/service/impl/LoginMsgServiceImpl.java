package com.printonline.demo.service.impl;

import com.printonline.demo.pojo.Account;
import com.printonline.demo.service.AccountService;
import com.printonline.demo.service.LoginMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;



/**
 * @ClassName : LoginMsgServiceImpl
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/25
 **/

@Service
public class LoginMsgServiceImpl implements LoginMessageService {

    @Autowired
    AccountService accountService;

    @Autowired
    private HttpSession session;

    @Override
    public Account getLoginAccount() throws ServletException {
        Account account = (Account) session.getAttribute("loginAccount");
        if (account == null) {
            throw new ServletException("非法访问");
        } else {
            return account;
        }
    }
}
