package com.defenza.colegio.agenda.invoices;

import android.os.Bundle;
import android.view.Menu;

import com.defenza.colegio.agenda.BaseActivity;
import com.defenza.colegio.agenda.R;
import com.defenza.colegio.agenda.di.DependencyProvider;
import com.defenza.colegio.agenda.invoices.presentation.InvoicesFragment;
import com.defenza.colegio.agenda.invoices.presentation.InvoicesPresenter;

public class InvoicesActivity extends BaseActivity{

    public static final int REQUEST_ADD_INVOICE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoices);

        InvoicesFragment fragment = (InvoicesFragment)
                getSupportFragmentManager().findFragmentById(R.id.invoices_container);

        setTitle(R.string.invoices);

        if (fragment == null) {
            fragment = InvoicesFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.invoices_container, fragment)
                    .commit();
        }

        InvoicesPresenter presenter = new InvoicesPresenter(
                fragment,
                DependencyProvider.provideGetInvoices());

        fragment.setPresenter(presenter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.invoices_menu, menu);
        return true;
    }


    @Override
    protected NavDrawerItemEnum getNavDrawerItem(){
        return NavDrawerItemEnum.INVOICES;
    }
}
