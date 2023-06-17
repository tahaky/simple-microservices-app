package com.ayrotek.servis.ayorekproductservis.service;

import com.ayrotek.servis.ayorekproductservis.Security.JwtUser;
import com.ayrotek.servis.ayorekproductservis.Security.JwtUserFactory;
import com.ayrotek.servis.ayorekproductservis.Security.JwtUtil;
import com.ayrotek.servis.ayorekproductservis.Security.AuthenticationUtils.AuthenticationRequest;
import com.ayrotek.servis.ayorekproductservis.Security.AuthenticationUtils.AuthenticationResponse;
import com.ayrotek.servis.ayorekproductservis.dto.PersonDTO;
import com.ayrotek.servis.ayorekproductservis.enums.EnumRoles;
import com.ayrotek.servis.ayorekproductservis.model.Person;
import com.ayrotek.servis.ayorekproductservis.model.PersonRole;
import com.ayrotek.servis.ayorekproductservis.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(PersonDTO kullanici) {
        List<PersonRole> rolesList = new ArrayList<>();
        rolesList.add(new PersonRole(EnumRoles.ADMIN));

        var newPerson = Person.builder()
                .firstname(kullanici.getFirstname())
                .lastname(kullanici.getLastname())
                .password(passwordEncoder.encode(kullanici.getPassword()))
                .email(kullanici.getEmail())
                .personRoles(rolesList)
                .Active(true)
                .build();
        personRepository.save(newPerson);


        JwtUser jwtUser = JwtUserFactory.create(newPerson);

        var jwt = jwtUtil.generateToken(jwtUser);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMail(),
                        request.getPassword()
                )
        );

        var user = personRepository.findByEmail(request.getMail())
                .orElseThrow();
      user.setEmail(request.getMail());

        JwtUser jwtUser = JwtUserFactory.create(user);
        var jwt = jwtUtil.generateToken(jwtUser);
        return AuthenticationResponse.builder()
                .tokken(jwt)
                .build();
    }
}
