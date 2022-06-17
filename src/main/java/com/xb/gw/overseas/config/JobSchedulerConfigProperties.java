package com.xb.gw.overseas.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "xe.scheduler.job")
@Getter
@Setter
public class JobSchedulerConfigProperties {

    private String overseasEndpointUrl;
    private long overseasEndpointTimeoutInSeconds;
    private int overseasLookupJobSchedulerChunkSize;

}
