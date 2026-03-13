package com.example.Crud_AuthN_oAuth2.Auth.Service;

import com.example.Crud_AuthN_oAuth2.Auth.Dto.AUserDto;

public interface AUserService {
    AUserDto saveDetails(AUserDto aUserDto);
    String getUserByEmail(AUserDto aUserDto);
}
