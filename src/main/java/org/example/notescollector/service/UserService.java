package org.example.notescollector.service;

import org.example.notescollector.dto.UserStatus;
import org.example.notescollector.dto.impl.UserDTO;

import java.util.List;

public interface UserService {

    void saveUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    void deleteUser(String userId);

    void updateUser(String userId, UserDTO userDTO);

   UserStatus getUser(String userId);
}
