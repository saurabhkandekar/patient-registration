package com.crossasyst.personregistration.mapper;

import com.crossasyst.personregistration.entity.StaffEntity;
import com.crossasyst.personregistration.model.Staff;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StaffMapper {

StaffEntity modelToEntity(Staff staff);
Staff entityToModel(StaffEntity staffEntity);
List<Staff> entityToModels(List<StaffEntity> staffEntities);

}
