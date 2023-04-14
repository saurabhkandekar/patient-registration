package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person_additional_information")
public class PersonAdditionalInformationEntity {

    @Id
    @SequenceGenerator(name = "person_additional_information_seq_id", sequenceName = "person_additional_information_seq_id", initialValue = 10000000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_additional_information_seq_id")
    @Column(name = "person_additional_information_id")
    private Long personAdditionalInformationId;

    @Column(name = "preferred_pronoun")
    private String preferredPronoun;

    @Column(name = "preferred_language")
    private String preferredLanguage;

    @Column(name = "religion")
    private String religion;

    @Column(name ="is_veteran")
    private Boolean isVeteran;

    @Column(name = "is_smoker")
    private Boolean isSmoker;

    @OneToOne
    private CareProviderEntity careProviderEntity;
}
