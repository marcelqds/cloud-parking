package com.mqds.cloudpark;

import com.mqds.cloudpark.model.Parking;
import com.mqds.cloudpark.service.ParkingCheckOut;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
public class ParkingCheckoutTest {
    /*Parking parking = new Parking();

    @BeforeAll
    void loadParking(){
        parking.setColor("Cinza");
        parking.setLicense("DTZ-3704");
        parking.setModel("Xtz250");
        parking.setState("SP");
    }

    @BeforeEach
    void loadTimeParking(){
        LocalDateTime dateEntry = LocalDateTime.now();
        LocalDateTime dateExit = LocalDateTime.from(dateEntry);
        parking.setEntryDate(dateEntry);
        parking.setExitDate(dateExit);
    }

    @Test
    void whengetBillThenValideValue(){
        parking.setExitDate(parking.getEntryDate().plusMinutes(45));
        Double value = ParkingCheckOut.getBill(parking);
        Assertions.assertEquals(value,5);
    }*/
}
