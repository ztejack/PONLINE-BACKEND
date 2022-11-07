package com.api.ponline.model.Entity.jadwal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_JADWAL")
public class Jadwal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pnirdkvqyp")
    private Long id;

    @Column(name = "wfyjktacdf")
    private Integer mingguKe;

    @Column(name = "looywmotvr")
    private Date startDate;

    @Column(name = "lqibqouhix")
    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMingguKe() {
        return mingguKe;
    }

    public void setMingguKe(Integer mingguKe) {
        this.mingguKe = mingguKe;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    
    
}
