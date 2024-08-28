package com.example.demo.service;

import com.example.demo.api.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getAllCars() {
        return cars;
    }

    public Optional<Car> getCarById(Long id) {
        return cars.stream().filter(car -> car.getId().equals(id)).findFirst();
    }

    public Car createCar(Car car) {
        car.setId((long) (cars.size() + 1));
        cars.add(car);
        return car;
    }

    public Car updateCar(Long id, Car carDetails) {
        Optional<Car> carOptional = getCarById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setManufactureYear(carDetails.getManufactureYear());
            car.setPrice(carDetails.getPrice());
            car.setOwnerId(carDetails.getOwnerId());
            return car;
        }
        return null;
    }

    public void deleteCar(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }
}
