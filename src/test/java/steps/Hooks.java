package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take a screenshot BEFORE quitting, only if the scenario failed
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure screenshot");
        }
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
