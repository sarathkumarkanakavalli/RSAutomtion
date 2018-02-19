package RSAutomationProject.RSAutomationProject;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources" }, format = {
		"json:target/CucumberTestReport.json",
		"html:target/site/cucumber-pretty" }, glue = "RSAutomationProject\\RSAutomationProject",
		tags = {"@EndtoEnd,@SearchResults"})
public class RunnerTest extends AbstractTestNGCucumberTests {
}
