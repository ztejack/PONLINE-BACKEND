package com.api.ponline.model.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.ponline.model.Entity.user.User;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

// Tambahkan Anotasi @Repository untuk memberitahu bahwa ini adalah class repository
// Turunkan class JpaRepository dari lib 'JPA'
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // (JPA)Query untuk cari user berdasarkan email return optional
    Optional<User> findByEmail(String email);

    // (JPA)Query untuk cari user apakah ada atau tidak di database berdarakan email
    Boolean existsByEmail(String email);

    // (JPA)Query untuk cari user berdasarkan tokenResetPassword
    List<User> findByTokResetPassword(String tokResetPassword);

    // (JPA)Query untuk cari user berdasarkan tokenEmailVerified
    List<User> findByTokEmailVerified(String tokEmailVerified);

    // (MANUAL)Query untuk cari user berdarakan email return 1 user
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User findOneByEmail(@PathParam("email") String email);

    // (MANUAL)Query untuk cari user berdarakan email return 1 user
    @Query("SELECT u FROM User u WHERE u.id = :id")
    public User findOneById(@PathParam("id") Long id);

    
}
