package com.example.servCourier.controller;

import com.example.servCourier.Bot.MyBot;
import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.entity.ZakazEntity;
import com.example.servCourier.model.Zakaz;
import com.example.servCourier.repository.CourierRepository;
import com.example.servCourier.repository.ZakaziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zakazi")
public class ZakaziController {
    @Autowired
    private ZakaziRepository zakaziRepository;
    @PostMapping
    public ResponseEntity registration(@RequestBody ZakazEntity zakaz){
        try {
            zakaziRepository.save(zakaz);
            MyBot myBot = MyBot.getInstance();
            myBot.zakazToCouriers(Zakaz.toModel(zakaz));
            return ResponseEntity.ok("Заказ успешно сохранен");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public ResponseEntity getZakazi() {
        try {
            return ResponseEntity.ok("Сервер работает!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
