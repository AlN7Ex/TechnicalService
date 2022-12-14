package com.example.springboothiber.repositories;

import com.example.springboothiber.model.entity.Car;
import com.example.springboothiber.model.entity.Owner;
import com.example.springboothiber.model.response.CarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Car getCarById(Long id);

    @Query(value = "SELECT service.cars.id, brand, model, owner_id " +
            "FROM service.cars", nativeQuery = true)
    List<Car> getAllCars();

    List<Car> getCarsByOwnerId(Long id);
}
