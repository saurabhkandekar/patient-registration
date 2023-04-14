package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.EnterpriseEntity;
import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.mapper.PracticeMapper;
import com.crossasyst.personregistration.model.Practice;
import com.crossasyst.personregistration.repository.EnterpriseRepository;
import com.crossasyst.personregistration.repository.PracticeRepository;
import com.crossasyst.personregistration.response.PracticeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class PracticeService {

    private final PracticeRepository practiceRepository;
    private final PracticeMapper practiceMapper;
    private final EnterpriseRepository enterpriseRepository;

    @Autowired
    public PracticeService(PracticeRepository practiceRepository, PracticeMapper practiceMapper, EnterpriseRepository enterpriseRepository) {
        this.practiceRepository = practiceRepository;
        this.practiceMapper = practiceMapper;
        this.enterpriseRepository = enterpriseRepository;
    }

    public PracticeResponse createPractice(Long enterpriseId, Practice practice) {
        EnterpriseEntity enterpriseEntity = enterpriseRepository.findById(enterpriseId).get();
        List<PracticeEntity> practiceEntities = enterpriseEntity.getPracticeEntity();
        PracticeEntity practiceEntity = practiceMapper.modelToEntity(practice);
        practiceEntities.add(practiceEntity);
        enterpriseEntity.setEnterpriseId(enterpriseId);
        PracticeEntity savePractice = practiceRepository.save(practiceEntity);
        EnterpriseEntity enterpriseEntity1 = enterpriseRepository.save(enterpriseEntity);
        System.out.println("Successfully create practices " + practiceEntity.toString());
        PracticeResponse practiceResponse = new PracticeResponse();
        practiceResponse.setPracticeId(savePractice.getPracticeId());
        return practiceResponse;
    }

    public List<Practice> getAllPractice() {
        List<PracticeEntity> practiceEntities = practiceRepository.findAll();
        List<Practice> practices = practiceMapper.entityToModels(practiceEntities);
        log.info("get all practices");
        return practices;
    }

    public Practice getPracticeById(Long practiceId) {
        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
        Practice practice = practiceMapper.entityToModel(practiceEntity);
        log.info("get Practice By id:" + practiceId);
        return practice;
    }

//    public Practice updatePractice(Long practiceId, Practice practice) {
//        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
//        Long enterprise = practiceEntity.getEnterpriseEntity().getEnterpriseId();
//        PracticeEntity practiceEntity1 = practiceMapper.modelToEntity(practice);
//        practiceEntity1.getEnterpriseEntity().setEnterpriseId(enterprise);
//        practiceEntity1.setPracticeId(practiceId);
//        practiceRepository.save(practiceEntity1);
//        Practice practice1 =practiceMapper.entityToModel(practiceEntity1);
//
//        log.info("update Practice By Id:" + practiceId);
//        return practice1;
//    }

    public void updatePractice(Long practiceId, Practice practice) {
      Optional<PracticeEntity> practiceEntityOptional = practiceRepository.findById(practiceId);
      if (practiceEntityOptional.isPresent()){
          PracticeEntity practiceEntity =practiceEntityOptional.get();
          practiceEntity= practiceMapper.modelToEntity(practice);
          practiceEntity.setPracticeId(practiceId);
          practiceRepository.save(practiceEntity);
          log.info("update Practice");
      }else
          log.info("this id is not present");
    }
    public void deletePracticeById(Long practiceId) {
        Optional<PracticeEntity> practiceEntity = practiceRepository.findById(practiceId);
        if (practiceEntity.isPresent()) {
            practiceRepository.deleteById(practiceId);
        } else {
            log.info("Practise id:" + practiceId + "is not present in your database");
        }
    }

    public Practice patchById(Long practiceId, Practice practice) {
        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
        Practice practice1 = practiceMapper.entityToModel(practiceEntity);
        log.info("patch By Id" + practiceId);
        return practice;
    }
}

