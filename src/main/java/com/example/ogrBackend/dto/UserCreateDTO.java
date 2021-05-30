package com.example.ogrBackend.dto;

import com.example.ogrBackend.validator.UniqueUserName;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {
    @NotNull(message = "{backend.constraints.userName.NotNull.message}")
    @Size(min = 4, max = 16, message = "{backend.constraints.userName.Size.message}")
    @UniqueUserName
    private String userName;

    @NotNull(message = "{backend.constraints.firstName.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

}
