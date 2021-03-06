package com.defenza.colegio.agenda.addeditinvoiceitem.data;

import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.addeditinvoice.domain.entities.InvoiceItemUi;
import com.defenza.colegio.agenda.invoices.domain.entities.InvoiceItem;

import java.util.List;

/**
 * Estandar para caché de items de factura
 */

public interface ICacheInvoiceItemsStore {
    interface LoadInvoiceItemsUiCallback {

        void onInvoiceItemsLoaded(List<InvoiceItemUi> invoiceItemUis);

        void onDataNotAvailable();

    }

    interface GetInvoiceItemUiCallback {

        void onInvoiceItemUiLoaded(InvoiceItemUi invoiceItemUi);

        void onDataNotAvailable();

    }

    List<InvoiceItem> getInvoiceItems();

    void getInvoiceItemUi(@NonNull String productId, @NonNull GetInvoiceItemUiCallback callback);

    void getInvoiceItemsUi(@NonNull LoadInvoiceItemsUiCallback callback);

    void saveInvoiceItem(@NonNull InvoiceItem invoiceItem);

    void deleteInvoiceItem(@NonNull String productId);

    void deleteAll();

    float getTotal();

    float getSubtotal();

    float getTax();

}
