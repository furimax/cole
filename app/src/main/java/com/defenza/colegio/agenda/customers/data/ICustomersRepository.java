package com.defenza.colegio.agenda.customers.data;

import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.customers.domain.entities.Customer;
import com.defenza.colegio.agenda.selection.Query;

import java.util.List;

/**
 * Estandariza los accesos a los clientes
 */

public interface ICustomersRepository {
    interface GetCustomersCallback {
        void onCustomersLoaded(List<Customer> customers);

        void onDataNotAvailable(String errorMsg);
    }

    void getCustomers(@NonNull Query query, GetCustomersCallback callback);
}
