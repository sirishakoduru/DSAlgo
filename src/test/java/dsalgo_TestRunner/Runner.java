package dsalgo_TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Features/Array.feature"},
		tags= " ",
		publish=true,
		glue= {"dsalgo_StepDefinition","dsalgo_Hooks"},
		plugin={"pretty","html:target/CucumberReports/CucumberReport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		//dryRun=true, // checks mapping between scenario steps and step definition methods

		)
public class Runner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
 

}
