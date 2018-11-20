package com.defenza.colegio.agenda.login.data.cloud;

import com.defenza.colegio.agenda.login.domain.entities.User;

/**
 * Representación de dependencia entre el interactor de login y el controlador de la API
 */

public interface ICloudUsersDataSource {
    void auth(String name, String password, UserServiceCallback callback);


    interface UserServiceCallback {
        void onAuthFinished(User user);
        void onAuthFailed(String error);
    }
}
