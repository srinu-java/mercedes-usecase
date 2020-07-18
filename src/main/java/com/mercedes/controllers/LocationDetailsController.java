package com.mercedes.controllers;

import com.mercedes.services.LocationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Srinivas
 */

@RestController
@RequestMapping("/api/location-details")
public class LocationDetailsController {

    @Autowired
    private LocationDetailService locationDetailService;

    @RequestMapping("/")
    public ResponseEntity<Map> fetchAll(@RequestParam String place) {
        Map map = locationDetailService.locationDetails(place);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
