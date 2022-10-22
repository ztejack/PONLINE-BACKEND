package com.api.ponline.Models.Repo.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.ponline.Models.Entity.Users.User;
import com.api.ponline.Models.Entity.Users.UserRole;

public interface UserRepo extends PagingAndSortingRepository<User, Long>{
    Optional<User> findByEmail(String email);

    List<User> findByUserRole(UserRole userRole);
   
}
