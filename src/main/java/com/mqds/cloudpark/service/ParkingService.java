package com.mqds.cloudpark.service;

import com.mqds.cloudpark.model.Parking;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        String id = getUUID();
        String id1 = getUUID();
        Parking parking = new Parking(id, "DMS-2121", "SC", "CELTA", "PRETO");
        Parking parking1 = new Parking(id1, "DKS-1212", "SP", "PALIO", "VERMELHO");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1 );
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }


    public Parking findById(String id){
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String id = getUUID();
        parkingCreate.setId(id);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(id,parkingCreate);

        return parkingCreate;
    }
}
