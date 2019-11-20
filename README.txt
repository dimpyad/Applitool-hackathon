Introduction: 
=============
This file will detail about the Java project created for Applitool Visual AI Rockstar hackathon. 
Please follow the below instructions to build and run the tests.

Prerequisite:
============
1) Java should be installed (Used Java 12 for development)
2) Chrome browser should be installed (Version used Version 78.0.3904.108 (Official Build) (64-bit))
3) Download chrome driver suitable for the chrome browser installed from https://chromedriver.chromium.org/downloads. 
4) Add an entry into Path environment variable pointing to the path to chrome driver. 
Note: Since chrome driver size is more, I am not keeping the same in the project.

Folder structure of the project:
src/main/java/core 
      - EyesManager.java  - Wrapper class for Applitools eye java SDK support for visual AI test suite
	  - ExtendManager.java - Wrapper class for Extend report support for traditional test suite
	  
src/main/java/pages
      - page object classes designed and shared across both traditional and visual AI suite
	  
src/test/java/base
      - BaseTests.java - Base class for all the test scripts
	  - TestListener.java - Listener class for extend report
	  
src/test/java/TraditionalTests
      - This package contains all the test scripts developed using traditional approach

src/test/java/VisualAITests
      - This package contains all the test scripts developed using Visual AI approach

src/test/java/DataProviders
      - This package contains java classes for building/parsing test data. I am using csv file as data provider.
	  
src/test/resources
      - config.properties file contains all the supported test configurations
      - data folder contains csv test data file
	  - screenshots contains image files downloaded for canvas testing using traditional approach
TestReport - This folder contains the html reports generated using extend report plugin for traditional test suite.
testSuites - This folder contains testng.xml files for batch execution
    - 	traditional_v1.xml ( traditional testng suite file for app version1)
	- 	traditional_v2.xml ( traditional testng suite file for app version2)
	-   visual_AI_v1.xml (visual AI test suite file for app version1)
	-   visual_AI_v2.xml (visual AI test suite file for app version2)
	
Execution steps:
================
Following details needs to be updated in config.properties file
applitools.api.key=<Key for applittool sdk)

app.version=<v1 if app version1 is used and v2 if app version2 is used>
app.test.type=<TRD - for traditional approach and VAI for visual AI approach>

Note: This properties should be set properly to execute the individual tests 
otherwise use testng.xml files under testSuites folder for batch execution.

