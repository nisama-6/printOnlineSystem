package com.printonline.demo.service;

import com.printonline.demo.pojo.Account;

import javax.servlet.ServletException;

/**
 * @ClassName : AccountService
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/28
 **/

public interface AccountService {

    /**
     * 根据登录名查询账户
     * @param username 用户名
     * @return 返回查询到的Account
     * @throws ServletException 抛出自定义异常
     */
    Account findAccountByUsername(String username) throws ServletException;


}
