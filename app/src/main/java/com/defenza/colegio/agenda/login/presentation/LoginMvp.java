package com.defenza.colegio.agenda.login.presentation;

/**
 * Contrato Mvp para Login
 */

public interface LoginMvp {

    interface View {
        void showEmailError();

        void showPasswordError();

        void login(String email, String password);

        void showLoginError(String error);

        void showLoadingIndicator(boolean show);

        void showTareasScreen();

        void setPresenter(Presenter presenter);
    }

    interface Presenter{
        void validateCredentials(String email, String password);
    }

}
