package com.apps.contenidos.raalzate.airtravel.views;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.model.ReservationModel;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseFlight;
import com.apps.contenidos.raalzate.airtravel.model.utils.TinyDB;

/**
 * Created by MyMac on 27/04/16.
 */
public class StatusFlightServiceView extends ServiceView {
    private final TinyDB tinyDB;
    private final Context context;
    private TextView name;
    private TextView cost;
    private TextView seat;
    private TextView origin;
    private TextView destine;

    public StatusFlightServiceView(LayoutInflater inflater, ViewGroup container, FragmentManager fragmentManager) {
        super(R.layout.fragment_status, inflater, container, fragmentManager);
        context = container.getContext();
        tinyDB = new TinyDB(context);
        initViews();
    }
    private void initViews(){
        name = (TextView)view.findViewById(R.id.name);
        cost = (TextView)view.findViewById(R.id.cost);
        seat = (TextView)view.findViewById(R.id.seat);
        origin = (TextView)view.findViewById(R.id.origin);
        destine = (TextView)view.findViewById(R.id.destine);

        ReservationModel.getReservation(tinyDB.getString("uid"), new IResponseFlight() {
            @Override
            public void onSuccess(FlightEntity entity) {
                name.setText("VUELO RESERVADO");
                cost.setText("Costo: $" + entity.cost);
                seat.setText("Sillas: "+ entity.availableSeats);
                origin.setText("Origen: "+entity.origin);
                destine.setText("Destino: "+entity.destination);
            }

            @Override
            public void onError(String message) {
                name.setText(message);
            }
        });
    }
}
