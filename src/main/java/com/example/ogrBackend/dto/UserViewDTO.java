package com.example.ogrBackend.dto;

import com.example.ogrBackend.model.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public final class UserViewDTO implements Serializable {

    private static final long Id = 1L;

    private final String firstName;
    private final String lastName;

    private UserViewDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getFirstname(), user.getLastname());
    }



}
