package com.bookrental.bboky.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
}
