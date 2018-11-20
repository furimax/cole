package com.defenza.colegio.agenda.customers.domain.criteria;

import com.defenza.colegio.agenda.customers.domain.entities.Customer;
import com.defenza.colegio.agenda.selection.specification.MemorySpecification;

/**
 * Criterio para obtener todos los clientes
 */

public class AllCustomersSpec implements MemorySpecification<Customer> {
    @Override
    public boolean isSatisfiedBy(Customer item) {
        return true;
    }
}
