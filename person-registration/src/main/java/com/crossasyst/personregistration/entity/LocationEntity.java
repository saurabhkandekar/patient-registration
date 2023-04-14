package com.crossasyst.personregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "practice_id")
    private PracticeEntity practiceEntity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationEntity")
    private List<LocationAddressEntity> locationAddressEntity;

    @OneToMany(fetch = FetchType.LAZY)
    private List<PracticeContactEntity> practiceContactEntity;
}
