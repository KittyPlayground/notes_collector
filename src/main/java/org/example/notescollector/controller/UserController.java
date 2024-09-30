package org.example.notescollector.controller;

import jakarta.transaction.Transactional;
import org.example.notescollector.customStatusCodes.SelectedUserErrorStatus;
import org.example.notescollector.dto.UserStatus;
import org.example.notescollector.dto.impl.UserDTO;
import org.example.notescollector.exception.DataPersistException;
import org.example.notescollector.exception.UserNotFoundException;
import org.example.notescollector.service.UserService;
import org.example.notescollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> saveUser(
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
        String base64ProPic = "";

        try {
            byte[] profileByte = profilePic.getBytes();
            base64ProPic = AppUtil.generateProfilePictoBase64(profileByte);
            //:Build the object
            var buildUserDTO = new UserDTO();
            buildUserDTO.setUserID(userId);
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilePic(base64ProPic);
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatus getSelectedUser(@PathVariable("userId") String userId) {
        String regexForUserId = "USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
        Pattern regexPattern = Pattern.compile(regexForUserId);
        var regexMatched = regexPattern.matcher(userId); //check for valid user
        if (!regexMatched.matches()) {
            return new SelectedUserErrorStatus(1, "user Id cannot be null or empty");
        }
        return userService.getUser(userId);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
        String regexForUserId = "USER-[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
        try {
            if (!userId.matches(regexForUserId)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateUser(@PathVariable("userId") String userId,
                           @RequestPart("firstName") String firstName,
                           @RequestPart("lastName") String lastName,
                           @RequestPart("email") String email,
                           @RequestPart("password") String password,
                           @RequestPart("profilePic") MultipartFile profilePic
    ) {
        String base64ProPic = "";
        try {
            byte[] profileByte = profilePic.getBytes();
            base64ProPic = AppUtil.generateProfilePictoBase64(profileByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        var buildUserDTO = new UserDTO();
        buildUserDTO.setUserID(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProPic);
        userService.updateUser(userId, buildUserDTO);

    }

}
