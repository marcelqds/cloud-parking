package com.mqds.cloudpark.service;

import com.mqds.cloudpark.exception.ParkingNotFoundException;
import com.mqds.cloudpark.model.Parking;
import com.mqds.cloudpark.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap();

    private final ParkingRepository parkingRepository;
    public ParkingService(ParkingRepository parkingRepository){
        this.parkingRepository = parkingRepository;
    }



    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Transactional
    public List<Parking> findAll(){
        return parkingRepository.findAll();
        //.values().stream().collect(Collectors.toList());
    }

    @Transactional
    public Parking findById(String id){
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String id = getUUID();
        parkingCreate.setId(id);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setModel(parkingCreate.getModel());
        parkingRepository.save(parking);
        return parking;
    }

    @Transactional
    // tipos = propagation || quando nao ira alterar dados = readOnly = true
    public Parking checkout(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        double billValue = ParkingCheckOut.getBill(parking);
        parking.setBill(billValue);
        parkingRepository.save(parking);
        //parkingMap.remove(id);
        return parking;
    }
}
