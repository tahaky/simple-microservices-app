package com.ayrotek.servis.ayorekproductservis.configration;

import com.ayrotek.servis.ayorekproductservis.Security.JwtUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;


public class AuditorAwareImpl implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        final Object principal = authentication.getPrincipal();
        if (principal instanceof JwtUser) {
            System.out.println(principal);
            return Optional.ofNullable(((JwtUser) principal).getId());
        }
        return null;
    }

}
