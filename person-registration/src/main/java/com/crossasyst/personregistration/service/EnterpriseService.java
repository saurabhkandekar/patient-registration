package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.EnterpriseEntity;
import com.crossasyst.personregistration.mapper.EnterpriseMapper;
import com.crossasyst.personregistration.model.Enterprise;
import com.crossasyst.personregistration.repository.EnterpriseRepository;
import com.crossasyst.personregistration.response.EnterpriseResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseMapper enterpriseMapper;

    @Autowired
    public EnterpriseService(EnterpriseRepository enterpriseRepository, EnterpriseMapper enterpriseMapper) {
        this.enterpriseRepository = enterpriseRepository;
        this.enterpriseMapper = enterpriseMapper;
    }

    public EnterpriseResponse addEnterPrises(Enterprise enterprise) {
        EnterpriseEntity enterpriseEntity = enterpriseMapper.modelToEntity(enterprise);
        enterpriseRepository.save(enterpriseEntity);
        EnterpriseResponse enterPriseResponse = new EnterpriseResponse();
        enterPriseResponse.setEnterpriseId(enterpriseEntity.getEnterpriseId());
        log.info("create Enterprises");
        return enterPriseResponse;
    }

    public Enterprise getEnterpriseById(Long enterpriseId) {
        EnterpriseEntity enterpriseEntity = enterpriseRepository.findById(enterpriseId).get();
        Enterprise enterprise = enterpriseMapper.entityToModel(enterpriseEntity);
        log.info("get enterprise by id :" + enterpriseId);
        return enterprise;
    }

    public List<Enterprise> getAllEnterprises() {
        List<EnterpriseEntity> enterpriseEntities = enterpriseRepository.findAll();
        List<Enterprise> enterprises = enterpriseMapper.entityToModels(enterpriseEntities);
        log.info("get all enterprises");
        return enterprises;
    }

    public void deleteById(Long enterpriseId) {
        Optional<EnterpriseEntity> enterpriseEntity = enterpriseRepository.findById(enterpriseId);
        if (enterpriseEntity.isPresent()) {
            enterpriseRepository.deleteById(enterpriseId);
        } else {
            log.info("enterpriseId:" + enterpriseId + "is not present in your database");
        }
    }

    public Enterprise updateEnterprises(Long enterpriseId, Enterprise enterprise) {
        EnterpriseEntity enterpriseEntity = enterpriseRepository.findById(enterpriseId).get();

        EnterpriseEntity enterpriseEntity1 = enterpriseMapper.modelToEntity(enterprise);
        enterpriseEntity1.setEnterpriseId(enterpriseEntity.getEnterpriseId());
        enterpriseRepository.save(enterpriseEntity1);
        log.info("Update enterprise");
        return enterprise;
    }

    public Enterprise patchById(Long enterpriseId, Enterprise enterprise) {
        EnterpriseEntity enterpriseEntity = enterpriseRepository.findById(enterpriseId).get();
        Enterprise enterprise1 = enterpriseMapper.entityToModel(enterpriseEntity);
        log.info("Patch enterprise");
        return enterprise1;
    }
}
