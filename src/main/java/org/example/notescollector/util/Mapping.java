package org.example.notescollector.util;

import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //for user mapping
    public UserEntity toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDTO toDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

}
