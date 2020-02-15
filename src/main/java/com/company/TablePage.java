package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TablePage {

    private static final String URL = "http://www.w3schools.com/html/html_tables.asp";
    private final WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        this.driver.get(URL);

    }

    private String getTableCellText(String object, int searchColumn, String searchText){

        WebElement table = this.driver.findElement(By.id(object));
        List<WebElement> rowVals = table.findElements(By.tagName("tr"));
        //List<WebElement> colHeader = rowVals.get(0).findElements(By.tagName("th"));

        for(int i=1; i< rowVals.size(); i++){
            List<WebElement> colVals = rowVals.get(i).findElements(By.tagName("td"));
            if (searchText.contains(colVals.get(searchColumn).getText())){
                return colVals.get(searchColumn).getText();
            }
        }

        return "";
    }

    public boolean verifyTableCellText(String object, int searchColumn, String expectedText){
        if(expectedText.contains( getTableCellText(object, searchColumn, expectedText)))
            return true;
        else
            return  false;
    }

    public String getTableCellTextByXpath( int searchColumn)  {
        //*[@id="customers"]/tbody/tr[2]/td[1]
        WebElement element = this.driver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td["+ searchColumn +"]"));
        return element.getText();
    }

}
