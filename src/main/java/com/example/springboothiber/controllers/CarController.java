package com.example.springboothiber.controllers;

import com.example.springboothiber.response.CarResponse;
import com.example.springboothiber.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController(value = "/owner/{id}")
@AllArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping(value = "/cars/{id}")
    public CarResponse getCarById(@PathVariable Long id) {
       return service.getCar(id);
    }

    @GetMapping(value = "/cars")
    public List<CarResponse> getOwnersCars() {
        return null;
    }
}
