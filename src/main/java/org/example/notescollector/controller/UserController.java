package org.example.notescollector.controller;

import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName")String lastName,
            @RequestPart("email")String email,
            @RequestPart("password")String password,
            @RequestPart("profilePic")String profilePic

    ){
        //userId generate
        String userId = AppUtil.generateUserId();
        //:profile pic convert Base64
        String base64ProPic = AppUtil.generateProfilePictoBase64(profilePic);
        //:Build the object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserID(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(profilePic);

        return buildUserDTO;

    }

}
