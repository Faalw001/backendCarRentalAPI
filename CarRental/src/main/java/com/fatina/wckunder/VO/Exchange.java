package com.fatina.wckunder.VO;


public class Exchange {
    private double price;
    private double exchangePrice;

    public Exchange() {
    }

    public Exchange( double price, double exchangePrice) {
        this.exchangePrice = exchangePrice;
        this.price = price;
    }

    public double getExchangePrice() {
        return exchangePrice;
    }

    public void setExchangePrice(double exchangePrice) {
        this.exchangePrice = exchangePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



