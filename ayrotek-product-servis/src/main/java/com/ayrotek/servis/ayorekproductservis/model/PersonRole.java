package com.ayrotek.servis.ayorekproductservis.model;

import com.ayrotek.servis.ayorekproductservis.enums.EnumRoles;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "person_role")
public @Data
class PersonRole extends BaseModel {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    public PersonRole() {
    }

    public PersonRole(EnumRoles role) {
        this.role = role;
    }

    @Column(name = "role_name", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private EnumRoles role;
}