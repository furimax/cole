package com.defenza.colegio.agenda.products.presentation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Preconditions;
import com.defenza.colegio.agenda.productdetail.presentation.ProductDetailMvp;
import com.defenza.colegio.agenda.productdetail.presentation.ProductDetailPresenter;

/**
 * Presentador para el manejo de la UI master-detail de productos
 */

public class ProductsTabletPresenter
        implements ProductsMvp.Presenter, ProductDetailMvp.Presenter {

    @NonNull
    private ProductsPresenter mProductsPresenter;

    @Nullable
    private ProductDetailPresenter mProductDetailPresenter;

    public ProductsTabletPresenter(@NonNull ProductsPresenter productsPresenter) {
        mProductsPresenter = Preconditions.checkNotNull(productsPresenter);
    }

    @Nullable
    public ProductDetailPresenter getProductDetailPresenter() {
        return mProductDetailPresenter;
    }

    public void setProductDetailPresenter(ProductDetailPresenter productDetailPresenter) {
        mProductDetailPresenter = productDetailPresenter;
    }

    @Override
    public void loadProducts(int loadType) {
        mProductsPresenter.loadProducts(loadType);
    }

    @Override
    public void openProductDetails(String productCode) {
        mProductDetailPresenter.setProductCode(productCode);
        mProductDetailPresenter.loadProduct();
    }

    @Override
    public void loadProduct() {
        mProductDetailPresenter.loadProduct();
    }

    @Override
    public void logOut() {
        mProductsPresenter.logOut();
    }
}
