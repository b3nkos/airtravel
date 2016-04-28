package com.apps.contenidos.raalzate.airtravel.views;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.model.FlightModel;
import com.apps.contenidos.raalzate.airtravel.model.ReservationModel;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseFlight;
import com.apps.contenidos.raalzate.airtravel.model.utils.TinyDB;

/**
 * Created by MyMac on 27/04/16.
 */
public class ReservationServiceView extends ServiceView implements View.OnClickListener{
    private final TinyDB tinyDB;
    private Button button;
    private TextView text;
    private FlightEntity entity;
    private Context context;

    public ReservationServiceView(LayoutInflater inflater, ViewGroup container, FragmentManager fragmentManager) {
        super(R.layout.fragment_reservation, inflater, container, fragmentManager);
        context = container.getContext();
        tinyDB = new TinyDB(context);
        initViews();
    }

    private void initViews() {
        button = (Button)view.findViewById(R.id.reservation);
        text = (TextView)view.findViewById(R.id.text);
        if(tinyDB.getInt("flight_id") > 0) {
            FlightModel.getFlightById(tinyDB.getInt("flight_id"), new IResponseFlight() {
                @Override
                public void onSuccess(FlightEntity entity) {
                    ReservationServiceView.this.entity = entity;
                    button.setText("Reservar este vuelo!");
                    button.setOnClickListener(ReservationServiceView.this);
                    text.setText(entity.origin + " - "+entity.destination + "\n" +"Costo: " + entity.cost);
                }

                @Override
                public void onError(String message) {
                    text.setText("No se puede reservar: "+message);
                }
            });
        } else {
            text.setText("Seleccione primero un vuelo.");
        }
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(context, "Vuelo reservado :)", Toast.LENGTH_LONG).show();
        ReservationModel.setReservation(entity, tinyDB.getString("uid"));
    }
}
