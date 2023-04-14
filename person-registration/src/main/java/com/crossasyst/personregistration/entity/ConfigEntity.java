package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "config")
public class ConfigEntity {
    @Id
    @SequenceGenerator(name = "config_serq", initialValue = 1, sequenceName = "config_seq", allocationSize = 1)
    @Column(name = "config_id")
    private Long configId;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "abbreviation_description")
    private String abbreviationDescription;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private GroupEntity groupEntity;
}
