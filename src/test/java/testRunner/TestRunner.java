package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./features/",
        glue = "stepDefinations",
        dryRun=false,
        monochrome = true,
        plugin = {"pretty","html:testOutput/index.html"}


)
public class TestRunner {
}
