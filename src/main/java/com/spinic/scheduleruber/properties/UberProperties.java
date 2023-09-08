package com.spinic.scheduleruber.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "uber")
public class UberProperties {
    private String clId;
    private String apiKey;
}
