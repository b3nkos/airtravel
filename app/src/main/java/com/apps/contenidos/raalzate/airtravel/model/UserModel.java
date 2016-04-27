package com.apps.contenidos.raalzate.airtravel.model;

import com.apps.contenidos.raalzate.airtravel.MainApp;
import com.apps.contenidos.raalzate.airtravel.model.entitys.UserEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseCreateUser;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseLoginUser;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by MyMac on 26/04/16.
 */
public class UserModel {

    public static void create(final String email, final String password,
                              final IResponseCreateUser responseCreateUser){

        Firebase ref = new Firebase(MainApp.Properties.URL_FIREBASE.toString());
        ref.createUser(email, password,
                new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                responseCreateUser.onSuccess(
                        new UserEntity(result.get("uid").toString(), email, password)
                );
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                responseCreateUser.onError(firebaseError.getMessage());
            }
        });
    }

    public static void login(final String email, final String password,
                             final IResponseLoginUser responseLoginUser){

        Firebase ref = new Firebase(MainApp.Properties.URL_FIREBASE.toString());
        ref.authWithPassword(email,password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                responseLoginUser.onSuccess(
                        new UserEntity(authData.getUid(), email, password)
                );
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                responseLoginUser.onRestricted();
            }
        });
    }

}
