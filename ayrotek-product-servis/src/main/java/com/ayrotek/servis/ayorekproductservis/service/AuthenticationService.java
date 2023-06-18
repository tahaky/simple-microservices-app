package com.ayrotek.servis.ayorekproductservis.service;

import com.ayrotek.servis.ayorekproductservis.Security.JwtUser;
import com.ayrotek.servis.ayorekproductservis.Security.JwtUserFactory;
import com.ayrotek.servis.ayorekproductservis.Security.JwtUtil;
import com.ayrotek.servis.ayorekproductservis.Security.AuthenticationUtils.AuthenticationRequest;
import com.ayrotek.servis.ayorekproductservis.Security.AuthenticationUtils.AuthenticationResponse;
import com.ayrotek.servis.ayorekproductservis.Utils.AuthenticationServiceUtil;
import com.ayrotek.servis.ayorekproductservis.dto.PersonDTO;
import com.ayrotek.servis.ayorekproductservis.enums.EnumRoles;
import com.ayrotek.servis.ayorekproductservis.model.Person;
import com.ayrotek.servis.ayorekproductservis.model.PersonRole;
import com.ayrotek.servis.ayorekproductservis.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationServiceUtil authenticationServiceUtil;

    public AuthenticationResponse register(PersonDTO personDTO) {


        Person newPerson = authenticationServiceUtil.save(personDTO);
        log.info(newPerson + "is registered");
        JwtUser jwtUser = JwtUserFactory.create(newPerson);
        var jwt = jwtUtil.generateToken(jwtUser);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Optional<Person> person = null;

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        try {
            person = personRepository.findByEmail(request.getEmail());
        } catch (Exception e) {
            log.warn(e.toString());
        }

        JwtUser jwtUser = JwtUserFactory.create(person.get());
        var jwt = jwtUtil.generateToken(jwtUser);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }
}
