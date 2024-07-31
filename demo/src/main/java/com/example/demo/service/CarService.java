package com.example.demo.service;

import com.example.demo.api.model.Car;
import com.example.demo.api.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setManufactureYear(carDetails.getManufactureYear());
            car.setPrice(carDetails.getPrice());
            car.setOwnerId(carDetails.getOwnerId());
            return carRepository.save(car);
        } else {
            return null;
        }
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> getCarsByOwnerId(Long ownerId) {
        return carRepository.findByOwnerId(ownerId);
    }
}
