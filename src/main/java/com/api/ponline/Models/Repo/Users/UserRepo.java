package com.api.ponline.Models.Repo.Users;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.ponline.Models.Entity.Users.User;
import com.api.ponline.Models.Entity.Users.UserRole;

public interface UserRepo extends PagingAndSortingRepository<User, Long>{
    Optional<User> findByEmail(String email);

    List<User> findByUserRole(UserRole userRole);

    @Query("SELECT u FROM User u WHERE u.tokenVerification = :verificationToken")
    public User findByVerificationToken(@PathParam("verificationToken") String verificationToken);

    
   
}
