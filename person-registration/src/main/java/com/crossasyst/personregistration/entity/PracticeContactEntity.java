package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "practice_contact")
public class PracticeContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "practice_contact_id")
    private Long practiceContactId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "alternate_phone_number")
    private String alternatePhoneNumber;

    @Column(name = "contact_person")
    private String contactPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    private PracticeEntity practiceEntity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "practice_contacts")
    private LocationEntity locationEntity;
    @OneToOne(fetch = FetchType.LAZY)
    private PracticeContactTypeEntity practiceContactTypeEntity;
}
