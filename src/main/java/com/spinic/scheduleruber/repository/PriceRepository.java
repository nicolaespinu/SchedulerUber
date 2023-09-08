package com.spinic.scheduleruber.repository;

import com.spinic.scheduleruber.model.MomentPrice;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriceRepository extends CrudRepository<MomentPrice, Long> {
    @Timed(description = "gettingAllPricesFromDB")
    List<MomentPrice> findAll();
}
