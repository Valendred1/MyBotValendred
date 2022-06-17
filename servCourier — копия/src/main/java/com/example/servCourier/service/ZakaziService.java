package com.example.servCourier.service;

import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.entity.ZakazEntity;
import com.example.servCourier.model.Courier;
import com.example.servCourier.model.Zakaz;
import com.example.servCourier.repository.ZakaziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class ZakaziService {
    @Autowired
    private ZakaziRepository zakaziRepository;
    public ZakazEntity newzakaz(ZakazEntity zakazEntity) {
        return zakaziRepository.save(zakazEntity);
    }
    public Zakaz getLast(){
        Iterator<ZakazEntity> iterator= zakaziRepository.findAll().iterator();
        int i=0;
        ArrayList<Zakaz> zakazi = new ArrayList<>();
        while (iterator.hasNext()){
            zakazi.add(Zakaz.toModel(iterator.next()));
            i++;
        }
        return zakazi.get(i);
    }
}
