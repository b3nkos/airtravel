package com.apps.contenidos.raalzate.airtravel.presenters;


import android.view.View;
import android.widget.Toast;

import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.model.utils.DateUtil;
import com.apps.contenidos.raalzate.airtravel.model.utils.TinyDB;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IGridCardAdapterPresenter;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IGridCardAdapter;

import java.util.List;


/**
 * Created by raalzate on 31/03/2016.
 */
public class GridCardAdapterPresenter  implements IGridCardAdapterPresenter, View.OnClickListener {

    List<AirlineScheduleEntity> airlineScheduleEntities;
    Types type;

    private final IGridCardAdapter gridCardAdapter;
    public GridCardAdapterPresenter(IGridCardAdapter gridCardAdapter){
        this.gridCardAdapter = gridCardAdapter;
    }


    @Override
    public void onBindViewHolder(GridCardAdapter.CardViewHolder holder, int position) {
        AirlineScheduleEntity airlineScheduleEntity = airlineScheduleEntities.get(position);

        holder.view.setTag(airlineScheduleEntity.flight.id);
        holder.view.setOnClickListener(this);

        switch (type) {
            case BY_TIME:
                gridCardAdapter.renderViewHolder(holder,
                        airlineScheduleEntity.name + "(" +airlineScheduleEntity.flight.origin + "-"
                                + airlineScheduleEntity.flight.destination +")" ,
                        DateUtil.getDateFormat(airlineScheduleEntity.date, gridCardAdapter.getActivity()),
                        airlineScheduleEntity.flight.origin + "-"
                                + airlineScheduleEntity.flight.destination, null);
                break;
            case BY_COST:
                gridCardAdapter.renderViewHolder(holder,
                        DateUtil.getDateFormat(airlineScheduleEntity.date, gridCardAdapter.getActivity()),
                        airlineScheduleEntity.name + "(" +airlineScheduleEntity.flight.origin + "-"
                                + airlineScheduleEntity.flight.destination +")",
                        "Precio: $"+airlineScheduleEntity.flight.cost,
                        null);
                break;
            case BY_SEAT:
                gridCardAdapter.renderViewHolder(holder,
                        DateUtil.getDateFormat(airlineScheduleEntity.date, gridCardAdapter.getActivity()),
                         "" +airlineScheduleEntity.flight.origin + "-"
                                + airlineScheduleEntity.flight.destination +"" ,
                        null,
                        "Sillas: "+airlineScheduleEntity.flight.availableSeats);
                break;
        }

    }

    @Override
    public void setData(List<AirlineScheduleEntity> flights) {
        airlineScheduleEntities = flights;
    }

    @Override
    public void addData(AirlineScheduleEntity flight) {
        airlineScheduleEntities.add(flight);
        gridCardAdapter.refresh();
    }

    @Override
    public void clearData() {
        airlineScheduleEntities.clear();
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public int getFlightSize() {
        return airlineScheduleEntities.size();
    }

    @Override
    public AirlineScheduleEntity getFlight(int position) {
        return null;
    }

    @Override
    public void setType(Types type) {
        this.type =type;
    }

    @Override
    public void onClick(View view) {
        new TinyDB(gridCardAdapter.getActivity()).putInt("flight_id",
                Integer.parseInt(view.getTag().toString()));
        Toast.makeText(gridCardAdapter.getActivity(), "Vuelo reservado",
                Toast.LENGTH_LONG).show();
    }
}
