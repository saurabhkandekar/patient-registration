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
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "state_group")
public class StateGroupEntity {

    @Id
    @GeneratedValue
    @Column(name = "state_group_id")
    private Long stateGroupId;

    @Column(name = "state_group")
    private String stateGroup;

    @OneToOne
    private StateEntity stateEntity;

    @OneToOne
    private AddressEntity addressEntity;
}
