package co.com.udea.moduloprueba.stepdefinitions;

import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actions.Open;

public class CommonStepDefinition extends StepDefinition {

    @Dado("que el usuario está en la página de inicio de sesión")
    public void theUserIsOnTheSauceDemoLoginPage() {
        String baseUrl = System.getProperty("webdriver.base.url", "https://www.saucedemo.com/");
        Buyer().attemptsTo(Open.url(baseUrl));
    }
}