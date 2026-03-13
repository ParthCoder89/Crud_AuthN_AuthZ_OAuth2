package com.example.Crud_AuthN_oAuth2.Auth.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
