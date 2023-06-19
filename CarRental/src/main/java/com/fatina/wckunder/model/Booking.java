package com.fatina.wckunder.model;

import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateKeyDeserializer;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int bookingId;
        private int days;
        private int price;

        private LocalDate startDay;
        private LocalDate endDay;
        private int userId;
        private int carId;

        private boolean canceled;

        public Booking() {
        }

    public Booking(int days, int price, LocalDate startDay, LocalDate endDay, int userId, int carId, boolean canceled) {
        this.days = days;
        this.price = price;
        this.startDay = startDay;
        this.endDay = endDay;
        this.userId = userId;
        this.carId = carId;
        this.canceled = canceled;
    }

    public int getBookingId() {
                return bookingId;
        }

        public void setBookingId(int bookingId) {
                this.bookingId = bookingId;
        }

        public int getDays() {
                return days;
        }

        public void setDays(int days) {
                this.days = days;
        }

        public int getPrice() {
                return price;
        }

        public void setPrice(int price) {
                this.price = price;
        }

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public int getCarId() {
                return carId;
        }

        public void setCarId(int carId) {
                this.carId = carId;
        }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}


