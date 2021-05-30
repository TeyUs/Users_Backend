package com.example.ogrBackend.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public final class GenericResponse {
    private String message;
    private LocalDate date;

    public GenericResponse(String message){
        this.message = message;
        date = LocalDate.now();
    }
}
