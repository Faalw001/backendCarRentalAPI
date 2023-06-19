package com.fatina.wckunder.controller;

import com.fatina.wckunder.model.Booking;
import com.fatina.wckunder.model.Car;

import com.fatina.wckunder.repo.CarRepository;
import com.fatina.wckunder.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    @PostMapping(value="/addcar")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        return new ResponseEntity<Car>(carService.saveCar(car), HttpStatus.CREATED);
    }
    @GetMapping(value="/cars")
    public List<Car> getAllCars(){return carService.getAllCars();}

    @PutMapping("/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.OK);
    }
@DeleteMapping("/deletecar")
public void deleteCar(@RequestBody Car car){
    carService.deleteCar(car);
}
}
