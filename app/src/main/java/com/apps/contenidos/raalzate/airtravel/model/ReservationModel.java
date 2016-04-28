package com.apps.contenidos.raalzate.airtravel.model;

import com.apps.contenidos.raalzate.airtravel.MainApp;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseFlight;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by MyMac on 27/04/16.
 */
public class ReservationModel {

    public static void setReservation(FlightEntity flightEntity, String uid) {
        Firebase ref = new Firebase(MainApp.Properties.URL_FIREBASE.toString());
        ref.child("reservation-" + uid).setValue(flightEntity);
    }

    public static void getReservation(String uid, final IResponseFlight response) {

        Firebase ref = new Firebase(MainApp.Properties.URL_FIREBASE.toString() + "reservation-" + uid);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if(snapshot.getValue().equals("")) {
                    response.onError("No tiene reservaciones");
                    return;
                }

                Map<String, Object> flights = (Map<String, Object>) snapshot.getValue();

                FlightEntity flight = new FlightEntity(
                        Integer.parseInt(flights.get("id").toString()),
                        Integer.parseInt(flights.get("availableSeats").toString()),
                        Integer.parseInt(flights.get("cost").toString()),
                        flights.get("destination").toString(),
                        flights.get("origin").toString()
                );

                response.onSuccess(flight);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                response.onError(error.getMessage());
            }
        });
    }
}
