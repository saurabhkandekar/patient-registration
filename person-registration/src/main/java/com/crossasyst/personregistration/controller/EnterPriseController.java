package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Enterprise;
import com.crossasyst.personregistration.response.EnterpriseResponse;
import com.crossasyst.personregistration.service.EnterpriseService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "v1")
public class EnterPriseController {

    private final EnterpriseService enterpriseService;

    @Autowired
    public EnterPriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/enterprise")
    public ResponseEntity<EnterpriseResponse> addEnterPrises(@RequestBody Enterprise enterprise) {
        EnterpriseResponse enterPriseResponse = enterpriseService.addEnterPrises(enterprise);
        return new ResponseEntity<>(enterPriseResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/enterprise/{enterpriseId}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long enterpriseId) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(enterpriseId);
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/enterprise/{enterpriseId}")
    public ResponseEntity<Enterprise> updateEnterprises(@PathVariable Long enterpriseId, @RequestBody Enterprise enterprise) {
        Enterprise enterprise1 = enterpriseService.updateEnterprises(enterpriseId, enterprise);
        return new ResponseEntity<>(enterprise1, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/enterprises")
    public ResponseEntity<List<Enterprise>> getAllEnterprises() {
        List<Enterprise> enterprise = enterpriseService.getAllEnterprises();
        return new ResponseEntity<>(enterprise, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(path = "/enterprise/{enterpriseId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long enterpriseId) {
        enterpriseService.deleteById(enterpriseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PatchMapping(path = "/enterprise/{enterpriseId}")
    public ResponseEntity<Enterprise> patchById(@PathVariable Long enterpriseId, @RequestBody Enterprise enterprise) {
        Enterprise enterprise1 = enterpriseService.patchById(enterpriseId, enterprise);
        return new ResponseEntity<>(enterprise1, HttpStatus.OK);
    }
}
