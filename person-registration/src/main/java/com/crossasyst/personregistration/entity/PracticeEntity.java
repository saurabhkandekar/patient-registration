package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "practice")
public class PracticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprises_id")
    private EnterpriseEntity enterpriseEntity;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practice_entity")
//    private List<PatientEntity> patientEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "practice_id")
    private List<LocationEntity> locationEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practiceEntity")
    private List<PracticeContactEntity> practiceContactEntity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "staff_practice",
            joinColumns = @JoinColumn(name = "practice_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id"))

    private  List<StaffEntity> staffEntities;

}
