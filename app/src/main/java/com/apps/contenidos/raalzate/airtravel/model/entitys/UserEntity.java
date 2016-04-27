package com.apps.contenidos.raalzate.airtravel.model.entitys;

/**
 * Created by MyMac on 26/04/16.
 */
public class UserEntity {
    public final String id;
    public final String email;
    public final String password;


    public UserEntity(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
