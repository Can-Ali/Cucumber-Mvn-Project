package com.step_definitons;
    /*
    In the class we will be able to pass pre- & post- conditions to
    each scenario and each step
    */


import com.utilities.Driver;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    // we import from io.cucumber.java not from junit
    @Before(order = 1)
    public void setupScenario() {
        System.out.println("======Setting up browser using cucumber @Before");

    }

    @Before(value = "@login", order = 2)
    public void setupScenarioLogins() {
        System.out.println("======this will only apply to scenarios with @login tag");

    }

    @Before(value = "@db", order = 0)
    public void setupForDataBaseScenarios() {
        System.out.println("======this will only apply to scenarios with @db tag");
        WebDriverManager.chromedriver().setup();

    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());
        }else;


        Driver.closeDriver();

//        System.out.println("========Closing browser using cucumber @After");
//        System.out.println("=====Scenario ended/ Take screen schoot");
    }

    @BeforeStep
    public void setupStep() {
        System.out.println("--------applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep() {

        System.out.println("------------> applying tearDown using @AfterStep");
    }

}
