package com.example.springboothiber.services;

import com.example.springboothiber.request.CarRequest;
import com.example.springboothiber.response.CarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    CarResponse getCar(Long id);
    List<CarResponse> getOwnersCars();
    CarResponse addCar(CarRequest request);
}
