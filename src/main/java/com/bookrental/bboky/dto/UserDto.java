package com.bookrental.bboky.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {
    @NotEmpty(message = "Nom d'utilisateur ne doit pas être vide")
    private String username;
    @NotEmpty(message = "Prénom ne doit pas être vide")
    private String firstname;
    @NotEmpty(message = "Nom ne doit pas être vide")
    private String lastname;
    @NotEmpty(message = "Mot de passe ne doit pas être vide")
    private String password;
    private String role;
}
