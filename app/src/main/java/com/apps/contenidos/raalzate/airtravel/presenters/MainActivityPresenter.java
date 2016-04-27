package com.apps.contenidos.raalzate.airtravel.presenters;

import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.IMainActivityPresenter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IMainActivity;

/**
 * Created by MyMac on 26/04/16.
 */
public class MainActivityPresenter implements IMainActivityPresenter {

    private final IMainActivity mainActivity;

    public MainActivityPresenter(IMainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}
