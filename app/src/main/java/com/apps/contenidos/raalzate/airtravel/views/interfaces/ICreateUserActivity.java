package com.apps.contenidos.raalzate.airtravel.views.interfaces;

import android.content.Context;

/**
 * Created by MyMac on 26/04/16.
 */
public interface ICreateUserActivity {
    void showProgress(boolean show);
    void gotoMainActivity();
    void showMessage(String message);

    Context getBaseContext();
}
