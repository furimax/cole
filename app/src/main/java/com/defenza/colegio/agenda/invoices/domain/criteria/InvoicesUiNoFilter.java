package com.defenza.colegio.agenda.invoices.domain.criteria;

import com.defenza.colegio.agenda.invoices.domain.entities.InvoiceUi;
import com.defenza.colegio.agenda.selection.specification.MemorySpecification;

/**
 * Especificación para todos las facturas parciales
 */

public class InvoicesUiNoFilter implements MemorySpecification<InvoiceUi> {
    @Override
    public boolean isSatisfiedBy(InvoiceUi item) {
        return true;
    }
}
