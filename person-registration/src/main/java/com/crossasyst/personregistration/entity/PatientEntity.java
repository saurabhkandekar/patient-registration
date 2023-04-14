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
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long patientId;

//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private PracticeEntity practiceEntity;

}
