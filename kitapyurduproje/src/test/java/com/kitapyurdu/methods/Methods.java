package com.kitapyurdu.methods;

import com.kitapyurdu.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public Methods(){

        driver = BaseTest.driver;
        wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by){
        findElement(by).click();
    }

    public void waitBySeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void scrollWithAction(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollWithJavaScript(By by){
        jsdriver.executeScript("arguments[0].scrollIntoView();",findElement(by));
    }

    public Select getSelect(By by){
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by,String attributeName){
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by){
        return findElement(by).getText();
    }

    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value",findElement(by)).toString();
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void randomProduct(By by){
        Random rnd = new Random();
        List<WebElement> products = findElements(by);
        int index = rnd.nextInt(products.size());
        products.get(index).click();
    }

    public void selectProducts(By by,int i){
        Random random = new Random(i);
        List<WebElement> products = findElements(by);
        int index = random.nextInt(products.size());
        products.get(index).click();
    }

    public void clear(By by){
        findElement(by).clear();
    }

    public void assertPage(String message, String expectedValue, String actual) {
        Assert.assertEquals(message, expectedValue, actual);
    }

    public void mouseHover(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }



}