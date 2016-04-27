package com.apps.contenidos.raalzate.airtravel.presenters;

import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IQueryServiceViewPresenter;
import com.apps.contenidos.raalzate.airtravel.views.fragments.TabQueryTimeFragment;
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
        queryServiceView.addTab("Tab 1", new TabQueryTimeFragment());
        queryServiceView.addTab("Tab 2", new TabQueryTimeFragment());
        queryServiceView.addTab("Tab 3", new TabQueryTimeFragment());
    }
}
