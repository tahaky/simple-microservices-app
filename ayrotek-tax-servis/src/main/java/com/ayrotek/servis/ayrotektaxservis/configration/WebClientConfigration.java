package com.ayrotek.servis.ayrotektaxservis.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfigration {

    @Bean
    public WebClient webClient() {
        return WebClient.
                builder().build();
    }
}
