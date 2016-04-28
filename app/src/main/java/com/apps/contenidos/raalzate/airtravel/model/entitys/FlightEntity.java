package com.apps.contenidos.raalzate.airtravel.model.entitys;

/**
 * Created by raalzate on 27/04/2016.
 */
public class FlightEntity {
    public final int availableSeats;
    public final int cost;
    public final String destination;
    public final int id;
    public final String origin;

    public FlightEntity(int id,int availableSeats, int cost, String destination, String origin) {
        this.availableSeats = availableSeats;
        this.cost = cost;
        this.destination = destination;
        this.id = id;
        this.origin = origin;
    }
}
