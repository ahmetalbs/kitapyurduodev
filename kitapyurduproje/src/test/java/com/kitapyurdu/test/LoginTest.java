package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void baseTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }
}
