package com.example.demo.responsemodels;

import lombok.Data;

@Data
public class StudentResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
