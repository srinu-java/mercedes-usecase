package com.mercedes.services;

import com.mercedes.models.ChargingStationDetails;
import com.mercedes.models.ParkingDetailsDetails;
import com.mercedes.models.RestuatantDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Srinivas
 */

@Service
public class LocationDetailServiceImpl implements LocationDetailService {


    @Override
    public Map locationDetails(String place) {

        ChargingStationDetails chargingStationDetails = new ChargingStationDetails();

        ParkingDetailsDetails parkingDetailsDetails = new ParkingDetailsDetails();

        RestuatantDetails restuatantDetails = new RestuatantDetails();

        chargingStationDetails.setId("123");
        chargingStationDetails.setName("twin-towers");
        chargingStationDetails.setDistance("100KM");

        parkingDetailsDetails.setId("125");
        parkingDetailsDetails.setName("london-petrol-bunk");
        parkingDetailsDetails.setDistance("40KM");

        restuatantDetails.setId("124");
        restuatantDetails.setName("mcdonalds");
        restuatantDetails.setDistance("50KM");

        List<ChargingStationDetails> chargingStationDetailsList = new ArrayList<>();
        List<ParkingDetailsDetails> parkingDetailsDetailsList = new ArrayList<>();
        List<RestuatantDetails> restuatantDetailsList = new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        chargingStationDetailsList.add(chargingStationDetails);
        parkingDetailsDetailsList.add(parkingDetailsDetails);
        restuatantDetailsList.add(restuatantDetails);
        map.put("chargingStationDetailsList", chargingStationDetailsList);
        map.put("parkingDetailsDetailsList", parkingDetailsDetailsList);
        map.put("restuatantDetailsList", restuatantDetailsList);

        Map<String, Map> locationDetails = new HashMap<>();

        locationDetails.put("London", map);
        if (locationDetails.containsKey(place)) {
            return locationDetails;
        } else {
            throw new RuntimeException();
        }

    }
}
