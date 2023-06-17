package com.ayrotek.servis.ayrotektaxservis.rest;

import com.ayrotek.servis.ayrotektaxservis.Repo.LogRepository;
import com.ayrotek.servis.ayrotektaxservis.domain.model.Tax;
import com.ayrotek.servis.ayrotektaxservis.service.TaxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/tax")
@RestController
@RequiredArgsConstructor
public class TaxController {
    private final TaxService taxService;
    private final LogRepository logRepository;

    @GetMapping("/{price}")
    public double calculateTax(@PathVariable(name = "price") double price) {
        return this.taxService.calculateTax(price);
    }
}
