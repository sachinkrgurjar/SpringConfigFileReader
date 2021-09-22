package com.sachin.springConfigReader.properties;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="server-details")
@Getter
@Setter

public class AppProperties {
    private String ipAddress;
    private String port;
    private String serverName;

}
