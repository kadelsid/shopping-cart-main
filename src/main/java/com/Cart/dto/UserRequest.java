package com.Cart.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRequest {
    @NotBlank(message = "First name not be empty")
    @Size(min = 3,max = 5,message = "size must be between 3 to 5")
    private String firstName;

    @NotBlank(message = "Last name should not be empty")
    private  String lastName;

    @NotBlank(message = "Email should not be empty")
    private  String email;

    @NotBlank(message = "Password should not be empty")
    private String password;
}
