package com.goforbroke1006.auth.service;

import com.goforbroke1006.auth.Constants;
import com.goforbroke1006.auth.CustomUserDetails;
import com.goforbroke1006.auth.dao.AccountDao;
import com.goforbroke1006.auth.domain.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountDao accountDao;

    public UserDetailsServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account applicationUser = accountDao.findByUserName(username);

        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("USER"));
        CustomUserDetails userDetails = new CustomUserDetails(
                applicationUser.getUsername(), grantedAuths
        );

//        userDetails.setSessionId(applicationUser.getSessionId());
//        userDetails.setAccountId(applicationUser.getAccountId());

        return userDetails;
    }

}
