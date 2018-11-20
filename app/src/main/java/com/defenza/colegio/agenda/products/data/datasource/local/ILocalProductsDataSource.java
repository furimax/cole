package com.defenza.colegio.agenda.products.data.datasource.local;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.defenza.colegio.agenda.selection.specification.ProviderSpecification;
import com.defenza.colegio.agenda.selection.Query;
import com.defenza.colegio.agenda.products.domain.model.Product;

import java.util.List;

/**
 * Representación de fuente de datos local
 */

public interface ILocalProductsDataSource {
    interface GetCallback {
        void onProductsLoaded(List<Product> products);

        void onDataNotAvailable(String error);
    }

    void get(@NonNull Query query, @NonNull GetCallback getCallback);

    void save(@NonNull Product product);

    void delete(@Nullable ProviderSpecification specification);
}
