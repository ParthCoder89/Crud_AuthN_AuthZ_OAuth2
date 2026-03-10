package com.example.Crud_AuthN_oAuth2.Crud.Service;

import com.example.Crud_AuthN_oAuth2.Crud.Dto.CUserDto;
import com.example.Crud_AuthN_oAuth2.Crud.Mapper.CUserMapper;
import com.example.Crud_AuthN_oAuth2.Crud.Repository.CUserRepository;
import com.example.Crud_AuthN_oAuth2.Crud.entity.CUserData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CUserServiceImpl implements CUserService {

    private final CUserRepository cUserRepository;

    @Override
    public CUserDto saveUser(CUserDto cUserDto) {
        CUserData cUserData = CUserMapper.dtoToEntity(cUserDto);
        CUserData userData = cUserRepository.save(cUserData);
        return CUserMapper.entityToDto(userData);
    }

    @Override
    public CUserDto getUser(Long id) {
        CUserData userData = cUserRepository.findById(id).orElseThrow(()->
                new RuntimeException("User Not Found"));
        return CUserMapper.entityToDto(userData);
    }

    @Override
    public List<CUserDto> getAllUsers() {
        List<CUserData> list = cUserRepository.findAll();
        return list.stream().map((user)-> CUserMapper.entityToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public CUserDto updateUser(CUserDto cUserDto, Long id) {
        CUserData cUserData = cUserRepository.findById(id).orElseThrow(()->
                new RuntimeException("User Not Found"));
        cUserData.setFirstName(cUserDto.getFirstName());
        cUserData.setLastName(cUserDto.getLastName());
        cUserData.setEmail(cUserDto.getEmail());
        cUserData.setPassword(cUserDto.getPassword());

        CUserData savedUser = cUserRepository.save(cUserData);
        return CUserMapper.entityToDto(savedUser);
    }

    @Override
    public String deleteUser(Long id) {
        CUserData cUserData = cUserRepository.findById(id).orElseThrow(()->
                new RuntimeException("User Not Found"));
        cUserRepository.deleteById(id);
        return "User Deleted Successfully";
    }


}
