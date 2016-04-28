package com.apps.contenidos.raalzate.airtravel.views.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;
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
        gridCardAdapterPresenter.setData(new ArrayList<AirlineScheduleEntity>());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_flight, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        gridCardAdapterPresenter.onBindViewHolder((CardViewHolder)holder, position);
    }

    @Override
    public int getItemCount() {
        return gridCardAdapterPresenter.getFlightSize();
    }

    @Override
    public void renderViewHolder(CardViewHolder holder,
                                 String name, String date, String cost, String seat) {
        holder.text.setText(name);
        holder.date.setText(date);
        holder.cost.setText(cost);
        holder.availableSeats.setText(seat);
    }

    @Override
    public void refresh() {
        notifyDataSetChanged();
    }

    @Override
    public void addData(AirlineScheduleEntity flights) {
            getPresenter().addData(flights);
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
        public final TextView text;
        public final TextView date;
        public final TextView cost;
        public final TextView availableSeats;
        public final View view;

        public CardViewHolder(View view) {
            super(view);
            this.view = view;
            text = (TextView) view.findViewById(R.id.info_text);
            date = (TextView) view.findViewById(R.id.date);
            cost = (TextView) view.findViewById(R.id.cost);
            availableSeats = (TextView) view.findViewById(R.id.available_seats);
        }
    }
}
