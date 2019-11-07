package com.shan.service.impl;

import com.shan.dao.AccountDao;
import com.shan.domain.Account;
import com.shan.service.AccountService;
import com.sun.tools.internal.ws.processor.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户。。。");
        List<Account> list = accountDao.findAll();

        return list;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：查询所有账户。。。");
        accountDao.saveAccount(account);

    }
}
