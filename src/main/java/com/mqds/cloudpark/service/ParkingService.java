package com.mqds.cloudpark.service;

import com.mqds.cloudpark.model.Parking;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        String id = getUUID();
        Parking parking = new Parking(id, "DMS-2121", "SC", "CELTA", "PRETO");
        parkingMap.put(id, parking);
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }
}
