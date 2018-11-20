package com.defenza.colegio.agenda.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.defenza.colegio.agenda.addeditinvoiceitem.data.CacheInvoiceItemsStore;
import com.defenza.colegio.agenda.customers.data.CustomersRepository;
import com.defenza.colegio.agenda.customers.data.cache.CacheCustomersStore;
import com.defenza.colegio.agenda.customers.domain.usecases.GetCustomers;
import com.defenza.colegio.agenda.invoices.data.InvoicesRepository;
import com.defenza.colegio.agenda.invoices.data.cache.CacheInvoicesStore;
import com.defenza.colegio.agenda.invoices.domain.usecases.GetInvoicesForUi;
import com.defenza.colegio.agenda.invoices.domain.usecases.SaveInvoice;
import com.defenza.colegio.agenda.login.data.UsersRepository;
import com.defenza.colegio.agenda.login.data.cloud.CloudUsersDataSource;
import com.defenza.colegio.agenda.login.data.preferences.UserPrefs;
import com.defenza.colegio.agenda.login.domain.usecases.LoginInteractor;
import com.defenza.colegio.agenda.products.data.ProductsRepository;
import com.defenza.colegio.agenda.products.data.datasource.cloud.CloudProductsDataSource;
import com.defenza.colegio.agenda.products.data.datasource.local.LocalProductsDataSource;
import com.defenza.colegio.agenda.products.data.datasource.memory.MemoryProductsDataSource;
import com.defenza.colegio.agenda.products.domain.usecases.GetProducts;

/**
 * Contenedor de dependencias
 */
public final class DependencyProvider {


    private DependencyProvider() {
    }

    public static ProductsRepository provideProductsRepository(@NonNull Context context) {
        return ProductsRepository.getInstance(
                MemoryProductsDataSource.getInstance(),
                LocalProductsDataSource.getInstance(context.getContentResolver()),
                CloudProductsDataSource.getInstance(),
                UserPrefs.getInstance(context),
                context);
    }

    public static UsersRepository provideUsersRepository(@NonNull Context context) {
        return UsersRepository.getInstance(CloudUsersDataSource.getInstance(),
                UserPrefs.getInstance(context), context);
    }

    public static LoginInteractor provideLoginInteractor(@NonNull Context context) {
        return new LoginInteractor(provideUsersRepository(context));
    }

    public static GetProducts provideGetProducts(@NonNull Context context) {
        return new GetProducts(provideProductsRepository(context));
    }

    public static GetCustomers provideGetCustomers(){
        return new GetCustomers(provideCustomersRepository());
    }

    private static CustomersRepository provideCustomersRepository() {
        return CustomersRepository.getInstance(CacheCustomersStore.getInstance());
    }

    public static GetInvoicesForUi provideGetInvoices() {
        return new GetInvoicesForUi(provideInvoicesRepository());
    }

    private static InvoicesRepository provideInvoicesRepository() {
        return InvoicesRepository.getInstance(
                CacheInvoicesStore.getInstance(provideCustomersRepository()));
    }

    public static SaveInvoice provideSaveInvoice(){
        return new SaveInvoice(provideInvoicesRepository());
    }

    public static CacheInvoiceItemsStore provideCacheInvoiceItemsStore(@NonNull Context context) {
        return CacheInvoiceItemsStore.getInstance(provideProductsRepository(context));
    }
}
