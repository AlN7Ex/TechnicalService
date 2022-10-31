package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.Car;
import com.example.springboothiber.model.request.CarRequest;
import com.example.springboothiber.model.response.CarResponse;
import com.example.springboothiber.repositories.CarRepository;
import com.example.springboothiber.repositories.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository repository;
    private final OwnerRepository ownerRepository;

    @Override
    public CarResponse read(Long id) {
        Car carById = repository.getCarById(id);

        return new CarResponse(
                carById.getId(),
                carById.getBrand(),
                carById.getModel()
        );
    }

    @Override
    public List<CarResponse> readAll() {
        List<Car> allCars = repository.getAllCars();

        return allCars.stream()
                .map(car -> new CarResponse(
                        car.getId(),
                        car.getBrand(),
                        car.getModel()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public CarResponse create(CarRequest request, Long id) {
        Car car = new Car();
        car.setBrand(request.getBrand());
        car.setModel(request.getModel());
        car.setOwner(ownerRepository.getOwnerById(id));

        Car saved = repository.save(car);

        return new CarResponse(
                saved.getId(),
                saved.getBrand(),
                saved.getModel()
        );
    }

    @Override
    public boolean update(CarRequest request, Long id) {
        Car carById = repository.getCarById(id);

        if (carById != null) {
            carById.setBrand(request.getBrand());
            carById.setModel(request.getModel());

            repository.save(carById);

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        }
        return false;
    }

    @Override
    public List<CarResponse> readOwnerCars(Long id) {

        List<Car> carsByOwnerId = repository.getCarsByOwnerId(id);

        return carsByOwnerId.stream()
                .map(car -> new CarResponse(
                        car.getId(),
                        car.getBrand(),
                        car.getModel()
                ))
                .collect(Collectors.toList());
    }
}
