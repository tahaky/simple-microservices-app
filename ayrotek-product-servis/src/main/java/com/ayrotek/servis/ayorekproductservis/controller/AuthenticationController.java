package com.ayrotek.servis.ayorekproductservis.controller;


import com.ayrotek.servis.ayorekproductservis.Security.AuthenticationUtils.AuthenticationRequest;
import com.ayrotek.servis.ayorekproductservis.Security.AuthenticationUtils.AuthenticationResponse;
import com.ayrotek.servis.ayorekproductservis.dto.PersonDTO;
import com.ayrotek.servis.ayorekproductservis.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody PersonDTO personDto) {
        return ResponseEntity.ok(authenticationService.register(personDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> AuthenticationRequest(@RequestBody AuthenticationRequest request) {
        System.out.println(request);
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
