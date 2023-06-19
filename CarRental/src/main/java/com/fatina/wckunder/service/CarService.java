package com.fatina.wckunder.service;

import com.fatina.wckunder.model.Car;
import com.fatina.wckunder.repo.CarRepository;
import com.fatina.wckunder.repo.CarServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceRepository {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> car = (carRepository.findById(id));
        if (car.isPresent()) {
            return car.get();
        } else {
            throw new RuntimeException();
        }
    }
    @Override
    public Car updateCar(Car car) {
        Car c = carRepository.findById(car.getCarId()).orElseThrow(() -> new RuntimeException("Car with id "+ car.getCarId() +" not found"));
        c.setCarId(car.getCarId());
        c.setModel(car.getModel());
        c.setCarName(car.getCarName());
        c.setPricePerDay(car.getPricePerDay());
        carRepository.save(c);
        return c;
    }

    @Override
    public Void deleteCar(Car car) {
        Car c = carRepository.findById(car.getCarId()).orElseThrow(() -> new RuntimeException("carid not found"));
        carRepository.delete(c);
        return null;
    }
}