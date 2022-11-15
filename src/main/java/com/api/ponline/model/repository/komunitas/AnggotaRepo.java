package com.api.ponline.model.repository.komunitas;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.ponline.model.Entity.komunitas.Anggota;
import com.api.ponline.model.Entity.komunitas.Komunitas;
import com.api.ponline.model.Entity.user.User;

public interface AnggotaRepo extends CrudRepository<Anggota, Long>{

    List<Anggota> findByUser(User user);
    List<Anggota> findByKomunitas(Komunitas komunitas);
    
}
