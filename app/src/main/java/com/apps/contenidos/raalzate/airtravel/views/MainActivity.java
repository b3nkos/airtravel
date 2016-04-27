package com.apps.contenidos.raalzate.airtravel.views;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import android.widget.TextView;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.presenters.MainActivityPresenter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IMainActivity;

import roboguice.activity.RoboActionBarActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActionBarActivity implements
        IMainActivity, OnItemSelectedListener, View.OnClickListener{

    // UI references.
    @InjectView(R.id.spinner) Spinner spinner;
    @InjectView(R.id.fab) FloatingActionButton fab;
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
        fab.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
