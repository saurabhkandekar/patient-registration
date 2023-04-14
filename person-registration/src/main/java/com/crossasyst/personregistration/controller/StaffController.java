package com.crossasyst.personregistration.controller;


import com.crossasyst.personregistration.model.Staff;
import com.crossasyst.personregistration.response.StaffResponse;
import com.crossasyst.personregistration.service.StaffService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(name = "v1")
@RestController
public class StaffController {
    private final StaffService staffService;
    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/practice/{practiceId}/staffs")
    public ResponseEntity<StaffResponse> createStaff(@PathVariable Long practiceId, @RequestBody Staff staff){
        StaffResponse staffResponse =staffService.createStaff(practiceId,staff);
        return new ResponseEntity<>(staffResponse, HttpStatus.OK);
    }
}
