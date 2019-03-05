package com.goforbroke1006.auth.dao;

import com.goforbroke1006.auth.domain.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public Account findByUserName(String userName) {
        return em.find(Account.class, userName);
    }

    @Transactional(readOnly = true)
    @Override
    public Account findByAccountId(long accountId) {
        return em.find(Account.class, accountId);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Account user) {
        if (em.find(Account.class, user.getUsername()) != null) {
            em.merge(user);
        } else
            em.persist(user);
        em.flush();
    }

    @Override
    @Transactional
    public void save(Account user) {
        em.persist(user);
        em.flush();
    }

}
