package com.apps.contenidos.raalzate.airtravel.model.interfaces;

import com.apps.contenidos.raalzate.airtravel.model.entitys.UserEntity;


/**
 * Created by MyMac on 26/04/16.
 */
public interface IResponseCreateUser {
    void onSuccess(UserEntity entity);
    void onError(String message);
}
