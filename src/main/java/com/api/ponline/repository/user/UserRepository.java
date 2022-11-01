package com.api.ponline.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.ponline.model.user.User;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    List<User> findByTokResetPassword(String tokResetPassword);

    List<User> findByTokEmailVerified(String tokEmailVerified);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findOneByEmail(@PathParam("email") String email);
    
}
