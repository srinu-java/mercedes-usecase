package com.mercedes.test;

import com.mercedes.controllers.LocationDetailsController;
import com.mercedes.models.ChargingStationDetails;
import com.mercedes.models.ParkingDetailsDetails;
import com.mercedes.models.RestuatantDetails;
import com.mercedes.services.LocationDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Srinivas
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class LocationDetailsControllerTest {

    @InjectMocks
    private LocationDetailsController locationDetailsController;

    @Mock
    private LocationDetailService locationDetailService;

    @Test
    public void fetchAll() {
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
        Mockito.when(locationDetailService.locationDetails("London")).thenReturn(locationDetails);
        assertEquals(this.locationDetailsController.fetchAll("London").getStatusCode(), HttpStatus.OK);
    }
}
