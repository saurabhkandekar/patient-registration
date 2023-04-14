package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String person_image;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email_id;

    private String gender;

    private Date birthDate;

    private String phoneNo;

    private String preferredName;

    private String birthSex;

    private String maritalStatus;

    private Boolean expired;

    private Date expiredDate;
}
