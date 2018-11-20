package com.defenza.colegio.agenda.login.data.preferences;

import com.defenza.colegio.agenda.login.domain.entities.User;

/**
 * Representación de las preferencias de usuarios
 */

public interface IUserPreferences {

    void save(User user);

    void delete();

    boolean isLoggedIn();

    String getAccessToken();

    String getUserName();

    String getUserId();
}
