package com.example.servCourier.entity;


import com.example.servCourier.model.Zakaz;

import javax.persistence.*;
import java.util.List;

@Entity
public class CourierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCouriers;
    private String firstName;
    private String secondName;
    private String telegramId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courier")
    private List<ZakazEntity> zakazi;

    public CourierEntity() {
    }

    public List<ZakazEntity> getZakazi() {
        return zakazi;
    }

    public void setZakazi(List<ZakazEntity> zakazi) {
        this.zakazi = zakazi;
    }

    public Long getIdCouriers() {
        return idCouriers;
    }

    public void setIdCouriers(Long idCouriers) {
        this.idCouriers = idCouriers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }
}
