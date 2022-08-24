package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class CalculatorReportTest extends TestBaseRapor {
    CalculationPage calculationPage=new CalculationPage();


    @Test
    public void positiveTest() {
        //Feature:US001 positive calculator test
        //  Scenario: TC01 User tests factorial of 8 is 40320
        extentTest=extentReports.createTest("Positive Test","User tests factorial of 8 is 40320");
        //    Given User navigates to "calculator" page

        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //    Then writes "8" to placeholder

        calculationPage.placeholder.sendKeys("8");
        extentTest.pass("Then writes \"8\" to placeholder");
        //    Then clicks to calculate button

        calculationPage.calculateButton.click();
        extentTest.pass("Then clicks to calculate button");
        //    And verify the result of calculation


        String actualResult = calculationPage.result.getText();
        String expectedResult="The factorial of 8 is: 40320";
        String[] s = expectedResult.split(" ");

        //s[5] is 40320
        extentTest.pass(" And verify the result of calculation");

        Assert.assertTrue(actualResult.contains(s[5]),"result is not true");
        extentTest.pass("it is tested that app gives the correct result");
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

    }

    @Test
    public void verificationPubinnoLink(){
        //Feature: US002 Verification of Pubinno Link
        extentTest=extentReports.createTest("Verification of Pubinno Link"
                ,"Verifying Pubinno Link");
        //  Scenario: Verifying Pubinno Link
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //    Then verify the content of pubinno link
        extentTest.fail("Then verify the content of pubinno link");
        String expected="Pubinno";

        String actual=calculationPage.pubinnoLink.getText();

        extentTest.fail("Content of link is wrong");
        Assert.assertEquals(actual,expected,"Content of link is wrong");

    }

    @Test
    public void verifyIfPubinnoLinkDirectsToHomePage(){
        // Scenario: Verify if pubinno link directs to HomePage
        extentTest=extentReports.createTest("Verifying the direction of Pubinno Link","Verify if pubinno link directs to HomePage");
        // Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //    When clicks to pubinno link

        calculationPage.pubinnoLink.click();
        extentTest.pass("clicks to pubinno link");
        //    Then navigates to pubinno homepage
        String title = Driver.getDriver().getTitle();
        String expectedTitle="Pubinno | The Future of Draft Beer - Beer tap system";
        extentTest.pass("navigates to pubinno homepage");
        Assert.assertEquals(title,expectedTitle,"User couldn't be directed to HomePage");
        extentTest.pass("Navigation to HomePage is successfull");
    }

    @Test
    public void termsAndConditionsPage(){
        //Feature: US003 User Verifies Terms and Conditions
        //  Scenario: User verify whether the link directs to expected page
        extentTest=extentReports.createTest("User Verifies Terms and Conditions"
                ,"Verifying Pubinno Link");
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //    When clicks on terms and conditions link

        calculationPage.termsAndConditions.click();
        extentTest.pass("clicks to termsAndConditions link");
        //    Then verifies if the direction is correct
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://pubinno-qa-interview.azurewebsites.net/terms";
        extentTest.fail("Then verifies if the direction is correct");
        extentTest.fail("Terms and Conditions Link Directs to wrong page");
        Assert.assertEquals(actualUrl,expectedUrl,"Terms and Conditions Link Directs to wrong page");
    }

    @Test
    public void privacyPage(){
        //Feature: US004 User Verifies Privacy
        //  Scenario: User verifies whether the privacy link directs to expected page
        extentTest=extentReports.createTest("User Verifies Privacy"
                ,"User verifies whether the privacy link directs to expected page");
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //    When clicks privacy link

        calculationPage.privacy.click();
        extentTest.pass("clicks to privacy link");
        //    Then user verifies if the direction is correct
        extentTest.fail("Then verifies if the direction is correct");
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://pubinno-qa-interview.azurewebsites.net/privacy";
        extentTest.fail("Privacy Link Directs to wrong page");
        Assert.assertEquals(actualUrl,expectedUrl,"Privacy Link Directs to wrong page");
    }

    @Test
    public void usabilityOfEnterButton(){
        //Feature: US005 Evaluation of the application with the usability aspects
        //  Scenario: User clicks to Enter from the Keyboard
        extentTest=extentReports.createTest("Evaluation of the application with the usability aspects"
                ,"User clicks to Enter from the Keyboard");
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //    When writes "4" to placeholder

        calculationPage.placeholder.sendKeys("4");
        extentTest.pass("Writes 4 to placeholder");
        //    Then clicks to Enter from the Keyboard
        Actions actions=new Actions(Driver.getDriver());
        actions.keyDown(Keys.ENTER).perform();
        ReusableMethods.waitFor(5);
        String text = calculationPage.result.getText();
        extentTest.fail("Then clicks to Enter from the Keyboard but Place Holder can not get the integer");
        Assert.assertEquals(text,"The factorial of 4 is: 24"
                ,"Enter button is not enabled.It should be better If it is activated");
    }

    @Test
    public void usabilityOfRightArrow(){
        // Scenario: User clicks to RightArrow
        extentTest=extentReports.createTest("User clicks to RightArrow"
                ,"User verifies whether the right arrow is activated or not");
        //      Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");
        //      When writes "4" to placeholder

        calculationPage.placeholder.sendKeys("4");
        extentTest.pass("Writes 4 to placeholder");
        //      Then clicks to rightArrow button
        calculationPage.arrowRight.click();
        //      And User should see the result
        String actualText = calculationPage.result.getText(); //When clicked to rightArrow button.It provides no result.
        //so it means button is not activated
        String expectedText="The factorial of 4 is: 24";
        extentTest.fail("When User clicks Right Arrow.Place Holder can not get the integer");
        Assert.assertEquals(actualText,expectedText
                ,"RightArrow button is not enabled.It should be better If it is activated");
    }
    @Test
    public void usabilityOfPlaceHolder(){
        //User should understand clearly what the content of placeholder means
        //  Scenario: User reads the context of placeholder
        extentTest=extentReports.createTest("User should understand clearly what the content of placeholder means"
                ,"User reads the context of placeholder");
        //    Given  User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        extentTest.pass("Given User navigates to \"calculator\" page");

        //        Then user should understand the context of placeholder clearly

        String actualContext=calculationPage.cssValueofPlaceHolder.getAttribute("placeholder");//Enter an Integer
        String expectedContext="Enter a number"; //for example;because it is more understandable
        extentTest.fail("The context of place holder is not understandable");
        Assert.assertEquals(actualContext,expectedContext,"User may not understand what the meaning of \"INTEGER\" is");

    }
}
