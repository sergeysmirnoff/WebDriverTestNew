package com.test.selenium;

import com.company.HomePage777;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class SeleniumTest extends BaseSeleniumTest {

    private HomePage777 homePage777;

    @Before
    public void beforeEachSeleniumLoginPageTest() {
        homePage777 = new HomePage777(webDriver);
    }

    @Test
    public void SelectLand() {
        homePage777.open();
        for(int i=1; i <= 3; i++) {
            homePage777.MouseOver("ChooseLanguageDlgOpener");
            homePage777.SelectMenuItem("//*[@id=\"Col1\"]/ul/li["+ i +"]/a");
            String actLand = homePage777.getSelectedLang();
            String expLang = homePage777.getExpectedLangByIndex(i);
            assertEquals(expLang, actLand);
        }
    }
}