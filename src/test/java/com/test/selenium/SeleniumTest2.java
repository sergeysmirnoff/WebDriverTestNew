package com.test.selenium;

import com.company.TablePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class SeleniumTest2 extends BaseSeleniumTest {

    private TablePage tablePage;
    private int num;
    private String country;

    @Before
    public void beforeEachSeleniumLoginPageTest() {
        tablePage = new TablePage(webDriver);
    }

    public  SeleniumTest2(int num, String country) {
        this.num = num;
        this.country = country;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {1, "Germany"},
                {2, "Mexico"},
                {3, "Austria"},
        });
    }
    @Test
    //@Parameterized.Parameters({"Germany","Mexico","Austria","UK","Canada","Italy" })
    public void TableTest(){
        tablePage.open();
        System.out.println(country);
        assertEquals(true, tablePage.verifyTableCellText("",3,country));
    }

    @Test
    public void TableTest1(){
        tablePage.open();

        assertEquals("Germany", tablePage.getTableCellTextByXpath(3));
    }
}