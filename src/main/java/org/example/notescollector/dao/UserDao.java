package org.example.notescollector.dao;


import org.example.notescollector.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository <UserEntity, String > {

    UserEntity findByEmail(String email);

}
