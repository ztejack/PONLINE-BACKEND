package com.api.ponline.Services.Users;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.ponline.Models.Entity.Users.User;
import com.api.ponline.Models.Repo.Users.UserRepo;

@Service
@Transactional
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepo userAuthRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userAuthRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '%s' not found", email)));
    }

    public User registeUser(User userAuth) {
        boolean userExist = userAuthRepo.findByEmail(userAuth.getEmail()).isPresent();

        if (userExist) {
            throw new RuntimeException(
                String.format("User with email '%s' already exist", userAuth.getEmail())
            );
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userAuth.getPassword());
        userAuth.setPassword(encodedPassword);
        return userAuthRepo.save(userAuth);
    }

    public Iterable<User> findAll() {
        return userAuthRepo.findAll();
    }
    
}
