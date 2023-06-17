package com.ayrotek.servis.ayrotektaxservis.service;

import com.ayrotek.servis.ayrotektaxservis.domain.model.Tax;

import java.util.List;
import java.util.UUID;

public interface ITaxService {
    public double calculateTax(double price);

}
