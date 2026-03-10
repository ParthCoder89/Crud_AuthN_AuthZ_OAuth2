package com.example.Crud_AuthN_oAuth2.Crud.Controller;

import com.example.Crud_AuthN_oAuth2.Crud.Dto.CUserDto;
import com.example.Crud_AuthN_oAuth2.Crud.Service.CUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/crud")
@RequiredArgsConstructor
public class CUserController {
    private final CUserService cUserService;

    @PostMapping
    public ResponseEntity<CUserDto> saveUser(@RequestBody CUserDto cUserDto){
        CUserDto user = cUserService.saveUser(cUserDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CUserDto> getUser(@PathVariable("id") Long id){
        CUserDto user = cUserService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CUserDto>> getAllUser(){
        List<CUserDto> users = cUserService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CUserDto> updateUser(@RequestBody CUserDto cuserDto, @PathVariable("id") Long id){
        CUserDto user = cUserService.updateUser(cuserDto, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        cUserService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
