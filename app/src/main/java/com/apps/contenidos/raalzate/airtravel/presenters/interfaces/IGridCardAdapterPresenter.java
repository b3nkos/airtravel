package com.apps.contenidos.raalzate.airtravel.presenters.interfaces;

import android.view.View;

import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;

import java.util.List;

/**
 * Created by raalzate on 27/04/2016.
 */
public interface IGridCardAdapterPresenter {

    enum Types {
        BY_TIME,
        BY_COST,
        BY_SEAT
    }

    void onBindViewHolder(GridCardAdapter.CardViewHolder holder, int position);
    void setData(List<AirlineScheduleEntity> flights);
    void addData(AirlineScheduleEntity flight);
    void clearData();
    void onItemClick(View view, int position);
    int getFlightSize();
    AirlineScheduleEntity getFlight(int position);
    void setType(Types type);
}
