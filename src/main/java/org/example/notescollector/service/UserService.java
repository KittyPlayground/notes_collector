package org.example.notescollector.service;

import org.example.notescollector.dto.impl.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    void deleteUser(String userId);

    boolean  updateUser(String userId, UserDTO userDTO);

    UserDTO getUser(String userId);
}
