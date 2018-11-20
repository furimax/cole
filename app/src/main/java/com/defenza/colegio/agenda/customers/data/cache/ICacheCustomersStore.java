package com.defenza.colegio.agenda.customers.data.cache;

import com.defenza.colegio.agenda.customers.domain.entities.Customer;
import com.defenza.colegio.agenda.selection.Query;

import java.util.List;

/**
 * Interfaz con operaciones estandar en caché sobre los clientes
 */

public interface ICacheCustomersStore {
    List<Customer> getCustomers(Query query);

    void addCustomer(Customer customer);

    void deleteCustomers();

    boolean isCacheReady();
}
