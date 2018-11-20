package com.defenza.colegio.agenda.invoices.domain.usecases;

import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.defenza.colegio.agenda.invoices.data.IInvoicesRepository;
import com.defenza.colegio.agenda.invoices.domain.entities.Invoice;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implementación de "Guardar factura"
 */

public class SaveInvoice implements ISaveInvoice {
    private IInvoicesRepository mInvoicesRepo;

    public SaveInvoice(IInvoicesRepository invoicesRepo) {
        mInvoicesRepo = checkNotNull(invoicesRepo);
    }

    @Override
    public void execute(@NonNull Invoice invoice,
                        ExecuteCallback callback) {
        Preconditions.checkNotNull(invoice, "invoice no puede ser null");
        mInvoicesRepo.saveInvoice(invoice);

        callback.onSuccess(invoice);
    }
}
