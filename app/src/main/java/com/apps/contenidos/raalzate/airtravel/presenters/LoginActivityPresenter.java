package com.apps.contenidos.raalzate.airtravel.presenters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;


import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.model.UserModel;
import com.apps.contenidos.raalzate.airtravel.model.entitys.UserEntity;
import com.apps.contenidos.raalzate.airtravel.model.interfaces.IResponseLoginUser;
import com.apps.contenidos.raalzate.airtravel.model.utils.TinyDB;
import com.apps.contenidos.raalzate.airtravel.presenters.interfaces.ILoginActivityPresenter;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.ILoginActivity;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * Created by raalzate on 26/04/2016.
 */
public class LoginActivityPresenter implements ILoginActivityPresenter {

    private final TinyDB tinyDB;
    private final ILoginActivity iLoginActivity;
    private final Activity activity;


    public LoginActivityPresenter(ILoginActivity iLoginActivity, Activity activity) {
        this.iLoginActivity = iLoginActivity;
        this.activity = activity;
        tinyDB = new TinyDB(this.activity);
    }

    @Override
    public void loadContacts(Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ADDRESS));
            cursor.moveToNext();
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(activity,
                        android.R.layout.simple_dropdown_item_1line, emails);
        iLoginActivity.setAutoCompleteEmail(adapter);
    }

    @Override
    public boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (activity.checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (activity.shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            iLoginActivity.showPermissionRationale(new View.OnClickListener() {
                @Override
                @TargetApi(Build.VERSION_CODES.M)
                public void onClick(View v) {
                    activity.requestPermissions(new String[]{READ_CONTACTS}, ILoginActivity.REQUEST_READ_CONTACTS);
                }
            });

        } else {
            activity.requestPermissions(new String[]{READ_CONTACTS}, ILoginActivity.REQUEST_READ_CONTACTS);

        }
        return false;
    }

    @Override
    public Loader<Cursor> getContactsContract() {
        return new CursorLoader(activity,
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), PROJECTION,

                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }


    @Override
    public void attemptLoginEmailAndPassword(AutoCompleteTextView emailView, EditText passwordView) {

        emailView.setError(null);
        passwordView.setError(null);

        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordView.setError(activity.getString(R.string.error_invalid_password));
            focusView = passwordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailView.setError(activity.getString(R.string.error_field_required));
            focusView = emailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailView.setError(activity.getString(R.string.error_invalid_email));
            focusView = emailView;
            cancel = true;
        }

        if (cancel) {

            focusView.requestFocus();

        } else {

            iLoginActivity.showProgress(true);
            UserModel.login(email, password, new IResponseLoginUser() {
                @Override
                public void onSuccess(UserEntity entity) {
                    tinyDB.putString("uid", entity.id);
                    iLoginActivity.loginPass();
                }

                @Override
                public void onRestricted() {
                    iLoginActivity.showProgress(false);
                    iLoginActivity.errorLoginPass();
                }
            });

        }
    }

    @Override
    public boolean existUser() {
        return !tinyDB.getString("uid").equals("");
    }


    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }


}
