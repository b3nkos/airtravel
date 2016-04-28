package com.apps.contenidos.raalzate.airtravel.model.interfaces;

import com.apps.contenidos.raalzate.airtravel.model.entitys.FlightEntity;

import java.util.List;

/**
 * Created by MyMac on 27/04/16.
 */
public interface IResponseFlight {
    void onSuccess(FlightEntity entity);
    void onError(String message);
}
