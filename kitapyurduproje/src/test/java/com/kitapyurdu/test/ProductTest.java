package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {
    @Test
    public void productTest(){
        ProductPage productPage = new ProductPage();
        productPage.scroll();
        productPage.catalog();
        productPage.allBooksAddCart();
        productPage.removeFavorite();
        productPage.productCart();
        productPage.addAddress();
        productPage.buyPhase();


    }
}
