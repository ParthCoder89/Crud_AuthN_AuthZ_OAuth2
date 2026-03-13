package com.example.Crud_AuthN_oAuth2.Auth.Controller;

import com.example.Crud_AuthN_oAuth2.Auth.Dto.AUserDto;
import com.example.Crud_AuthN_oAuth2.Auth.Entity.AUserData;
import com.example.Crud_AuthN_oAuth2.Auth.Mapper.AUserMapper;
import com.example.Crud_AuthN_oAuth2.Auth.Security.AUserJwtUtil;
import com.example.Crud_AuthN_oAuth2.Auth.Service.AUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/**")
@RequiredArgsConstructor
public class AUserController {

    private final AUserService aUserService;
    private final PasswordEncoder passwordEncoder;
    private final AUserJwtUtil aUserJwtUtil;

    public ResponseEntity<AUserDto> saveUser(AUserDto aUserDto){
        AUserDto aUserDto1 = aUserService.saveDetails(aUserDto);
        return new ResponseEntity(aUserDto1, HttpStatus.OK);
    }

    public ResponseEntity<String> getUserByEmail(AUserDto aUserDto){
        String token = aUserService.getUserByEmail(aUserDto);
        return ResponseEntity.ok(token);
    }

}
