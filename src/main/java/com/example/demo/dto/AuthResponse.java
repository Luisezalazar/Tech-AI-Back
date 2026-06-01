package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class AuthResponse {

    private String token;
    private String username;

    public AuthResponse(String token, String username, String email) {
        this.token = token;
        this.username = username;
    }


}
