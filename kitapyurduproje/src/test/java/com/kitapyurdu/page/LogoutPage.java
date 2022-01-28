package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;

public class LogoutPage {

    Methods methods;

    public LogoutPage(){
        methods = new Methods();
    }

    public void logout() {
        methods.mouseHover(By.cssSelector(".login.menu.top"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".login ul li:nth-of-type(4)"));
        methods.waitBySeconds(4);
    }
}
