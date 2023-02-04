package com.example.springboothiber.repositories;

import com.example.springboothiber.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

//    Car getCarById(Long id);
    Car findCarById(Long id);

//    @Query(value = "SELECT service s .cars.brand, model " +
//            "FROM service.cars", nativeQuery = true)
    List<Car> findAll();

//    List<Car> getCarsByUserId(Long id);

    boolean deleteCarById(Long id);
}
