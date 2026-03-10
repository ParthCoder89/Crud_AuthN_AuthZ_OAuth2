package com.example.Crud_AuthN_oAuth2.Crud.Mapper;

import com.example.Crud_AuthN_oAuth2.Crud.Dto.CUserDto;
import com.example.Crud_AuthN_oAuth2.Crud.entity.CUserData;

public class CUserMapper {
    public static CUserData dtoToEntity(CUserDto cUserDto){
        CUserData cUserData = new CUserData();
        cUserData.setId(cUserDto.getId());
        cUserData.setFirstName(cUserDto.getFirstName());
        cUserData.setLastName(cUserDto.getLastName());
        cUserData.setEmail(cUserDto.getEmail());
        cUserData.setPassword(cUserDto.getPassword());
        return cUserData;
    }
    public static CUserDto entityToDto(CUserData cUserData){
        CUserDto cUserDto = new CUserDto();
        cUserDto.setId(cUserData.getId());
        cUserDto.setFirstName(cUserData.getFirstName());
        cUserDto.setLastName(cUserData.getLastName());
        cUserDto.setEmail(cUserData.getEmail());
        cUserDto.setPassword(cUserData.getPassword());
        return cUserDto;
    }
}
