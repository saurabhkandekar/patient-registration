package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.PracticeContact;
import com.crossasyst.personregistration.response.PracticeContactResponse;
import com.crossasyst.personregistration.service.PracticeContactService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(name = "v1")
@RestController
public class PracticeContactController {
//    private final PracticeContactService practiceContactService;
//@Autowired
//    public PracticeContactController(PracticeContactService practiceContactService) {
//        this.practiceContactService = practiceContactService;
//    }
//    @ApiResponse(responseCode = "200",description = "success")
//    @ApiResponse(responseCode = "400",description = "Invalid request")
//    @ApiResponse(responseCode = "404",description = "Not found")
//    @ApiResponse(responseCode = "500",description = "server error")
//    @PostMapping(path = "/location/{locationId}/practice_contacts")
//    public ResponseEntity<PracticeContactResponse> createPractiseContacts(@PathVariable Long locationId, @RequestBody PracticeContact practiceContact){
//    PracticeContactResponse practiceContactResponse = practiceContactService.createPracticeContacts(locationId,practiceContact);
//    return new ResponseEntity<>(practiceContactResponse, HttpStatus.OK);
//    }
}
