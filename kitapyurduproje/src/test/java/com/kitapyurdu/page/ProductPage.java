package com.kitapyurdu.page;

import com.kitapyurdu.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage {

    Methods methods;

    public ProductPage(){
        methods = new Methods();

    }

    public void scroll(){
        methods.sendKeys(By.id("search-input"),"Oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.cssSelector("div[class='product-list']>:nth-child(7)"));
        methods.waitBySeconds(6);

        int i=4;
        while (i<9){
            methods.selectProducts(By.xpath("//div[@id='product-table']/div//i[@class='fa fa-heart']"),i);
            methods.waitBySeconds(4);
            i++;
            methods.waitBySeconds(3);
            if(i==8){
                break;
            }
        }


    }

    public void catalog() {
        methods.click(By.xpath("//div[@class='logo-text']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(2);
        methods.selectByText(By.xpath("//div[@class='sort']/select"), "Yüksek Oylama");
        methods.waitBySeconds(2);

    }

    public void allBooksAddCart(){
        methods.click(By.xpath("//span[@class='mn-strong common-sprite' and text()='Tüm Kitaplar']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[@class='mn-icon icon-angleRight' and text()='Hobi']"));
        methods.waitBySeconds(2);
        methods.randomProduct(By.cssSelector(".pr-img-link"));
        methods.waitBySeconds(4);
        methods.click(By.cssSelector("#button-cart > span"));
        methods.waitBySeconds(4);
    }

    public void removeFavorite(){

        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//span[@class='display-item sprite sprite-icon-list-selected']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//div[@class='product-list']/div[3]//i[@class='fa fa-heart-o']"));
        methods.waitBySeconds(3);

    }

    public void productCart(){

        methods.click(By.id("sprite-cart-icon"));
        methods.waitBySeconds(2);
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(2);
        methods.clear(By.name("quantity"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.name("quantity"), "2");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".fa-refresh"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//div[@class='right']/a[contains(.,'Satın Al')]"));
        methods.waitBySeconds(2);

    }

    public void addAddress(){
        methods.click(By.xpath("//a[.='Yeni bir adres kullanmak istiyorum.']"));
        methods.sendKeys(By.id("address-firstname-companyname"), "Ahmet");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-lastname-title"), "Alibeşe");
        methods.waitBySeconds(1);
        methods.selectByText(By.cssSelector("#address-zone-id"), "İstanbul");
        methods.waitBySeconds(3);
        methods.selectByText(By.xpath("//select[@id='address-county-id']"), "BAĞCILAR");
        methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#address-address-text"), "Yeni mah. 1551.sokak");
        methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#address-telephone"), "1231231212");
        methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#address-mobile-telephone"), "5321231212");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(4);
    }

    public void buyPhase(){
        methods.sendKeys(By.xpath("//input[@id='credit-card-owner']"), "Ahmet Alibeşe");
        methods.sendKeys(By.cssSelector(".form tr:nth-of-type(5) input:nth-of-type(1)"), "5506");
        methods.sendKeys(By.cssSelector("input:nth-of-type(2)"), "9001");
        methods.sendKeys(By.cssSelector("input:nth-of-type(3)"), "4020");
        methods.sendKeys(By.cssSelector("input:nth-of-type(4)"), "0105");
        methods.selectByText(By.cssSelector("#credit-card-expire-date-month"), "12");
        methods.waitBySeconds(3);
        methods.selectByText(By.cssSelector("#credit-card-expire-date-year"), "2024");
        methods.sendKeys(By.xpath("//input[@id='credit-card-security-code']"), "376");
        methods.waitBySeconds(3);
        WebElement basketCheckBox1 = methods.findElement(By.cssSelector("[for='credit-card-is-3ds']"));
        basketCheckBox1.click();
        methods.click(By.xpath("//button[@id='button-checkout-continue']"));
        methods.waitBySeconds(3);
        WebElement basketCheckBox = methods.findElement(By.cssSelector("[name='agree']"));
        basketCheckBox.click();
        methods.waitBySeconds(4);
        methods.click(By.xpath("//input[@class='button']"));
        methods.waitBySeconds(6);
        methods.click(By.xpath("//img[@alt='kitapyurdu.com']"));
        methods.waitBySeconds(3);
    }


}
