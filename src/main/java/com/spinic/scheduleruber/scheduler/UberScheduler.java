package com.spinic.scheduleruber.scheduler;

import com.spinic.scheduleruber.model.Coordinate;
import com.spinic.scheduleruber.properties.CoordinateProperties;
import com.spinic.scheduleruber.service.UberService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UberScheduler {
    private final CoordinateProperties coordinateProperties;
    private final UberService uberService;

    @Timed("gettingPriceScheduler")
    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        Coordinate startPoint = new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        Coordinate endPoint = new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());
        uberService.getPrice(startPoint, endPoint);
    }
}
