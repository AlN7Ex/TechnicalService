package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.Car;
import com.example.springboothiber.model.request.CarRequest;
import com.example.springboothiber.model.response.CarResponse;
import com.example.springboothiber.repositories.CarRepository;
import com.example.springboothiber.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public CarResponse read(Long id) {
        Car carById = carRepository.getCarById(id);

        return new CarResponse(
                carById.getId(),
                carById.getBrand(),
                carById.getModel()
        );
    }

    @Override
    public List<CarResponse> readAll() {
        List<Car> allCars = carRepository.getAllCars();

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
        car.setUser(userRepository.getUserById(id));

        Car saved = carRepository.save(car);

        return new CarResponse(
                saved.getId(),
                saved.getBrand(),
                saved.getModel()
        );
    }

    @Override
    public boolean update(CarRequest request, Long id) {
        Car carById = carRepository.getCarById(id);

        if (carById != null) {
            carById.setBrand(request.getBrand());
            carById.setModel(request.getModel());

            carRepository.save(carById);

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);

            return true;
        }
        return false;
    }

//    @Override
//    public List<CarResponse> readUserCars(Long id) {
//
//        List<Car> carsByUserId = carRepository.getCarsByUserId(id);
//
//        return carsByUserId.stream()
//                .map(car -> new CarResponse(
//                        car.getId(),
//                        car.getBrand(),
//                        car.getModel()
//                ))
//                .collect(Collectors.toList());
//    }
}
