package com.goforbroke1006.auth.dao;

import com.goforbroke1006.auth.domain.Account;

public interface AccountDao {

    Account findByUserName(String userName);

    Account findByAccountId(long accountId);

    void saveOrUpdate(Account user);

    void save(Account user);

}
