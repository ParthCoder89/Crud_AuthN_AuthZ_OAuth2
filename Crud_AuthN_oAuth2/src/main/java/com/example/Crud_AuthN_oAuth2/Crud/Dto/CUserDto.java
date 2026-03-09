package com.example.Crud_AuthN_oAuth2.Crud.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
