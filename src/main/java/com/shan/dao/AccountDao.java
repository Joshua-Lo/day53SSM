package com.shan.dao;

import com.shan.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {
    /**
     * 查询所有用户
     * @return
     */
    List<Account> findAll();


    /**
     *
     * @return
     */

    void saveAccount(Account account);
}
