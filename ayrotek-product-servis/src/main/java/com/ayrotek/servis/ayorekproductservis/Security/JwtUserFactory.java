package com.ayrotek.servis.ayorekproductservis.Security;

import com.ayrotek.servis.ayorekproductservis.enums.EnumRoles;
import com.ayrotek.servis.ayorekproductservis.model.Person;
import com.ayrotek.servis.ayorekproductservis.model.PersonRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {


    public static JwtUser create(Person person) {
        return new JwtUser(
                person.getId(),
                person.getFirstname(),
                person.getLastname(),
                person.getEmail(),
                person.getActive(),
                person.getPassword(),
                mapToGrantedAuthority(person.getPersonRoles())

        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<EnumRoles> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toList());
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<PersonRole> roleList) {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleList.forEach(userRole -> authorityList.add(new SimpleGrantedAuthority(userRole.getRole().name())));
        return authorityList;
    }
}