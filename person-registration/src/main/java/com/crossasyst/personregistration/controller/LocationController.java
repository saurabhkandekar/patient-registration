package com.crossasyst.personregistration.controller;

import com.crossasyst.personregistration.model.Location;
import com.crossasyst.personregistration.response.LocationResponse;
import com.crossasyst.personregistration.service.LocationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1")
@RestController
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/practice/{practiceId}/locations")
    public ResponseEntity<LocationResponse> createLocationByPracticeId(@PathVariable Long practiceId, @RequestBody Location location) {
        LocationResponse locationResponse = locationService.createLocationByPracticeId(practiceId, location);
        return new ResponseEntity<>(locationResponse, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/location/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long locationId) {
        Location location1 = locationService.getLocationById(locationId);
        return new ResponseEntity<>(location1, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/locations")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> location = locationService.getAllLocation();
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PutMapping(path = "/location/{locationId}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long locationId, @RequestBody Location location) {
        Location location1 = locationService.updateLocation(locationId, location);
        return new ResponseEntity<>(location1, HttpStatus.OK);
    }

    @ApiResponse(responseCode = "200", description = "success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @DeleteMapping(path = "/location/{locationId}")
    public ResponseEntity<Void> deleteLocationById(@PathVariable Long locationId) {
        locationService.deleteLocationById(locationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
