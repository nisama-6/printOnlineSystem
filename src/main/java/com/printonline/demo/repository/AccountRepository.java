package com.printonline.demo.repository;

import com.printonline.demo.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName : AccountRepository
 * @Description : TODO
 * @Author : niran
 * @Date : 2020/1/28
 **/

public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findAccountByAccountId(Integer id);

    /**
     * 根据用户名查询账户
     * @param username
     * @return
     */
    Account findAccountByUsername(String username);


}
