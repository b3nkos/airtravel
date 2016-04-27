package com.apps.contenidos.raalzate.airtravel;

import android.app.Application;

import com.firebase.client.Firebase;


/**
 * Created by MyMac on 20/02/16.
 */
public class MainApp extends Application {

    public enum Properties {

        URL_FIREBASE ("https://air-travel.firebaseio.com/");

        private String property;
        Properties(String s) {
            property = s;
        }

        @Override
        public String toString() {
            return property;
        }
    }

    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
