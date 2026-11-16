package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
    @io.cucumber.java.AfterStep
    public void slowDown() throws InterruptedException {
        Thread.sleep(1500);   // 1.5 seconds after every step
    }
}