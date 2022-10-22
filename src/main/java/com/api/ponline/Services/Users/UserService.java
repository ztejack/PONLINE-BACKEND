package com.api.ponline.Services.Users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.ponline.Models.Entity.Users.User;
import com.api.ponline.Models.Entity.Users.UserRole;
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

    public User registeUser(User user) {
        boolean userExist = userAuthRepo.findByEmail(user.getEmail()).isPresent();

        if (userExist) {
            throw new RuntimeException(
                String.format("Pengguna dengan email '%s' sudah terdaftar", user.getEmail())
            );
        }else if(user.getUserRole().equals(UserRole.PQOWNEDR)){
            throw new RuntimeException(
                String.format("Hubungi Admin Untuk Mendaftar Dengan Peran Tersebut")
            );
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userAuthRepo.save(user);
    }

    public Iterable<User> findAll() {
        return userAuthRepo.findAll();
    }

    public List<User> findByUserRole(UserRole userRole) {
        return userAuthRepo.findByUserRole(userRole);
    }


    
}
