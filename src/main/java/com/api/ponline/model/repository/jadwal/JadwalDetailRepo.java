package com.api.ponline.model.repository.jadwal;

import org.springframework.data.repository.CrudRepository;

import com.api.ponline.model.Entity.jadwal.JadwalDetails;

public interface JadwalDetailRepo extends CrudRepository<JadwalDetails, Long>{
    
}
