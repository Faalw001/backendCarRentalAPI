package com.fatina.wckunder.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private int pricePerDay;
    private String model;
    private String carName;

    @OneToMany(mappedBy = "carId", cascade = CascadeType.PERSIST)
    private List<Booking> carBookings = new ArrayList<>();

    public Car() {
    }

    public Car(int pricePerDay, String model, List<Booking> carBookings, String carName) {
        this.pricePerDay = pricePerDay;
        this.model = model;
        this.carBookings = carBookings;
        this.carName = carName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
