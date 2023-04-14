package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person_contact")
public class PersonContactEntity {

    @Id
    @GeneratedValue
    @Column(name = "person_contact_id")
    private Long personContactId;

    @Column(name = "home_phone_number")
    private String homePhoneNumber;

    @Column(name = "alternate_phone_number")
    private String alternatePhoneNumber;

    @ManyToOne
    private PersonEntity personEntity;
}
