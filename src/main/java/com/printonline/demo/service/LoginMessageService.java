package com.printonline.demo.service;

import com.printonline.demo.pojo.Account;

import javax.servlet.ServletException;

/**
 * @ClassName : LoginMessageService
 * @Description : TODO
 * @Author : niran
 * @Date : 2019/12/25
 **/

public interface LoginMessageService {

    /**
     * 获取当前登录的账户信息
     * @return
     * @throws ServletException
     */
    Account getLoginAccount() throws  ServletException;
}
