package com.apps.contenidos.raalzate.airtravel.views;

/**
 * Created by MyMac on 26/04/16.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public  class ServiceFragment extends Fragment {

    private static final String ARG_SERVICE_SECTION = "section_number";

    public ServiceFragment() {
    }


    public static ServiceFragment newInstance(int sectionNumber) {
        ServiceFragment fragment = new ServiceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SERVICE_SECTION, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return getServiceView(inflater, container).getView();
    }



    private ServiceView getServiceView(LayoutInflater inflater, ViewGroup container){

        switch (getArguments().getInt(ARG_SERVICE_SECTION)) {
            case 1: return new QueryServiceView(inflater, container, getFragmentManager());
            case 2: return new QueryServiceView(inflater, container, getFragmentManager());
            case 3: return new QueryServiceView(inflater, container, getFragmentManager());
        }
        return null;
    }
}
