package org.example.notescollector.controller;

import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.service.UserService;
import org.example.notescollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePic") MultipartFile profilePic

    ) {
        //userId generate
        String userId = AppUtil.generateUserId();
        //:profile pic convert Base64
        // String base64ProPic = AppUtil.generateProfilePictoBase64(profilePic);
        System.out.println("profile pic" + profilePic);
        String base64ProPic = "";

        try {
            byte[] profileByte = profilePic.getBytes();
            base64ProPic = AppUtil.generateProfilePictoBase64(profileByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //:Build the object
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserID(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        return userService.saveUser(buildUserDTO);

    }

}
