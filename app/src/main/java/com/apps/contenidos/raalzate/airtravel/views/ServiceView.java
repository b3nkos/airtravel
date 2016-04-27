package com.apps.contenidos.raalzate.airtravel.views;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by MyMac on 26/04/16.
 */
public abstract class ServiceView  {
    protected FragmentManager fragmentManager;
    protected View view;


    public ServiceView(int layoutId, LayoutInflater inflater, ViewGroup container, FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
        view = inflater.inflate(layoutId, container, false);
    }

    public View getView(){return view;}


}
