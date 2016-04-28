package com.apps.contenidos.raalzate.airtravel.views.interfaces;

import android.app.Activity;
import android.support.v17.leanback.widget.VerticalGridView;

import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;

/**
 * Created by MyMac on 27/04/16.
 */
public interface ITabQueryFragment {
    void setAdapter(GridCardAdapter adapter);
    VerticalGridView getVerticalGridView();
    Activity getActivity();
}
