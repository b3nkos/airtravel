package com.apps.contenidos.raalzate.airtravel.views;

import android.support.v7.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.presenters.MainActivityPresenter;
import com.apps.contenidos.raalzate.airtravel.views.adapter.ServiceAdapter;
import com.apps.contenidos.raalzate.airtravel.views.fragments.ServiceFragment;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IMainActivity;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity implements
        IMainActivity, OnItemSelectedListener{

    // UI references.
    @InjectView(R.id.spinner) Spinner spinner;
    @InjectView(R.id.toolbar) Toolbar toolbar;

    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        initVars();
    }

    private void initViews(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        spinner.setOnItemSelectedListener(this);
        mainActivityPresenter = new MainActivityPresenter(this);
    }

    private void initVars(){
        spinner.setAdapter(new ServiceAdapter(toolbar.getContext(),
                new String[]{"Consulta de Vuelo", "Reserva de vuelo", "Estado de Vuelo",}));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, ServiceFragment.newInstance(position + 1))
                .commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
