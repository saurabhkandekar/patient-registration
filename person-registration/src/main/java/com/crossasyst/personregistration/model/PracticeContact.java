package com.crossasyst.personregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracticeContact {
    private Long practiceContactId;
    private String phoneNumber;
    private String emailId;
    private String alternatePhoneNumber;
    private String contactPerson;
}
