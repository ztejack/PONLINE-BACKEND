package com.api.ponline.services.komunitas;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ponline.model.Entity.komunitas.Komunitas;
import com.api.ponline.model.repository.komunitas.KomunitasRepo;

@Service
@Transactional
public class KomunitasServices{
    
    @Autowired
    private KomunitasRepo komunitasRepo;

    public Komunitas save(Komunitas komunitas) {
        return komunitasRepo.save(komunitas);
    }

    public Komunitas findOne(Long id) {
        return komunitasRepo.findById(id).get();
    }

    public Boolean isExist(Long id) {
        Komunitas komunitas = findOne(id);
        if (komunitas!=null) {
            return true;
        }else{
            return false;
        }
    }

    public Iterable<Komunitas> findAll() {
        return komunitasRepo.findAll();
    }
}
