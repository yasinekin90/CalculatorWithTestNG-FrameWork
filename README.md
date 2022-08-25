# CalculatorWithTestNG-FrameWork
## Here is the project structure
![image](https://user-images.githubusercontent.com/100432135/186505592-3a4cabdf-9e9d-4a1e-9e6a-e561c245a52f.png)

## Explanations
I have designed the framework with POM Architecture in TestNG FrameWork.First of all I created three packages under Java directory such as pages,test and utilities.
And then created one configuration.properties file.Additionaly added necessary dependincy and plugins in pom.xml file.I created two different classes for testing under test package.One of is CalculatorReportTest,the other one is CalculatorTest.Why is it so?.Because creating a report with TestNG is a bit complex and you have to extend your class to TestBaseRapor class which is under utilities package.If you do that.you cant make cross browser test.Because at the same time you have to extend your class to TestBaseCross class under utilities package.In conclusion I created CalculatorReportTest for reporting and CalculatorTest for cross browser testing.
## pages
Under pages package , CalculationPage which is involved pagefactory and locators of the website These are used for invoking from Test classes
![image](https://user-images.githubusercontent.com/100432135/186495889-159b4670-4cdb-401a-a2ec-f053e4aece55.png)
## test
There are two classes named CalculatorReportTest and CalculatorTest.The first one is used for reporting and the other one used for cross browser testing
## utilities
Under utilities package ; ConfigurationReader,Driver,ReusableMethods,CrossDriver,TestBaseCross and TestBaseRapor

### ConfigurationReader:
This class is used for reading the infos in configuration.properties file

### Driver:
This class is used for getting browsers in short way by using ConfigurationReader

### ReusableMethods:
This class is used for invoking reusable methods in a shortway

### CrossDriver:
It is defined all browsers for cross browser testing in this class.TestBaseCross invokes this class to be used in CalculatorTest class

### TestBaseCross:
We extend this class in CalculatorTest class to invoke browsers in a short way

### TestBaseRapor:
This class have methods to be used for reporting in CalculatorReportTest.We have to extend it to be used 
## xml-files
Under this package; crossBrowserTest.xml and TestForReporting.xml files

### crossBrowserTest.xml:
We use this file to run tests with different browsers.Lets see in the video.You can run the file in order or change the codes and make a parallel test by running browsers at the same time.Lets see how we run it in the video

https://user-images.githubusercontent.com/100432135/186613684-98463bfc-836c-4b55-b7b1-387b2b851072.mp4

### TestForReporting.xml:
We use this file to create reports of our tests.Lets see how we run it in the video 

https://user-images.githubusercontent.com/100432135/186615767-8ad3142f-9c11-484f-b64a-e49f8f7c8781.mp4






