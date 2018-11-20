package com.defenza.colegio.agenda.products.domain.criteria;

import android.net.Uri;

import com.defenza.colegio.agenda.selection.specification.MemorySpecification;
import com.defenza.colegio.agenda.selection.specification.ProviderSpecification;
import com.defenza.colegio.agenda.external.sqlite.DatabaseContract.Products;
import com.defenza.colegio.agenda.products.domain.model.Product;

/**
 * Criterio para obtener todos los productos
 */

public class ProductsNoFilter
        implements MemorySpecification<Product>,
        ProviderSpecification {
    @Override
    public boolean isSatisfiedBy(Product item) {
        return true;
    }

    @Override
    public Uri asProvider() {
        return Products.buildUri();
    }
}
