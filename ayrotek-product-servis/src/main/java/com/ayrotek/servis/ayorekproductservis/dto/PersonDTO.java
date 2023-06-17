package com.ayrotek.servis.ayorekproductservis.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private UUID id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
