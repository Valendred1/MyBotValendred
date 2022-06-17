package com.example.servCourier.repository;

import com.example.servCourier.entity.ZakazEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ZakaziRepository extends CrudRepository<ZakazEntity, Long>{
        Optional<ZakazEntity> findById(Long zakazId);

}
