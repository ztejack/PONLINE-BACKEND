package com.api.ponline.services.komunitas;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ponline.model.Entity.komunitas.Anggota;
import com.api.ponline.model.Entity.komunitas.Komunitas;
import com.api.ponline.model.Entity.user.User;
import com.api.ponline.model.repository.komunitas.AnggotaRepo;

@Service
@Transactional
public class AnggotaServices{
    
    @Autowired
    private AnggotaRepo anggotaRepo;

    public Anggota save(Anggota anggota) {
        return anggotaRepo.save(anggota);
    }

    public Anggota findOne(Long id) {
        return anggotaRepo.findById(id).get();
    }

    public Iterable<Anggota> findAll() {
        return anggotaRepo.findAll();
    }

    public List<Anggota> findByUser(User user){
        return anggotaRepo.findByUser(user);
    }

    public List<Anggota> findByKomunitas(Komunitas komunitas){
        return anggotaRepo.findByKomunitas(komunitas);
    }
}