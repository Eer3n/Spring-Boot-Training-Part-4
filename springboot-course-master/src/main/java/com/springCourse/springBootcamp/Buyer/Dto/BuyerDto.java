package com.springCourse.springBootcamp.Buyer.Dto;

import com.springCourse.springBootcamp.User.Enum.Gender;
import lombok.Data;

@Data
public class BuyerDto {

    private Long Id;
    private String name;
    private String surname;
    private String username;
    private String mailAddress;
    private String password;
    private Integer age;
    private String imageUrl;
    private Boolean isBanned;
    private Gender gender;
    private String backupMailAddress;
}
