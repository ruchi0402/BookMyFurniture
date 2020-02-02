Project: Mindtree SDET Assessment 


One of the client in Mindtree want to move from functional testing to automation testing. Client wants to design a framework which will be developed as by its technical partner. Client business runs only on web application which supports multiple rest APIs in a backend. The requirement is to design a framework that supports both selenium functional automation and API automation with Java scripting.

This read me file is talking about the Selenium Automation portion of the Assignment.
Web Application: Book my Furniture: : http://okmry52647dns.eastus.cloudapp.azure.com:9090 

Framework:

Hybrid Framework which contains the following components-
Page Object Model-Design Pattern-approach( Page Chaining Model)
+
Data Driven Framework
+
TestNG

Framework contains below components:
1  Page Classes contains Object Repository and Actions on the Webelements.
2) Test Classes contains test methods.
3) Test Base-(Parent class of all the test classes)
4) Base Class- Base class is for driver and browser set up. It extends Read Properties class from which it is getting browser and url data. This is inherited by the testbase class.
5) Common Methods contains repeatable methods that are called from page classes.
6) Properties file class that reads url and browser data from the config.properties file.
7) Test Util class- (Excel utility, Screenshot capture)
8) External data sheet(xls format)
9) Common Constant class contains common static data.

Technology
Java
Selenium Webdriver
TestNg
Gradle
Apache POI API
Extent Report/TestNg Report
Log4j API
Jenkins- CI
Git Repo
Browsers
Windows







  
