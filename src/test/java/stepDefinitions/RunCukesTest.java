package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = {"@chimp "},
		features = {"classpath:features/"},
		glue = { "classpath:stepDefinitions"},
		plugin = {"pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json", "html:target/cucumber-reports"}
	)
public class RunCukesTest {

}
