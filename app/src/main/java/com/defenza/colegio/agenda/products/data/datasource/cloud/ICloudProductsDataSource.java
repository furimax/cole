package com.defenza.colegio.agenda.products.data.datasource.cloud;

import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.selection.Query;
import com.defenza.colegio.agenda.products.domain.model.Product;

import java.util.List;

/**
 * Interfaz de comunicación con el repositorio para la fuente de datos remota
 */
public interface ICloudProductsDataSource {

    interface ProductServiceCallback {

        void onLoaded(List<Product> products);

        void onError(String error);

    }

    void getProducts(@NonNull Query query, String userToken, ProductServiceCallback callback);

}
