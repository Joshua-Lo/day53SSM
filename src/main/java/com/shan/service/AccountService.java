package com.shan.service;

import com.shan.domain.Account;

import java.util.List;

public interface AccountService {
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
