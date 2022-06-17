package com.example.servCourier.repository;

import com.example.servCourier.entity.CourierEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourierRepository extends CrudRepository<CourierEntity, Long> {
    CourierEntity findByTelegramId(String telegramId);
}
