package com.debuggeando_ideas.best_travel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value(value = "${api.base.url}")
    private String baseUrl;
    @Value(value = "${api.api-key}")
    private String apiKey;
    @Value(value = "${api.api-key.header}")
    private String apiKeyHeader;

    @Bean(name = "currency")
    public WebClient currencyWebClient(){
        return WebClient.builder()
                .baseUrl(this.baseUrl)
                .defaultHeader(this.apiKeyHeader, this.apiKey)
                .build();
    }

    @Bean(name = "base")
    public WebClient baseWebClient(){
        return WebClient.builder()
                .baseUrl(this.baseUrl)
                .defaultHeader(this.apiKeyHeader, this.apiKey)
                .build();
    }
}
