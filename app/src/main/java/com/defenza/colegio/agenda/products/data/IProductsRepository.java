package com.defenza.colegio.agenda.products.data;

import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.selection.Query;
import com.defenza.colegio.agenda.products.domain.model.Product;

import java.util.List;

/**
 * Repositorio de productos
 */
public interface IProductsRepository {
    interface GetProductsCallback {

        void onProductsLoaded(List<Product> products);

        void onDataNotAvailable(String error);
    }

    void getProducts(@NonNull Query query, GetProductsCallback callback);

    void refreshProducts();
}
