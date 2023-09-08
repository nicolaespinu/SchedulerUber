package com.spinic.scheduleruber.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Price {
    public String currency;
    public double distance;
    public List<Option> options;
    public String time_text;
}
