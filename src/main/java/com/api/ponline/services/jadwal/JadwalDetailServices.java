package com.api.ponline.services.jadwal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ponline.model.Entity.jadwal.JadwalDetails;
import com.api.ponline.model.repository.jadwal.JadwalDetailRepo;

@Service
@Transactional
public class JadwalDetailServices{
    
    @Autowired
    private JadwalDetailRepo jadwalDetailRepo;

    public JadwalDetails save(JadwalDetails jadwalDetails) {
        return jadwalDetailRepo.save(jadwalDetails);
    }

    public JadwalDetails findOne(Long id) {
        return jadwalDetailRepo.findById(id).get();
    }

    public Iterable<JadwalDetails> findAll() {
        return jadwalDetailRepo.findAll();
    }
}
