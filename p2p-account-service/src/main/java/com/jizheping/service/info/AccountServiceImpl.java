package com.jizheping.service.info;

import com.jizheping.api.entity.Account;
import com.jizheping.dao.AccountDao;
import com.jizheping.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void createAccount(Account account) {
        accountDao.save(account);
    }
}
