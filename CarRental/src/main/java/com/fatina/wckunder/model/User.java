package com.fatina.wckunder.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String adress;
    private String userLegalName;
    @OneToMany(mappedBy = "userId", cascade = CascadeType.PERSIST)
    private List<Booking> userBookings = new ArrayList<>();
    public User() {
    }
    public User(String userName, String adress, String userLegalName, List<Booking> userBookings) {
        this.userName = userName;
        this.adress = adress;
        this.userLegalName = userLegalName;
        this.userBookings = userBookings;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Booking> getUserBookings() {
        return userBookings;
    }

    public void setUserBookings(List<Booking> userBookings) {
        this.userBookings = userBookings;
    }

    public String getUserLegalName() {
        return userLegalName;
    }

    public void setUserLegalName(String userLegalName) {
        this.userLegalName = userLegalName;
    }
}
