package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
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

    // Only pauses when run with -Dslow=true (for demos); CI stays fast
    @AfterStep
    public void slowDown() throws InterruptedException {
        if (System.getProperty("slow") != null) {
            Thread.sleep(1500);
        }
    }
}