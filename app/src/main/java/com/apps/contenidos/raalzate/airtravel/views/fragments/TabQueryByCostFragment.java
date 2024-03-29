package com.apps.contenidos.raalzate.airtravel.views.fragments;

import android.os.Bundle;
import android.support.v17.leanback.widget.VerticalGridView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.presenters.TabQueryFragmentPresenter;
import com.apps.contenidos.raalzate.airtravel.views.adapter.GridCardAdapter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.ITabQueryFragment;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Created by MyMac on 26/04/16.
 */
public class TabQueryByCostFragment extends RoboFragment implements ITabQueryFragment {

    @InjectView(R.id.grid_view) VerticalGridView gridView;
    private GridLayoutManager gridLayoutManager;
    private TabQueryFragmentPresenter tabQueryByTimeFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_flight, container, false);
        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabQueryByTimeFragmentPresenter = new TabQueryFragmentPresenter(this);
        initViews();
    }

    private void initViews() {
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);

        gridView.setLayoutManager(gridLayoutManager);
        gridView.setHasFixedSize(true);
        gridView.setVerticalMargin(54);
        gridView.setSoundEffectsEnabled(true);
        gridView.setItemAnimator(itemAnimator);
        tabQueryByTimeFragmentPresenter.loadDataOfCost();

    }


    public VerticalGridView getVerticalGridView() {
        return gridView;
    }


    public void setAdapter(GridCardAdapter adapter) {
        getVerticalGridView().setAdapter(adapter);
    }
}
