package org.example.notescollector.service;

import jakarta.transaction.Transactional;
import org.example.notescollector.customStatusCodes.SelectedUserErrorStatus;
import org.example.notescollector.dao.UserDao;
import org.example.notescollector.dto.UserStatus;
import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.entity.impl.UserEntity;
import org.example.notescollector.exception.DataPersistException;
import org.example.notescollector.exception.UserNotFoundException;
import org.example.notescollector.util.AppUtil;
import org.example.notescollector.util.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveUser(UserDTO userDTO) {
        UserEntity saved = userDao.save(mapping.toUserEntity(userDTO));
        if (saved == null) {
            throw new DataPersistException("User not saved");
        }

/*        UserEntity savedUser = userDao.save(mapping.toUserEntity(userDTO));
        return mapping.toUserDTO(savedUser);*/
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> all = userDao.findAll();
        return mapping.asUserDTOList(all);

    }

    @Override
    public UserStatus getUser(String userId) {
        if (userDao.existsById(userId)) {
            UserEntity selectedUser = userDao.getReferenceById(userId);
            return mapping.toUserDTO(selectedUser);
        } else {
            return new SelectedUserErrorStatus(2, "User not found");
        }

    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> existsById = userDao.findById(userId);
        if (!existsById.isPresent()) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        } else {
            userDao.deleteById(userId);
        }
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        Optional<UserEntity> tmpUser = userDao.findById(userId);
        if (tmpUser.isPresent()) {
            tmpUser.get().setFirstName(userDTO.getFirstName());
            tmpUser.get().setLastName(userDTO.getLastName());
            tmpUser.get().setEmail(userDTO.getEmail());
            tmpUser.get().setPassword(userDTO.getPassword());
            tmpUser.get().setProfilePic(userDTO.getProfilePic());
        }
    }


}
