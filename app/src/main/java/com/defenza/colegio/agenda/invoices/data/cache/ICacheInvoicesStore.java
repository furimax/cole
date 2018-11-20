package com.defenza.colegio.agenda.invoices.data.cache;

import com.defenza.colegio.agenda.invoices.domain.entities.Invoice;
import com.defenza.colegio.agenda.invoices.domain.entities.InvoiceUi;
import com.defenza.colegio.agenda.selection.Query;

import java.util.List;

/**
 * Estandariza las operaciones estandar en caché sobre las facturas
 */

public interface ICacheInvoicesStore {

    interface LoadInvoicesUiCallback{
        void onInvoicesUiLoaded(List<InvoiceUi> invoiceUis);
        void onDataNotAvailable();
    }

    List<Invoice> getInvoices(Query query);

    void getInvoicesUis(Query query, LoadInvoicesUiCallback callback);

    void addInvoice(Invoice invoice);

    void deleteInvoices();

    boolean isCacheReady();
}
