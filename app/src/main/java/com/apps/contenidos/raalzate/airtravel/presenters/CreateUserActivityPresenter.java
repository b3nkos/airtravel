package com.apps.contenidos.raalzate.airtravel.presenters;

import com.apps.contenidos.raalzate.airtravel.model.UserModel;
import com.apps.contenidos.raalzate.airtravel.model.entitys.UserEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseCreateUser;
import com.apps.contenidos.raalzate.airtravel.model.utils.TinyDB;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.ICreateUserActivityPresenter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.ICreateUserActivity;

/**
 * Created by MyMac on 26/04/16.
 */
public class CreateUserActivityPresenter implements ICreateUserActivityPresenter {

    private ICreateUserActivity createUserActivity;
    private TinyDB tinyDB;

    public CreateUserActivityPresenter(ICreateUserActivity createUserActivity){
        this.createUserActivity = createUserActivity;
        tinyDB = new TinyDB(createUserActivity.getBaseContext());
    }

    @Override
    public void createUser(String email, String pass) {
        createUserActivity.showProgress(true);
        UserModel.create(email, pass, new IResponseCreateUser() {
            @Override
            public void onSuccess(UserEntity entity) {
                createUserActivity.showProgress(false);
                createUserActivity.showMessage("Usuario creado :)!");
                tinyDB.putString("uid", entity.id);
                createUserActivity.gotoMainActivity();
            }

            @Override
            public void onError(String message) {
                createUserActivity.showProgress(false);
                createUserActivity.showMessage("Existe un problema al crear el usuario.");
            }
        });
    }
}
