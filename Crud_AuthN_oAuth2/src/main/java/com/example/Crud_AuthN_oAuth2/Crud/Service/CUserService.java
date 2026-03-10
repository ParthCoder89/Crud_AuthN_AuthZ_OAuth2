package com.example.Crud_AuthN_oAuth2.Crud.Service;

import com.example.Crud_AuthN_oAuth2.Crud.Dto.CUserDto;

import java.util.List;

public interface CUserService {
    CUserDto saveUser(CUserDto cUserDto);
    CUserDto getUser(Long id);
    List<CUserDto> getAllUsers();
    CUserDto updateUser(CUserDto cUserDto, Long id);
    String deleteUser(Long id);
}
