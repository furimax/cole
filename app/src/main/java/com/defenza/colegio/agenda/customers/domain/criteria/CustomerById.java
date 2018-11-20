package com.defenza.colegio.agenda.customers.domain.criteria;

import com.google.common.base.Preconditions;
import com.defenza.colegio.agenda.customers.domain.entities.Customer;
import com.defenza.colegio.agenda.selection.specification.MemorySpecification;

/**
 * Especifica solo coincidencias de clientes por ID
 */

public class CustomerById implements MemorySpecification<Customer> {
    private String mCustomerId;

    public CustomerById(String customerId) {
        mCustomerId = Preconditions.checkNotNull(customerId,
                "customerId no puede ser null");
    }

    @Override
    public boolean isSatisfiedBy(Customer item) {
        return mCustomerId.equals(item.getId());
    }
}
