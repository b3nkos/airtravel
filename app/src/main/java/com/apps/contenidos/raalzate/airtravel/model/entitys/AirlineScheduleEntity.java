package com.apps.contenidos.raalzate.airtravel.model.entitys;

import java.util.Date;

/**
 * Created by MyMac on 27/04/16.
 */
public class AirlineScheduleEntity {
    public final int id;
    public final String name;
    public final Date date;
    public final FlightEntity flight;

    public AirlineScheduleEntity(int id, String name, Date date, FlightEntity flight) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.flight = flight;
    }
}
