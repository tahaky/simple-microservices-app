package com.ayrotek.servis.ayorekproductservis.Security;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

public class JwtUser implements UserDetails {

    public JwtUser(UUID userId, String firstname, String lastname, String email, boolean active, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.active = active;
        this.password = password;
        this.authorities = authorities;
    }
    private final UUID userId;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final boolean active;
    private final String password;
    @Enumerated(EnumType.STRING)
    private final Collection<? extends GrantedAuthority> authorities;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public UUID getId(){return userId;}
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
