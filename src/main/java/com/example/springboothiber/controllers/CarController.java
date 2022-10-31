package com.example.springboothiber.controllers;

import com.example.springboothiber.model.request.CarRequest;
import com.example.springboothiber.model.response.CarResponse;
import com.example.springboothiber.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping(value = "/cars/{id}")
    public CarResponse getCarById(@PathVariable Long id) {
       return service.read(id);
    }


    @GetMapping(value = "/cars/")
    public List<CarResponse> getOwnersCars() {
        return service.readAll();
    }

    @PostMapping(value = "/cars/{id}")
    public CarResponse addCar(@RequestBody CarRequest request, @PathVariable Long id) {
        return service.create(request, id);
    }

    @GetMapping(value = "/cars")
    public List<CarResponse> getCarsByOwnerId(@RequestParam Long ownerId) {
        return service.readOwnerCars(ownerId);
    }

    @DeleteMapping(value = "/cars/{id}")
    public boolean deleteCar(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(value = "/cars/{id}")
    public boolean updateCar(@RequestBody CarRequest request, @PathVariable Long id) {
        return service.update(request, id);
    }
}
