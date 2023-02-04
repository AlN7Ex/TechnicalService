package com.example.springboothiber.services;

import com.example.springboothiber.model.entity.Car;
import com.example.springboothiber.model.entity.User;
import com.example.springboothiber.model.request.CarRequest;
import com.example.springboothiber.model.response.CarResponse;
import com.example.springboothiber.repositories.CarRepository;
import com.example.springboothiber.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    //Maybe need to use Facade pattern
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public CarResponse read(Long id) {
        Car car = carRepository.findCarById(id);
        if (car == null) {
            return null;
        }

        return new CarResponse(car.getBrand(), car.getModel());
    }

    @Override
    public List<CarResponse> readAll() {
        List<Car> cars = carRepository.findAll();
        if (cars == null) {
            return null;
        }

        return cars.stream()
                .map(car -> new CarResponse(car.getBrand(), car.getModel()))
                .toList();
    }


    @Override
    public boolean create(CarRequest request, Long id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            return false;
        }

        carRepository.save(new Car(request.getBrand(), request.getModel(), user));

        return true;
    }

    @Override
    public boolean update(CarRequest request, Long id) {
        Car carById = carRepository.findCarById(id);

        if (carById == null) {
            return false;
        }
        carById.setBrand(request.getBrand());
        carById.setModel(request.getModel());
        carRepository.save(carById);

        return true;
    }

    @Override
    public boolean delete(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);

            return true;
        }
        return false;
    }
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
