package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage777 {

    //private static final String URL = "https://www.777.com/";
    private static final String URL = "http://www.w3schools.com/html/html_tables.asp";
    private final WebDriver driver;

    public HomePage777(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        this.driver.get(URL);
    }

    public void MouseOver(String object)
    {
        WebElement el = this.driver.findElement(By.id(object));
        Actions action = new Actions(driver);
        action.moveToElement(el).build().perform();
    }
    public void SelectMenuItem(String object)
    {
        WebElement linkElement = this.driver.findElement(By.xpath(object));
        System.out.println(linkElement.getText());
        linkElement.click();
    }

    public String getSelectedLang()
    {
        WebElement lang = this.driver.findElement(By.className("langBUtton"));
        System.out.println(lang.getText());
        return lang.getText();
    }

    public String getExpectedLangByIndex(int i)
    {
        if (i==1)
            return  "EN";
        if (i==2)
            return "DE";
        if (i==3)
            return "FI";

        return "";
    }
}
