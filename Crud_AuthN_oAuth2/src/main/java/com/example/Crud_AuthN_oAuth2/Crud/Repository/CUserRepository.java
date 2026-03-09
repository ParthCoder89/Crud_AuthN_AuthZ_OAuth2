package com.example.Crud_AuthN_oAuth2.Crud.Repository;

import com.example.Crud_AuthN_oAuth2.Crud.entity.CUserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CUserRepository extends JpaRepository<CUserData, Long> {
}
