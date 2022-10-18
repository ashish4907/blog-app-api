package com.blog.PayLoads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "UserName must be minimum of 4 Character")
    private String name;

    @Email
    @Size(min = 4, message = "Email Address is not valid")

    private String email;
    @NotEmpty
    @Size(min = 3,max = 10,message = "Password must be minimum of 3 character and maximum of 10 character")
  
    private String password;
    @NotEmpty
    private String about;

}
