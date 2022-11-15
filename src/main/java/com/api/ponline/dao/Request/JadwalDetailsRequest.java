package com.api.ponline.dao.Request;

import java.util.Date;

import javax.validation.constraints.NotNull;
import com.api.ponline.model.Entity.kolam.Kolam;
import com.api.ponline.model.Entity.komunitas.Anggota;

public class JadwalDetailsRequest {
    private Long id;

    @NotNull(message = "Tanggal Pelaksaan tidak boleh kosong")
    private Date dateToDo;
    
    @NotNull(message = "Kolam tidak boleh kosong")
    private Kolam kolam;

    @NotNull(message = "Anggota tidak boleh kosong")
    private Anggota anggota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateToDo() {
        return dateToDo;
    }

    public void setDateToDo(Date dateToDo) {
        this.dateToDo = dateToDo;
    }

    public Kolam getKolam() {
        return kolam;
    }

    public void setKolam(Kolam kolam) {
        this.kolam = kolam;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    

}
