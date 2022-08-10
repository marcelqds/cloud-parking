package com.mqds.cloudpark.repository;

import com.mqds.cloudpark.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ParkingRepository extends JpaRepository<Parking, String>{}
