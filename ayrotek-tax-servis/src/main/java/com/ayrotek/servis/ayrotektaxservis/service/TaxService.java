package com.ayrotek.servis.ayrotektaxservis.service;


import com.ayrotek.servis.ayrotektaxservis.Repo.LogRepository;
import com.ayrotek.servis.ayrotektaxservis.utils.CustomLogger;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxService implements ITaxService {
    private final TaxUtil taxUtil;
    private final CustomLogger customLogger;
    Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    @Override
    public double calculateTax(double price) {
        customLogger.info("Tax Calculated");

        return this.taxUtil.calculateTax(price);
    }


}
