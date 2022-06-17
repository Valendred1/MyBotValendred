package com.example.servCourier.model;

import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.entity.ZakazEntity;

public class Zakaz {
    private Long id;
    private String adress;
    private String name_blyuda;
    private String status_zakaz;
    public static Zakaz toModel(ZakazEntity entity){
        Zakaz model = new Zakaz();
        model.setId(entity.getIdZakazi());
        model.setAdress(entity.getAdress());
        model.setName_blyuda(entity.getNameBlyuda());
        model.setStatus_zakaz(entity.getStatusZakaz());
        return model;
    }
    public Zakaz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName_blyuda() {
        return name_blyuda;
    }

    public void setName_blyuda(String name_blyuda) {
        this.name_blyuda = name_blyuda;
    }

    public String getStatus_zakaz() {
        return status_zakaz;
    }

    public void setStatus_zakaz(String status_zakaz) {
        this.status_zakaz = status_zakaz;
    }
}
