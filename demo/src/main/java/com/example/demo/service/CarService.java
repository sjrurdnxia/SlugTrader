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
    private CarRepository carRepository;  // Inject CarRepository

    public List<Car> getAllCars() {
        return carRepository.findAll();  // Use JpaRepository method to fetch all cars
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);  // Use JpaRepository method to find a car by id
    }

    public Car createCar(Car car) {
        return carRepository.save(car);  // Save the new car in the database
    }

    public Car updateCar(Long id, Car carDetails) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setMake(carDetails.getMake());
                    car.setModel(carDetails.getModel());
                    car.setManufactureYear(carDetails.getManufactureYear());
                    car.setPrice(carDetails.getPrice());
                    car.setOwnerId(carDetails.getOwnerId());
                    return carRepository.save(car);  // Save the updated car in the database
                })
                .orElse(null);  // Return null if the car is not found
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);  // Delete the car by id
    }
}
