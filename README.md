Project: SDET Assessment
One of the client in Mindtree want to move from functional testing to automation testing. Client wants to design a framework which will be developed as by its technical partner. Client business runs only on web application which supports multiple rest APIs in a backend. The requirement is to design a framework that supports both selenium functional automation and API automation with Java scripting.

Web Application: Book my Furniture: : http://okmry52647dns.eastus.cloudapp.azure.com:9090
Swagger URL: http://okmry52647dns.eastus.cloudapp.azure.com:8089/swagger-ui.html


The assessment has 3 tracks:
 1) Selenium Automation
 2) WebServices Automation
 3) Rest Assured API Automation
 
  Tools used for Selenium Automation
  a) Eclipse
  
  Framework: Page Object Model using TestNg framework with Extent Reports and Log4j for reporting and logs respectivey. 
  5 Page classes are created, all elements are defined using @FindBy and initiated using a Page Factory Constructor method. One Base Page class is created which contains the driver, browser method, common methods for clicking butoton/link or sending text to the text box.
  Action methods are created using the elements on the page[e.g. Login method]
  BaseTest class contains @BeforeMethod and @AfterMethod which calls Browser instantiate and TestResult methods, this is common for all the test classes.
  
