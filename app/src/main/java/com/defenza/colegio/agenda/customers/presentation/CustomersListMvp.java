package com.defenza.colegio.agenda.customers.presentation;

import com.defenza.colegio.agenda.customers.domain.entities.Customer;

import java.util.List;

/**
 * Contrato MVP para la lista de clientes
 */

public interface CustomersListMvp {
    interface View {
        void showCustomers(List<Customer> customers);

        void showLoadingState(boolean show);

        void showEmptyState();

        void showCustomersError(String msg);

        void showCustomersPage(List<Customer> customers);

        void showLoadMoreIndicator(boolean show);

        void showEndlessScroll(boolean show);

        void setPresenter(CustomersListMvp.Presenter presenter);
    }

    interface Presenter {
        void loadCustomers(boolean refresh);

    }
}
