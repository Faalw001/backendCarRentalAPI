package com.fatina.exchangeproject.controller;

import com.fatina.exchangeproject.model.Exchange;
import com.fatina.exchangeproject.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/{price}")

    public Exchange exchange(@PathVariable("price")double price){
       Exchange exchange =  exchangeService.findExchangePrice(price);
       return exchange;
    }

}
