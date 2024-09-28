package org.example.notescollector.util;

import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //for user mapping
    public UserEntity toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> asUserDTOList(List<UserEntity> userEntity) {
       // return modelMapper.map(userEntity, List.class);
        return modelMapper.map(userEntity, new TypeToken<List<UserDTO>>() {}.getType());
    }

}
