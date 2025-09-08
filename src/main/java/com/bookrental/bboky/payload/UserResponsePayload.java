package com.bookrental.bboky.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponsePayload {
    private String username;
    private String message;
}
