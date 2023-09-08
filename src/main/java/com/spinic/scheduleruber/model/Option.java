package com.spinic.scheduleruber.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option {
    public String class_name;
    public String price_text;
    public double price;
    public double min_price;
    public double waiting_time;
}