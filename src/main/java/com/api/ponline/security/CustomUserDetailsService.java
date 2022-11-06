package com.api.ponline.security;


import com.api.ponline.dao.exception.ResourceNotFoundException;
import com.api.ponline.model.Entity.user.User;
import com.api.ponline.model.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Tambahkan anotasi @aervice untuk memberitahu sistem bahwa ini adalah class service
// Implementasi class 'UserDetailsService'
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Injeksi class 'UserRepository'
    @Autowired
    UserRepository userRepository;

    // Tulis ulang (overide) method 'loadUserByUsername dari lib 'UserDetailsService'
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Karena pada ERD tabel user tidak ada attribut username, maka username di ganti dengan email
        // Cari user di database dan simpan ke objek user
        User user = userRepository.findByEmail(email).orElseThrow(() ->
            // Jika error maka response user tidak di temukan
            new UsernameNotFoundException("Pengguna dengan email : " + email + " tidak ditemukan")
        );

        // Buat Kelas user utama dan kembalikan
        return UserPrincipal.create(user);
    }

    // Sama kaya sebelumnya tapi berdasarkan id
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
}