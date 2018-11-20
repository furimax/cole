package com.defenza.colegio.agenda.external.api;

import com.defenza.colegio.agenda.login.domain.entities.User;
import com.defenza.colegio.agenda.products.domain.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Segmentos de URL donde actuaremos
 */
public interface RestService {

    // TODO: Usar IP o dominio propios. Agregar esquema "https" si tienes un certificado SSL
    String APP_PRODUCTOS_SERVICE_BASE_URL = "http://169.254.31.20/agendacolegio/v1/";

    @GET("products")
    Call<List<Product>> getProducts(@Header("Authorization") String authorization);

    @POST("sessions")
    Call<User> login(@Header("Authorization") String authorization);
}
