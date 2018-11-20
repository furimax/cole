package com.defenza.colegio.agenda.products.presentation;

import com.google.common.base.Preconditions;
import com.defenza.colegio.agenda.selection.Query;
import com.defenza.colegio.agenda.login.data.IUsersRepository;
import com.defenza.colegio.agenda.products.domain.criteria.ProductsNoFilter;
import com.defenza.colegio.agenda.products.domain.model.Product;
import com.defenza.colegio.agenda.products.domain.usecases.IGetProducts;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Presentador que escucha los eventos de la UI y luego presenta los resultados a la vista
 */
public class ProductsPresenter implements ProductsMvp.Presenter {

    public static final int REFRESH_LOAD_TYPE = 1;
    public static final int NEW_PAGE_LOAD_TYPE = 2;
    public static final int ON_RESUME_LOAD_TYPE = 3;

    private final ProductsMvp.View mProductsView;
    private final IGetProducts mGetProducts;
    private final IUsersRepository mUsersRepository;

    private static final int PRODUCTS_LIMIT = 20;

    private boolean mIsFirstLoad = true;
    private int mCurrentPage = 1;


    public ProductsPresenter(ProductsMvp.View productsView, IGetProducts getProducts,
                             IUsersRepository usersRepository) {
        mProductsView = checkNotNull(productsView, "productsView no puede ser null");
        mGetProducts = checkNotNull(getProducts, "getProducts no puede ser null");
        mUsersRepository = checkNotNull(usersRepository, "usersRepository no puede ser null");
    }

    @Override
    public void loadProducts(final int loadType) {

        switch (loadType) {
            case REFRESH_LOAD_TYPE:
                loadProductsWithRefresh();
                break;

            case NEW_PAGE_LOAD_TYPE:
                loadNewProductsPage();
                break;

            case ON_RESUME_LOAD_TYPE:
                if(mIsFirstLoad){
                    loadProductsWithRefresh();
                }
                break;
        }

    }


    private void loadProductsWithRefresh() {
        mProductsView.showLoadingState(true);
        mCurrentPage = 1; // Reset...

        // Construir Query...
        Query query = new Query(
                new ProductsNoFilter(), // Filtro
                "name", Query.ASC_ORDER,        // Orden
                mCurrentPage, PRODUCTS_LIMIT);  // Paginado

        // Retornar Productos...
        mGetProducts.getProducts(query, true, new IGetProducts.GetProductsCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                mProductsView.showLoadingState(false);
                if (products.isEmpty()) {
                    mProductsView.showEmptyState();
                    mProductsView.allowMoreData(false);
                } else {
                    mProductsView.showProducts(products);
                    mProductsView.allowMoreData(true);
                }
                mIsFirstLoad = false;

            }

            @Override
            public void onError(String error) {
                mProductsView.showLoadingState(false);
                mProductsView.showProductsError(error);
            }
        });
    }

    private void loadNewProductsPage() {
        mProductsView.showLoadMoreIndicator(true);
        mCurrentPage++;

        // Construir Query...
        Query query = new Query(
                new ProductsNoFilter(), // Filtro
                "name", Query.ASC_ORDER,        // Orden
                mCurrentPage, PRODUCTS_LIMIT);  // Paginado

        // Retornar Productos...
        mGetProducts.getProducts(query, false, new IGetProducts.GetProductsCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                mProductsView.showLoadMoreIndicator(false);

                if (products.isEmpty()) {
                    mProductsView.allowMoreData(false);
                } else {
                    mProductsView.showProductsPage(products);
                    mProductsView.allowMoreData(true);
                }
                mIsFirstLoad = false;

            }

            @Override
            public void onError(String error) {
                mProductsView.showLoadMoreIndicator(false);
                mProductsView.showProductsError(error);
            }
        });
    }

    @Override
    public void openProductDetails(String productCode) {
        Preconditions.checkNotNull(productCode, "productCode no puede ser null");
        mProductsView.showProductDetailScreen(productCode);
    }

    @Override
    public void logOut() {
        mUsersRepository.closeSession();
        mProductsView.showLoginScreen();
    }

}
