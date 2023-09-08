package com.spinic.scheduleruber.controller;

import com.spinic.scheduleruber.model.MomentPrice;
import com.spinic.scheduleruber.service.UberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PriceController {
    private final UberService uberService;

    @GetMapping("/prices")
    public List<MomentPrice> getAllPricesFromDb() {
        return uberService.getAllPrices();
    }
}
