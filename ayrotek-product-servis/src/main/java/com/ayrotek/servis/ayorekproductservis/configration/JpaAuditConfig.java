package com.ayrotek.servis.ayorekproductservis.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditConfig {
    @Bean
    public AuditorAware<UUID> auditorAware() {
        return new AuditorAwareImpl();
    }
}
