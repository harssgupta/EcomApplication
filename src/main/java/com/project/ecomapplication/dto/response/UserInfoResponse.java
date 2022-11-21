package com.project.ecomapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Data
public class UserInfoResponse {
    private Long id;
    private String email;
    private List<String> roles;
}