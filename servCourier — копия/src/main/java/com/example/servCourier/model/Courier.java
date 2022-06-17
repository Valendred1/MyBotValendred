package com.example.servCourier.model;

import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.entity.ZakazEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Courier {
    private Long id;
    private String firstName;
    private String secondName;
    private String idTelegram;
//    private List<Zakaz> zakazi;
    public static Courier toModel(CourierEntity entity){
        Courier model = new Courier();
        model.setId(entity.getIdCouriers());
        model.setFirstName(entity.getFirstName());
        model.setSecondName(entity.getSecondName());
        model.setIdTelegram(entity.getTelegramId());

        return model;
    }
    public Courier() {
    }

//    public List<Zakaz> getZakazi() {
//        return zakazi;
//    }
//
//    public void setZakazi(List<Zakaz> zakazi) {
//        this.zakazi = zakazi;
//    }

    public String getIdTelegram() {
        return idTelegram;
    }

    public void setIdTelegram(String idTelegram) {
        this.idTelegram = idTelegram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
