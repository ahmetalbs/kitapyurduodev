package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.HomePage;
import com.kitapyurdu.page.LoginPage;
import com.kitapyurdu.page.LogoutPage;
import com.kitapyurdu.page.ProductPage;
import org.junit.Test;

public class MainTest extends BaseTest {

    @Test
    public void mainTest(){

        HomePage homePage = new HomePage();
        homePage.home();

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        ProductPage productPage = new ProductPage();
        productPage.scroll();
        productPage.catalog();
        productPage.allBooksAddCart();
        productPage.removeFavorite();
        productPage.productCart();
        productPage.addAddress();
        productPage.buyPhase();

        LogoutPage logoutPage = new LogoutPage();
        logoutPage.logout();

    }
}
