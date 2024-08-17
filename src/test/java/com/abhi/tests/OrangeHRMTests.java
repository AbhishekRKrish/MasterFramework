package com.abhi.tests;

import com.abhi.annotations.FrameworkAnnotation;
import com.abhi.enums.CategoryType;
import com.abhi.pages.OrangeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.Test;
import java.util.Map;

public final class OrangeHRMTests extends BaseTest {

    /**
     * Private constructor to avoid external instantiation
     */
    private OrangeHRMTests() {}

    /**
     * Test Name mentioned here should match the column name "testname" in excel sheet.This is mandatory to run this
     * test. Otherwise it will be ignored.
     * The match has to be there in both of the RUNMANAGER and TESTDATA sheet
     * Set the authors who have the created the test which will be logged to the reports
     * @param data HashMap containing all the values of test data needed to run the tests
     */
    @Test
    @FrameworkAnnotation(author= {"Abhishek"},
            category = {CategoryType.REGRESSION})
    public void loginLogoutTest(Map<String,String> data) {

        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM123");
    }

    @Test
    public void newTest(Map<String,String> data) {
        String title = new OrangeHRMLoginPage()
                .enterUserName(data.get("username")).enterPassWord(data.get("password")).clickLogin()
                .clickWelcome().clickLogout()
                .getTitle();
        throw new SkipException("skip");
		/*Assertions.assertThat(title)
			.isEqualTo("OrangeHRM");*/
    }

}
