package test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculationPage;
import utilities.*;



public class CalculatorTest extends TestBaseCross {

    CalculationPage calculationPage=new CalculationPage();


    @Test
    public void positiveTest() {
        //Feature:US001 positive calculator test
        //  Scenario: TC01 User tests factorial of 8 is 40320

        //    Given User navigates to "calculator" page

        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));

        //    Then writes "8" to placeholder

        calculationPage.placeholder.sendKeys("8");

        //    Then clicks to calculate button

        calculationPage.calculateButton.click();

        //    And verify the result of calculation
        ReusableMethods.waitForVisibility(calculationPage.result,3);

        String actualResult = calculationPage.result.getText();
        String expectedResult="The factorial of 8 is: 40320";
        String[] s = expectedResult.split(" ");

        //s[5] is 40320

        Assert.assertTrue(actualResult.contains(s[5]),"result is not true");
        System.out.println("actualResult = " + actualResult);
        System.out.println("expectedResult = " + expectedResult);

    }

    @Test
   public void verificationPubinnoLink(){
        //Feature: US002 Verification of Pubinno Link
        //  Scenario: Verifying Pubinno Link
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        //    Then verify the content of pubinno link
        String expected="Pubinno";
        String actual=calculationPage.pubinnoLink.getText();
        Assert.assertEquals(actual,expected,"Content of link is wrong");

    }

    @Test
     public void verifyIfPubinnoLinkDirectsToHomePage(){
        // Scenario: Verify if pubinno link directs to HomePage
        // Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        //    When clicks to pubinno link
        calculationPage.pubinnoLink.click();
        //    Then navigates to pubinno homepage
        String title = Driver.getDriver().getTitle();
        String expectedTitle="Pubinno | The Future of Draft Beer - Beer tap system";

        Assert.assertEquals(title,expectedTitle,"User couldn't be directed to HomePage");
    }

    @Test
   public void termsAndConditionsPage(){
        //Feature: US003 User Verifies Terms and Conditions
        //  Scenario: User verify whether the link directs to expected page
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        //    When clicks on terms and conditions link
        calculationPage.termsAndConditions.click();
        //    Then verifies if the direction is correct
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://pubinno-qa-interview.azurewebsites.net/terms";
        Assert.assertEquals(actualUrl,expectedUrl,"Terms and Conditions Link Directs to wrong page");
    }

    @Test
    public void privacyPage(){
        //Feature: US004 User Verifies Privacy
        //  Scenario: User verifies whether the privacy link directs to expected page
        //    Given User navigates to "calculator" page
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
        //    When clicks privacy link
        calculationPage.privacy.click();
        //    Then user verifies if the direction is correct
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://pubinno-qa-interview.azurewebsites.net/privacy";
        Assert.assertEquals(actualUrl,expectedUrl,"Privacy Link Directs to wrong page");
    }

  @Test
    public void usabilityOfEnterButton(){
        //Feature: US005 Evaluation of the application with the usability aspects
      //  Scenario: User clicks to Enter from the Keyboard
      //    Given User navigates to "calculator" page
      Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
      //    When writes "4" to placeholder
      calculationPage.placeholder.sendKeys("4");
      //    Then clicks to Enter from the Keyboard
      Actions actions=new Actions(Driver.getDriver());
      actions.keyDown(Keys.ENTER).perform();
      ReusableMethods.waitFor(5);
      String text = calculationPage.result.getText();
      Assert.assertEquals(text,"The factorial of 4 is: 24"
              ,"Enter button is not enabled.It should be better If it is activated");
  }

   @Test
  public void usabilityOfRightArrow(){
      // Scenario: User clicks to RightArrow
       //      Given User navigates to "calculator" page
       Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
       //      When writes "4" to placeholder
       calculationPage.placeholder.sendKeys("4");
       //      Then clicks to rightArrow button
       calculationPage.arrowRight.click();
       //      And User should see the result
       String actualText = calculationPage.result.getText(); //When clicked to rightArrow button.It provides no result.
       //so it means button is not activated
       String expectedText="The factorial of 4 is: 24";

        Assert.assertEquals(actualText,expectedText
                ,"RightArrow button is not enabled.It should be better If it is activated");
   }
 @Test
    public void usabilityOfPlaceHolder(){
        //User should understand clearly what the content of placeholder means
        //  Scenario: User reads the context of placeholder

     //    Given  User navigates to "calculator" page
     Driver.getDriver().get(ConfigurationReader.getProperty("calculator"));
     //        Then user should understand the context of placeholder clearly
     String actualContext=calculationPage.cssValueofPlaceHolder.getAttribute("placeholder");//Enter an Integer
     String expectedContext="Enter a number"; //for example;because it is more understandable
     Assert.assertEquals(actualContext,expectedContext,"User may not understand what the meaning of \"INTEGER\" is");

    }


}
