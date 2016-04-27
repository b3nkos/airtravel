package com.apps.contenidos.raalzate.airtravel.presenters;


import android.view.View;

import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IGridCardAdapterPresenter;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IGridCardAdapter;

import java.util.List;


/**
 * Created by raalzate on 31/03/2016.
 */
public class GridCardAdapterPresenter  implements IGridCardAdapterPresenter {

    private final IGridCardAdapter gridCardAdapter;
    public GridCardAdapterPresenter(IGridCardAdapter gridCardAdapter){
        this.gridCardAdapter = gridCardAdapter;
    }


    @Override
    public void onBindViewHolder(GridCardAdapter.CardViewHolder holder, int position) {

    }

    @Override
    public void setData(List<FlightEntity> flights) {

    }

    @Override
    public void addData(FlightEntity flight) {

    }

    @Override
    public void clearData() {

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public int getFlightSize() {
        return 0;
    }

    @Override
    public FlightEntity getFlight(int position) {
        return null;
    }
}
