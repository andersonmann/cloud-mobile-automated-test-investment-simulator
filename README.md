# cloud-mobile-automated-test-investment-simulator

## Getting Started
This code was developed to the technical challenge at the Plataforma Digital Sicredi.(enjoy)
The tests are executed at real devices on browserStack cloud.

These instructions will get you a copy of the project up and running on your local machine for development and testing 
purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Java JRE
* Java JDK
* Appium Server
* Android Studio
* Apache Maven
* Smartphone or Simulator
* Selenium Webdriver
* IDE (ex. eclipse)
* BrowserStack account

### Installing

To running this project, you need do it the following steps:

```
At Eclipse IDE
```

```
Access File > Import...
```

```
Projects from Git
```

```
Select a wizard to use importing projects choose the option Import as general project
```

```
Right click on the project and choose an option
```

```
Configure > Convert to Maven Project
```

Double check

```
verify that all dependencies of the project have been downloaded.
```

## Devices
Are used the following real devices to execute the tests:

```
iPhone XS
```

```
"Samsung Galaxy S10
```

Are possible use hundreds of devices, you just need change the parameter of single.conf.json file, located at folder src/test/resources.

## Running the tests

NOTICE 1: The tests are running at BrowserStack datacenters!!
NOTICE 2: The account used is free and has a usage limit!!
To run the suite test, you should execute the file suite.multiplatform.xml, located at folder src/main/resources.
You can also run by command line through maven commands.

### Maven commands

```
open the terminal.
```

```
navigate to root folder of the project.
```

```
run the command: mvn clean.
```

```
run the command: mvn compile.
```

```
run the command: mvn test.
```

## Accessing the browserStack

After or during the execution of the tests, you can check the resources available in the browserstack.
Among which I can cite:

```
Text logs.
```

```
Visual logs.
```

```
Console logs.
```

```
Recorded video.
```

```
Network logs.
```

```
Appium logs.
```

### To access all the features, do the following steps.

```
Access BrowserStack site: https://www.browserstack.com/.
```

```
Sign in: user: testesicredi2019@gmail.com, password: woop2019
```

```
Access the menu: Products/Automate
```

```
Done, the results of all executions will be displayed.
```

### Purpose of the tests

```
The tests created simulate an finance invest.
Were explored different types of locators and strategies.
```

### Design Pattern

The below design patterns are used at this project

```
DSL
```

```
Factory
```

```
Singleton
```

```
Strategy
```

```
page object
```

## Deployment

You just must execute the suite test (suite.multiplatform.xml).

## Built With

* [SELENIUM WEBDRIVER](http://seleniumwebdriver.org/selenium-webdriver/) - The automation framework used
* [TestNG](https://testng.org/doc/documentation-main.html/) - The automation framework used
* [MAVEN](https://maven.apache.org/) - Dependency Management
* [JAVA](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html/) - Programing language
* [APPIUM](http://appium.io/) - The automation framework to mobile connection
* [SonarLint](https://www.sonarlint.org/eclipse/) - Lint
* [BrowserStack](https://www.browserstack.com/) - BrowserStack is a cloud and mobile testing platform.


## Versioning

Was used [Sourcetree](https://www.sourcetreeapp.com//) for versioning. 

## Authors

* **Anderson Mann** - *Sr. QA Engineer* - [GitHub](https://github.com/andersonmann)

## License

This project is licensed under the GNU License.
