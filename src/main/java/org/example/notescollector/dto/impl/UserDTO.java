package org.example.notescollector.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notescollector.dto.SuperDTO;
import org.example.notescollector.dto.UserStatus;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements UserStatus, SuperDTO {
    private String UserID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteDTO> notes;
}
