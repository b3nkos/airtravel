package com.apps.contenidos.raalzate.airtravel.model;

import com.apps.contenidos.raalzate.airtravel.MainApp;
import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseFlight;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseFlights;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseScheduleFlight;
import com.apps.contenidos.raalzate.airtravel.model.utils.DateUtil;
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
public class FlightModel {

    public static void getAllFlights(final IResponseFlights response){
        Firebase ref = new Firebase(MainApp.Properties.URL_FIREBASE.toString() + "aerolineas-schedule");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<FlightEntity> flightEntities = new ArrayList<>();
                List<Map<String, Object>> airLines = (ArrayList<Map<String, Object>>)
                        snapshot.getValue();
                for(Map<String, Object> data : airLines){

                    Map<String, Object> flights = (Map<String, Object>) data.get("flights");
                    FlightEntity flight = new FlightEntity(
                            Integer.parseInt(flights.get("id").toString()),
                            Integer.parseInt(flights.get("available-seats").toString()),
                            Integer.parseInt(flights.get("cost").toString()),
                            flights.get("destination").toString(),
                            flights.get("origin").toString()
                    );
                    flightEntities.add(flight);

                }

                response.onSuccess(flightEntities);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                response.onError(error.getMessage());
            }
        });
    }


    public static void getFlightById(final int id, final IResponseFlight responseFlight){
        getAllFlights(new IResponseFlights() {
            @Override
            public void onSuccess(List<FlightEntity> entitys) {
                for(FlightEntity entity : entitys){
                    if(entity.id == id) {
                        responseFlight.onSuccess(entity);
                        return;
                    }
                }

                responseFlight.onError("No existe vuelo");
            }

            @Override
            public void onError(String message) {
                responseFlight.onError(message);
            }
        });
    }

    public static void getScheduleFlight(final IResponseScheduleFlight response){
        Firebase ref = new Firebase(MainApp.Properties.URL_FIREBASE.toString() + "aerolineas-schedule");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<AirlineScheduleEntity> airlineScheduleEntities = new ArrayList<>();
                List<Map<String, Object>> airLines = (ArrayList<Map<String, Object>>)
                        snapshot.getValue();
                for(Map<String, Object> data : airLines){

                    Map<String, Object> flights = (Map<String, Object>) data.get("flights");
                    FlightEntity flight = new FlightEntity(
                            Integer.parseInt(flights.get("id").toString()),
                            Integer.parseInt(flights.get("available-seats").toString()),
                            Integer.parseInt(flights.get("cost").toString()),
                            flights.get("destination").toString(),
                            flights.get("origin").toString()
                    );
                    airlineScheduleEntities.add(new AirlineScheduleEntity(
                            Integer.parseInt(data.get("id").toString()),
                            data.get("name").toString(),
                            DateUtil.getStringToDate(data.get("date").toString()),
                            flight
                    ));
                }
                response.onSuccess(airlineScheduleEntities);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                response.onError(error.getMessage());
            }
        });
    }
}
