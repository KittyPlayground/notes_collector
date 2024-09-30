package org.example.notescollector.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.notescollector.dto.UserStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserErrorStatus implements UserStatus {
    private int statusCode;
    private  String statusMessage;
}
