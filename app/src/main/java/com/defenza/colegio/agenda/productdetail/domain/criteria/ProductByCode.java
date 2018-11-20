package com.defenza.colegio.agenda.productdetail.domain.criteria;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.defenza.colegio.agenda.selection.specification.ProviderSpecification;
import com.defenza.colegio.agenda.external.sqlite.DatabaseContract.Products;
import com.defenza.colegio.agenda.selection.specification.MemorySpecification;
import com.defenza.colegio.agenda.products.domain.model.Product;

/**
 * Criterio para obtener productos por ID
 */

public class ProductByCode implements MemorySpecification<Product>,
        ProviderSpecification {

    private String mProductCode;

    public ProductByCode(@NonNull String productCode) {
        mProductCode = Preconditions.checkNotNull(productCode,
                "productCode no puede ser null");
    }

    @Override
    public boolean isSatisfiedBy(Product product) {
        return mProductCode.equals(product.getCode());
    }


    @Override
    public Uri asProvider() {
        return Products.buildUriWith(mProductCode);
    }
}
