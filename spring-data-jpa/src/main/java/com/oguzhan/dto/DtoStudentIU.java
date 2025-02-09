package com.oguzhan.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU { //Insert Update

    @NotEmpty(message = "FirstName cannot be empty!")
    @Size(min = 3, max = 40, message = "FirstName size must be between 3 and 40!")
    private String firstName;

    @Size(min = 3, max = 40)
    private String lastName;

    private Date birthOfDate;;

    @Email(message = "Enter email format")
    private String email;

    @Size(min = 11, max = 11, message = "tckn must be 11 digit")
    private String tckn;
}
