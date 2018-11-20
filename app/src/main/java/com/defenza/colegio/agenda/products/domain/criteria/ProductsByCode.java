package com.defenza.colegio.agenda.products.domain.criteria;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.defenza.colegio.agenda.products.domain.model.Product;
import com.defenza.colegio.agenda.selection.specification.MemorySpecification;
import com.defenza.colegio.agenda.selection.specification.ProviderSpecification;

import java.util.List;

/**
 * Obtener productos por donde el código sea...
 */

public class ProductsByCode implements MemorySpecification<Product>, ProviderSpecification {

    private List<String> mCodes;

    public ProductsByCode(@NonNull List<String> codes) {
        mCodes = Preconditions.checkNotNull(codes);
    }

    @Override
    public boolean isSatisfiedBy(Product item) {
        boolean satisfied = false;
        for(String code: mCodes){
            satisfied = satisfied || code.equals(item.getCode());
        }
        return satisfied;
    }

    @Override
    public Uri asProvider() {
        // TODO: Implementar
        return null;
    }
}
