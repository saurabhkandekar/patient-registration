package com.crossasyst.personregistration.service;

import com.crossasyst.personregistration.entity.PracticeEntity;
import com.crossasyst.personregistration.entity.StaffEntity;
import com.crossasyst.personregistration.mapper.StaffMapper;
import com.crossasyst.personregistration.model.Staff;
import com.crossasyst.personregistration.repository.PracticeRepository;
import com.crossasyst.personregistration.repository.StaffRepository;
import com.crossasyst.personregistration.response.StaffResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StaffService {
    private final StaffMapper staffMapper;
    private final StaffRepository staffRepository;
    private final PracticeRepository practiceRepository;

    public StaffService(StaffMapper staffMapper, StaffRepository staffRepository, PracticeRepository practiceRepository) {
        this.staffMapper = staffMapper;
        this.staffRepository = staffRepository;
        this.practiceRepository = practiceRepository;
    }

    public StaffResponse createStaff(Long practiceId, Staff staff) {
        PracticeEntity practiceEntity = practiceRepository.findById(practiceId).get();
        List<StaffEntity> staffEntities = practiceEntity.getStaffEntities();
        StaffEntity staffEntity = staffMapper.modelToEntity(staff);
        staffEntities.add(staffEntity);
        practiceEntity.setPracticeId(practiceId);
        StaffEntity saveStaffEntity1 = staffRepository.save(staffEntity);
        PracticeEntity savePracticeEntity = practiceRepository.save(practiceEntity);
        log.info("successfully add Staff " + staffEntity.toString());
        StaffResponse staffResponse = new StaffResponse();
        staffResponse.setStaffId(staffEntity.getStaffId());
        return staffResponse;
    }
}
