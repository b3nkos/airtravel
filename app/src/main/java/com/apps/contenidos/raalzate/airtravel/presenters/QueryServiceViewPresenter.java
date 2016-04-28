package com.apps.contenidos.raalzate.airtravel.presenters;

import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IQueryServiceViewPresenter;
import com.apps.contenidos.raalzate.airtravel.views.fragments.TabQueryByCostFragment;
import com.apps.contenidos.raalzate.airtravel.views.fragments.TabQueryBySeatFragment;
import com.apps.contenidos.raalzate.airtravel.views.fragments.TabQueryByTimeFragment;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IQueryServiceView;

/**
 * Created by raalzate on 27/04/2016.
 */
public class QueryServiceViewPresenter implements IQueryServiceViewPresenter {
    private IQueryServiceView queryServiceView;
    public QueryServiceViewPresenter(IQueryServiceView queryServiceView) {
        this.queryServiceView = queryServiceView;
    }

    @Override
    public void loadContentTab() {
        queryServiceView.addTab("Horario de Vuelo", new TabQueryByTimeFragment());
        queryServiceView.addTab("Tarifa de Vuelo", new TabQueryByCostFragment());
        queryServiceView.addTab("Estado de Vuelo", new TabQueryBySeatFragment());
    }
}
