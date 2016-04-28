package com.apps.contenidos.raalzate.airtravel.presenters;

import com.apps.contenidos.raalzate.airtravel.model.FlightModel;
import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseScheduleFlight;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IGridCardAdapterPresenter;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.ITabQueryFragmentPresenter;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.ITabQueryFragment;

import java.util.List;

/**
 * Created by MyMac on 27/04/16.
 */
public class TabQueryFragmentPresenter implements ITabQueryFragmentPresenter {

    final ITabQueryFragment tabQueryFragment;

    public TabQueryFragmentPresenter(ITabQueryFragment tabQueryFragment) {
        this.tabQueryFragment = tabQueryFragment;
    }

    @Override
    public void loadDataOfTime() {
        final GridCardAdapter gridCardAdapter = new GridCardAdapter(tabQueryFragment
                .getActivity());
        tabQueryFragment.setAdapter(gridCardAdapter);
        gridCardAdapter.getPresenter().setType(IGridCardAdapterPresenter.Types.BY_TIME);

        FlightModel.getScheduleFlight(new IResponseScheduleFlight() {
            @Override
            public void onSuccess(List<AirlineScheduleEntity> entitys) {
                for(AirlineScheduleEntity entity: entitys) {
                    gridCardAdapter.addData(entity);
                }
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    public void loadDataOfCost() {
        final GridCardAdapter gridCardAdapter = new GridCardAdapter(tabQueryFragment
                .getActivity());
        tabQueryFragment.setAdapter(gridCardAdapter);
        gridCardAdapter.getPresenter().setType(IGridCardAdapterPresenter.Types.BY_COST);

        FlightModel.getScheduleFlight(new IResponseScheduleFlight() {
            @Override
            public void onSuccess(List<AirlineScheduleEntity> entitys) {
                for(AirlineScheduleEntity entity: entitys) {
                    gridCardAdapter.addData(entity);
                }
            }

            @Override
            public void onError(String message) {

            }
        });
    }

    @Override
    public void loadDataOfSeat() {
        final GridCardAdapter gridCardAdapter = new GridCardAdapter(tabQueryFragment
                .getActivity());
        tabQueryFragment.setAdapter(gridCardAdapter);
        gridCardAdapter.getPresenter().setType(IGridCardAdapterPresenter.Types.BY_SEAT);


        FlightModel.getScheduleFlight(new IResponseScheduleFlight() {
            @Override
            public void onSuccess(List<AirlineScheduleEntity> entitys) {
                for(AirlineScheduleEntity entity: entitys) {
                    gridCardAdapter.addData(entity);
                }
            }

            @Override
            public void onError(String message) {

            }
        });
    }
}
