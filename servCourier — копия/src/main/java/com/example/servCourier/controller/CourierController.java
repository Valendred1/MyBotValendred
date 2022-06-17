package com.example.servCourier.controller;

import com.example.servCourier.entity.CourierEntity;
import com.example.servCourier.entity.ZakazEntity;
import com.example.servCourier.exception.CourierAlreadyExistException;
import com.example.servCourier.exception.CourierNotFoundException;
import com.example.servCourier.model.Zakaz;
import com.example.servCourier.repository.CourierRepository;
import com.example.servCourier.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {
@Autowired
private CourierService courierService;
    @PostMapping
    public ResponseEntity registration(@RequestBody CourierEntity courier){
        try {
            courierService.registration(courier);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (CourierAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
    }}
    @GetMapping
    public ResponseEntity getOneCourier(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(courierService.getOne(id));
        } catch (CourierNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/list")
    public ResponseEntity getZakazi(@RequestParam Long id){

        try {
            return ResponseEntity.ok(courierService.getZakazi(id));

        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourier(@PathVariable Long id){
        try {
            return ResponseEntity.ok(courierService.delete(id));

        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}