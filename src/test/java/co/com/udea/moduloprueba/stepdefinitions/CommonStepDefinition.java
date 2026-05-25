package co.com.udea.moduloprueba.stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actions.Open;

public class CommonStepDefinition extends StepDefinition {

    @Dado("que el usuario esta en la pagina de login")
    public void theUserIsOnTheSauceDemoLoginPageWithoutAccents() {
        String baseUrl = System.getProperty("webdriver.base.url", "https://www.saucedemo.com/");
        Buyer().attemptsTo(Open.url(baseUrl));
    }

    @Cuando("el usuario intenta ingresar directamente a {string}")
    public void elUsuarioIntentaIngresarDirectamenteA(String path) {
        Buyer().wasAbleTo(
                Open.url("https://www.saucedemo.com/" + path)
        );
    }
}