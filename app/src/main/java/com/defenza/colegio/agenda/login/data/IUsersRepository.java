package com.defenza.colegio.agenda.login.data;

/**
 * Dependencia del repositorio de usuarios
 */

public interface IUsersRepository {

    void auth(String email, String password, OnAuthenticateListener callback);

    void closeSession();

    interface OnAuthenticateListener {
        void onSuccess();

        void onError(String error);
    }
}
