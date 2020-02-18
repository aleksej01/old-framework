**A sample project that makes use of the Test Automation Framework**

--- 

To package the project run the command `mvn clean package -DskipTests`. We skip tests at this stage because the Driver for the Web, Android or iOS platforms will not be loaded at this stage.
These drivers will be loaded during normal test run.

---

To run Web UI tests:
        
        clean verify -Denv=vodafone -Dbrowser=localChrome "-Dcucumber.options=--tags @web"

To run API tests:

        clean verify -Denv=vodafone "-Dcucumber.options=--tags @api"
        
To run Android tests:

        1. Install Appium
        2. Install Android Studio and setup a virtual device.
        3. Run the command: clean verify -DandroidDevice=nexus5 "-Dcucumber.options=--tags @android"

