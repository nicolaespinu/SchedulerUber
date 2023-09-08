package com.spinic.scheduleruber.apiclient;

import com.spinic.scheduleruber.model.Price;
import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "uberclient", url = "${uber.url}")
public interface UberApiClient {
    @Timed(description = "gettingAllPricesFromUber")
    @GetMapping
    Price getPrices(@RequestParam String clId, @RequestParam String apiKey, @RequestParam String rll);
}
