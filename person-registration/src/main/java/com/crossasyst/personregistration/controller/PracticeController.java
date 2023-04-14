package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Practice;
import com.crossasyst.personregistration.response.PracticeResponse;
import com.crossasyst.personregistration.service.PracticeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "v1")
public class PracticeController {
    private final PracticeService practiceService;

    @Autowired
    public PracticeController(PracticeService practiceService) {
        this.practiceService = practiceService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/enterprise/{enterpriseId}/practice")
    public ResponseEntity<PracticeResponse> createPractice(@PathVariable Long enterpriseId, @RequestBody Practice practice) {
        PracticeResponse practiceResponse = practiceService.createPractice(enterpriseId, practice);
        return new ResponseEntity<>(practiceResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/practices")
    public ResponseEntity<List<Practice>> getAllPractice() {
        List<Practice> practice = practiceService.getAllPractice();
        return new ResponseEntity<>(practice, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/practice/{practiceId}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable Long practiceId) {
        Practice practice = practiceService.getPracticeById(practiceId);
        return new ResponseEntity<>(practice, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/practice/{practiceId}")
    public ResponseEntity<Void> updatePractice(@PathVariable Long practiceId, @RequestBody Practice practice) {
        practiceService.updatePractice(practiceId, practice);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(path = "/practice/{practiceId}")
    public ResponseEntity<Void> deletePracticeById(@PathVariable Long practiceId) {
        practiceService.deletePracticeById(practiceId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PatchMapping(path = "/practice/{practiceId}")
    public ResponseEntity<Practice> patchById(@PathVariable Long practiceId, @RequestBody Practice practice) {
        Practice practice1 = practiceService.patchById(practiceId, practice);
        return new ResponseEntity<>(practice1, HttpStatus.OK);
    }
}

