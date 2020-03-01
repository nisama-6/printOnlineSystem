package com.printonline.demo.security;

import com.alibaba.fastjson.JSON;
import com.printonline.demo.pojo.Account;
import com.printonline.demo.service.AccountService;
import com.printonline.demo.tools.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component("myAuthenctiationSuccessHandler")
public class MyAuthenctiationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AccountService accountService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        logger.info("登录成功");
        Account account=new Account();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            account=accountService.findAccountByUsername(currentUserName);
        }
        HttpSession session=request.getSession();
        response=ResponseHandle.responseHandle(response);
        session.setAttribute("loginAccount",account);
        response.getWriter().write( JSON.toJSONString(new Result(true,"登陆成功",account)));
//        account.setPassword(null);
//        account.setUsermessage(null);
//        LoginMsgServiceImpl.put(account.getUsername(),account);
    }
}