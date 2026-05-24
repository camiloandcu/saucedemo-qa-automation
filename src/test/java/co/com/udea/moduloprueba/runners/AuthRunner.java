package co.com.udea.moduloprueba.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features/auth", glue = "co.com.udea.moduloprueba.stepdefinitions", tags = "@auth")
public class AuthRunner {
}