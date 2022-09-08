package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resources\\features\\LoginPage.feature",
		glue= {"stepDefinitions","AppHooks"},
		monochrome=true,
		dryRun=false,
		publish=true,
		plugin= {"pretty","html:target/MyReports/report.html"}
		)
public class MyTestRunner {

}
