package com.apps.contenidos.raalzate.airtravel.views.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;
import com.apps.contenidos.raalzate.airtravel.presenters.GridCardAdapterPresenter;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IGridCardAdapterPresenter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IGridCardAdapter;

import java.util.ArrayList;
import java.util.List;

import roboguice.RoboGuice;

/**
 * Created by raalzate on 15/03/2016.
 */
public class GridCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements IGridCardAdapter {

    private GridCardAdapterPresenter gridCardAdapterPresenter;
    private Activity activity;

    public GridCardAdapter(Activity activity) {
        RoboGuice.getInjector(activity).injectMembers(this);
        this.activity = activity;
        gridCardAdapterPresenter = new GridCardAdapterPresenter(this);
        addData(new ArrayList<FlightEntity>());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void renderViewHolder(CardViewHolder holder, String title, String urlPoster) {

    }

    @Override
    public void refresh() {

    }

    @Override
    public void addData(List<FlightEntity> flights) {
            getPresenter().setData(flights);
    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    @Override
    public IGridCardAdapterPresenter getPresenter() {
        return gridCardAdapterPresenter;
    }


    /**
     * View Holder the flight
     * R.layout.card_flight
     */
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public final ImageView imageView;
        public final View view;

        public CardViewHolder(View view) {
            super(view);
            this.view = view;
            textView = (TextView) view.findViewById(R.id.info_text);
            imageView = (ImageView) view.findViewById(R.id.poster);
        }
    }
}
