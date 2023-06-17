package com.ayrotek.servis.ayrotektaxservis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class TaxUtil {
    private final WebClient webClient;

    public double calculateTax(double price) {
        //verginin %18 olduğu varsayılmıştır
        double taxPrice = price * 0.18;
        return taxPrice;
    }



}
