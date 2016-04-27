package com.apps.contenidos.raalzate.airtravel.presenters.interfaces;

import android.view.View;

import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;

import java.util.List;

/**
 * Created by raalzate on 27/04/2016.
 */
public interface IGridCardAdapterPresenter {

    void onBindViewHolder(GridCardAdapter.CardViewHolder holder, int position);
    void setData(List<FlightEntity> flights);
    void addData(FlightEntity flight);
    void clearData();
    void onItemClick(View view, int position);
    int getFlightSize();
    FlightEntity getFlight(int position);
}
