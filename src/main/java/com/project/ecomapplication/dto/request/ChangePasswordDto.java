package com.project.ecomapplication.dto.request;

import com.project.ecomapplication.customvalidations.PasswordMatchesForChangePasswordRequest;
import com.project.ecomapplication.customvalidations.ValidPassword;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@PasswordMatchesForChangePasswordRequest
public class ChangePasswordDto {

    @NotBlank(message = "Access token cannot be blank")
    private String accessToken;

    @ValidPassword
    private String password;

    @NotBlank(message = "Confirm Password should be same to Password")
    private String confirmPassword;
}