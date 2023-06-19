package com.fatina.wckunder.repo;

import com.fatina.wckunder.model.Car;

import java.util.List;

public interface CarServiceRepository {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Car getCarById(int id);

    Car updateCar(Car car);
    Void deleteCar(Car car);

}
