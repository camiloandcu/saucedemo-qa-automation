package co.com.udea.moduloprueba.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.udea.moduloprueba.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@HappyPath or @AlternativePath or @ExceptionalPath"
)
public class Runner {
}