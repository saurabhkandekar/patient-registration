package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.LocationEntity;
import com.crossasyst.personregistration.entity.PracticeContactEntity;
import com.crossasyst.personregistration.mapper.PracticeContactMapper;
import com.crossasyst.personregistration.model.PracticeContact;
import com.crossasyst.personregistration.repository.LocationRepository;
import com.crossasyst.personregistration.repository.PracticeContactRepository;
import com.crossasyst.personregistration.response.PracticeContactResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class PracticeContactService {
//    private final PracticeContactRepository practiceContactRepository;
//    private final PracticeContactMapper practiceContactMapper;
//    private final LocationRepository locationRepository;

//    public PracticeContactService(PracticeContactRepository practiceContactRepository, PracticeContactMapper practiceContactMapper, LocationRepository locationRepository) {
//        this.practiceContactRepository = practiceContactRepository;
//        this.practiceContactMapper = practiceContactMapper;
//        this.locationRepository = locationRepository;
//    }
//
//    public PracticeContactResponse createPracticeContacts(Long locationId,PracticeContact practiceContact) {
//        LocationEntity locationEntity =locationRepository.findById(locationId).get();
////        List<PracticeContactEntity> practiceContactEntity=locationEntity.getPracticeEntity().getPracticeContactEntity();
//        List<PracticeContactEntity>practiceContactEntity=locationEntity.getPracticeContactEntity();
//        PracticeContactEntity practiceContactEntity1 =practiceContactMapper.modelToEntity(practiceContact);
//        practiceContactEntity.add(practiceContactEntity1);
//        locationEntity.setLocationId(locationId);
//        PracticeContactEntity savePracticeContact =practiceContactRepository.save(practiceContactEntity1);
//        LocationEntity saveLocation =locationRepository.save(locationEntity);
//        log.info("successfully add practice_contact"+practiceContactEntity.toString());
//        PracticeContactResponse practiceContactResponse =new PracticeContactResponse();
//        practiceContactResponse.setPracticeContactId(practiceContactEntity1.getPracticeContactId());
//        return practiceContactResponse;
//    }
}
