package com.example.RestAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Username {
    private Long id;
    private String username;
    private String password;

    public Long id(){
        return id;
    }
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
