package com.mqds.cloudpark.service;

import com.mqds.cloudpark.model.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingCheckOut {

    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;

    public static Double getBill(Parking parking){
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        Double bill = 0.0;
        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
        if(minutes <= ONE_HOUR)
            return ONE_HOUR_VALUE;

        if(minutes <= TWENTY_FOUR_HOUR){
            bill = ONE_HOUR_VALUE;
            int hours = (int) (minutes / ONE_HOUR);
            System.out.println("Hours: "+hours);
            for(int i= 0; i < hours; i++){
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }
            return bill;
        }

        int days = (int) (minutes / TWENTY_FOUR_HOUR);
        System.out.println("Days: "+ days);
        for(int i = 0; i < days; i++){
            bill += DAY_VALUE;
        }
        return bill;
    }


}

