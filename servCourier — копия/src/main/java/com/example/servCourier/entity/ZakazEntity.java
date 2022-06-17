package com.example.servCourier.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class ZakazEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZakazi;
    private String nameBlyuda;
    private String adress;
    private String statusZakaz;
    @ManyToOne
    @JoinColumn(name = "id_courier")
    private CourierEntity courier;

    public ZakazEntity() {
    }

    public Long getIdZakazi() {
        return idZakazi;
    }

    public void setIdZakazi(Long idZakazi) {
        this.idZakazi = idZakazi;
    }

    public String getNameBlyuda() {
        return nameBlyuda;
    }

    public void setNameBlyuda(String nameBlyuda) {
        this.nameBlyuda = nameBlyuda;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatusZakaz() {
        return statusZakaz;
    }

    public void setStatusZakaz(String statusZakaz) {
        this.statusZakaz = statusZakaz;
    }

    public CourierEntity getCourier() {
        return courier;
    }

    public void setCourier(CourierEntity courier) {
        this.courier = courier;
    }
}
