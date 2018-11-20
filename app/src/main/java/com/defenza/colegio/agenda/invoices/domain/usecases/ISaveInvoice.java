package com.defenza.colegio.agenda.invoices.domain.usecases;

import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.invoices.domain.entities.Invoice;

/**
 * Interfaz para estandarizar el guardado de facturas
 */

public interface ISaveInvoice {

    interface ExecuteCallback {
        void onSuccess(Invoice invoice);

        void onError(String error);

    }

    void execute(@NonNull Invoice invoice, ExecuteCallback callback);
}
