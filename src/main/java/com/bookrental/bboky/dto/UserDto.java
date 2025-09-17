package com.bookrental.bboky.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Nom d'utilisateur ne doit pas être vide")
    private String username;
    @NotBlank(message = "Prénom ne doit pas être vide")
    private String firstname;
    @NotBlank(message = "Nom ne doit pas être vide")
    private String lastname;
    @NotBlank(message = "Mot de passe ne doit pas être vide")
    private String password;
    private String role;
}
