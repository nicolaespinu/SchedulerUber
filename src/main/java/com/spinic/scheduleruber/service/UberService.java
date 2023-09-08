package com.spinic.scheduleruber.service;

import com.spinic.scheduleruber.apiclient.UberApiClient;
import com.spinic.scheduleruber.model.Coordinate;
import com.spinic.scheduleruber.model.MomentPrice;
import com.spinic.scheduleruber.model.Price;
import com.spinic.scheduleruber.properties.UberProperties;
import com.spinic.scheduleruber.repository.PriceRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UberService {
    private final UberProperties uberProperties;
    private final UberApiClient uberApiClient;
    private final PriceRepository priceRepository;
    private AtomicInteger price;

    public UberService(UberProperties uberProperties, UberApiClient uberApiClient, PriceRepository priceRepository, MeterRegistry meterRegistry) {
        this.uberProperties = uberProperties;
        this.uberApiClient = uberApiClient;
        this.priceRepository = priceRepository;
        price = new AtomicInteger();
        meterRegistry.gauge("priceUber", price);
    }

    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        String rll = startPoint.toString() + "~" + endPoint.toString();
        String clId = uberProperties.getClId();
        String apiKey = uberProperties.getApiKey();

        /**
         * In case you don't have parameters clId, apiKey,
         * just comment Line #43 and uncomment #41 for testing purpose.
         */
        //Price currentPrice = new Price("MDL", 203.0, List.of(new Option("ECONOM", "240 MDL", 298, 230, 18)), "24");

        Price currentPrice = uberApiClient.getPrices(clId, apiKey, rll);
        if (currentPrice.getOptions().isEmpty()) {
            throw new RuntimeException("Options is null!");
        }
        double priceDouble = currentPrice.getOptions().get(0).getPrice();
        price.set((int) priceDouble);
        MomentPrice momentPrice = new MomentPrice(
                LocalDateTime.now(ZoneId.of("Europe/Bucharest")),
                priceDouble);
        priceRepository.save(momentPrice);
    }

    public List<MomentPrice> getAllPrices() {
        return priceRepository.findAll();
    }
}
