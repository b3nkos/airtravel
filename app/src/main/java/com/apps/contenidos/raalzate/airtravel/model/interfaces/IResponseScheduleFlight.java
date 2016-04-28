package com.apps.contenidos.raalzate.airtravel.model.interfaces;

import com.apps.contenidos.raalzate.airtravel.model.entitys.AirlineScheduleEntity;

import java.util.List;

/**
 * Created by MyMac on 27/04/16.
 */
public interface IResponseScheduleFlight {
    void onSuccess(List<AirlineScheduleEntity> entity);
    void onError(String message);
}
