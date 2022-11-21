package com.example.springboothiber.services;

import com.example.springboothiber.model.request.CarRequest;
import com.example.springboothiber.model.response.CarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    CarResponse read(Long id);
    List<CarResponse> readAll();
    CarResponse create(CarRequest request, Long id);
    boolean update(CarRequest request, Long id);
    boolean delete(Long id);

    List<CarResponse> readUserCars(Long ownerId);

}
