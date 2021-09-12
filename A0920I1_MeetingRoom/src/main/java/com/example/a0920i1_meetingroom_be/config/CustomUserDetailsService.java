package com.example.a0920i1_meetingroom_be.config;


import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.models.entity.AccountRole;
import com.example.a0920i1_meetingroom_be.repositories.AccountRepository;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = null;
        Account account = accountRepository.findByUsername(username);

        if (account != null) {
            grantedAuthorities = new ArrayList<>();
            List<AccountRole> roles = account.getAccountRoleList();
            for (AccountRole role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
            }
            return new User(username, account.getPassword(), grantedAuthorities);
        }
        throw new UsernameNotFoundException("User not found with the name " + username);
    }

    public Account save(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
}
