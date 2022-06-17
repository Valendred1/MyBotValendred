package com.example.servCourier.service;

import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.entity.ZakazEntity;
import com.example.servCourier.exception.CourierAlreadyExistException;
import com.example.servCourier.exception.CourierNotFoundException;
import com.example.servCourier.model.Courier;
import com.example.servCourier.model.Zakaz;
import com.example.servCourier.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CourierService {
    @Autowired
    private CourierRepository courierRepository;
    public CourierEntity registration(CourierEntity courierEntity) throws CourierAlreadyExistException {

        if (courierRepository.findByTelegramId(courierEntity.getTelegramId())!=null){
            throw  new CourierAlreadyExistException("Такой пользователь существует");
        }
        System.out.println(courierEntity.getFirstName());
       return courierRepository.save(courierEntity);
    }
    public Courier getOne(Long id) throws CourierNotFoundException {
        CourierEntity courier = courierRepository.findById(id).get();
       if (courier==null){
           throw new CourierNotFoundException("Пользователь не найден");
       }
       return Courier.toModel(courier);
    }
    public Long delete(Long id){
        courierRepository.deleteById(id);
        return id;
    }

    public List<Zakaz> getZakazi(Long id){
        List<ZakazEntity> zakazdo=courierRepository.findById(id).get().getZakazi();
        List<Zakaz> zakazposle=new ArrayList<>();
        for (ZakazEntity zakaz:zakazdo
             ) {zakazposle.add(Zakaz.toModel(zakaz));

        }

        return zakazposle;
    }
    public List<Courier> getAll(){
        Iterator<CourierEntity> iterator= courierRepository.findAll().iterator();
        ArrayList<Courier> couriers = new ArrayList<>();
       while (iterator.hasNext()){
           couriers.add(Courier.toModel(iterator.next()));
       }
       return couriers;
    }

}
