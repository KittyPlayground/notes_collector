package org.example.notescollector.service;

import jakarta.transaction.Transactional;
import org.example.notescollector.dao.UserDao;
import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.entity.impl.UserEntity;
import org.example.notescollector.util.AppUtil;
import org.example.notescollector.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        return mapping.toUserDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return List.of();
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public boolean updateUser(String userId, UserDTO userDTO) {
        return false;
    }
}
