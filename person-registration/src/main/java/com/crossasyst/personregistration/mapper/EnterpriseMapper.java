package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.EnterpriseEntity;
import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.model.Enterprise;
import com.crossasyst.personregistration.model.Practice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnterpriseMapper {
    EnterpriseEntity modelToEntity (Enterprise enterprise);

    Enterprise entityToModel (EnterpriseEntity enterpriseEntity);
    List<Enterprise> entityToModels (List<EnterpriseEntity> enterpriseEntities);


}
