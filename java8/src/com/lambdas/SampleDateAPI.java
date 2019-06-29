package com.lambdas;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class SampleDateAPI {

    public static void main(String[] args) {

        Instant i = Instant.now();

        System.out.println("Time now from Instant API "+i);
        //Time now 2019-06-29T09:52:03.688Z

        LocalDate localDate = LocalDate.now();
        System.out.println("Time now from LocalDate API " +localDate);
        //2019-06-29

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Time now from localDateTime API " +localDateTime);
        //2019-06-29T15:33:40.774


        /** Age Calculator
         *
         */
        getAge();

    }

    public static void getAge() {
        LocalDate localDate = LocalDate.of(1990, 7, 19);
        //System.out.println(localDate.;
        Period period = Period.between(localDate,LocalDate.now());
        System.out.println("how old are you ?" + period.getYears());
    }



}
