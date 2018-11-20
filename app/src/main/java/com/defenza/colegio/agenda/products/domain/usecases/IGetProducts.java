package com.defenza.colegio.agenda.products.domain.usecases;

import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.selection.Query;
import com.defenza.colegio.agenda.products.domain.model.Product;

import java.util.List;

/**
 * Abstracción del interactor para obtener productos
 */

public interface IGetProducts {
    void getProducts(@NonNull Query query, boolean forceLoad, GetProductsCallback callback);

    interface GetProductsCallback {
        void onSuccess(List<Product> products);

        void onError(String error);
    }
}
