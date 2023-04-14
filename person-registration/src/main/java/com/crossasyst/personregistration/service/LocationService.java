package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.LocationEntity;
import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.mapper.LocationMapper;
import com.crossasyst.personregistration.model.Location;
import com.crossasyst.personregistration.repository.LocationRepository;
import com.crossasyst.personregistration.repository.PracticeRepository;
import com.crossasyst.personregistration.response.LocationResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    private final PracticeRepository practiceRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper, PracticeRepository practiceRepository) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
        this.practiceRepository = practiceRepository;
    }


    public LocationResponse createLocationByPracticeId(Long practiceId, Location location) {
        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
        List<LocationEntity> location1 = practiceEntity.getLocationEntity();
        LocationEntity locationEntity = locationMapper.modelToEntity(location);
        location1.add(locationEntity);
        practiceEntity.setPracticeId(practiceId);
        LocationEntity saveLocation = locationRepository.save(locationEntity);
        PracticeEntity savePractice = practiceRepository.save(practiceEntity);
        log.info("successfully create Location" + locationEntity.toString());
        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setLocationId(locationEntity.getLocationId());
        return locationResponse;
    }

    public Location getLocationById(Long locationId) {
        LocationEntity locationEntity = locationRepository.findById(locationId).get();
        Location location1 = locationMapper.entityToModel(locationEntity);
        log.info("Location get By Id:" + locationId);
        return location1;
    }

    public List<Location> getAllLocation() {
        List<LocationEntity> locationEntities = locationRepository.findAll();
        List<Location> locations = locationMapper.entityToModels(locationEntities);
        return locations;
    }

    public Location updateLocation(Long locationId, Location location) {
        LocationEntity locationEntity = locationRepository.findById(locationId).get();
        LocationEntity locationEntity1 = locationMapper.modelToEntity(location);
        locationEntity1.setLocationId(locationEntity.getLocationId());
        locationRepository.save(locationEntity1);
        log.info("Location update where id is:"+locationId);
        return location;
    }

    public void deleteLocationById(Long locationId) {
        Optional<LocationEntity> locationEntity =locationRepository.findById(locationId);
        if (locationEntity.isPresent()){
            locationRepository.deleteById(locationId);
        }else {
            log.info("Location is deleted where id is:"+locationId);
        }
    }
}
