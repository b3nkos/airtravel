package com.apps.contenidos.raalzate.airtravel.views.interfaces;

import android.app.Activity;

import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IGridCardAdapterPresenter;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;

import java.util.List;


/**
 * Created by raalzate on 31/03/2016.
 */
public interface IGridCardAdapter {

    void renderViewHolder(GridCardAdapter.CardViewHolder holder,
                          String name, String date, String cost, String seat);

    void refresh();

    void addData(AirlineScheduleEntity flights);

    Activity getActivity();

    IGridCardAdapterPresenter getPresenter();

}
