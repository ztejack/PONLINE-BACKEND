package com.api.ponline.dao.Request;

import javax.validation.constraints.NotNull;

import com.api.ponline.model.Entity.komunitas.Komunitas;

public class KolamRequest {
    private Long id;

    @NotNull(message = "Nama Tidak Boleh Kosong")
    private String name;
    
    @NotNull(message = "Komunitas Tidak Boleh Kosong")
    private Komunitas komunitas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Komunitas getKomunitas() {
        return komunitas;
    }

    public void setKomunitas(Komunitas komunitas) {
        this.komunitas = komunitas;
    }

    
    
}
