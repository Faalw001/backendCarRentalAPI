package com.fatina.exchangeproject.service;

import com.fatina.exchangeproject.model.Exchange;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    public Exchange findExchangePrice(double price){
        double priceinEuro=price * 11.6572;
        System.out.println("price " +price+"price in Euro " + priceinEuro);
        Exchange exchange = new Exchange( priceinEuro, price);
        return exchange;
    }
}
