package co.com.udea.moduloprueba.stepdefinitions;

import co.com.udea.moduloprueba.questions.IsElementVisible;
import co.com.udea.moduloprueba.tasks.Logout;
import co.com.udea.moduloprueba.userinterfaces.LoginPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LogoutStepDefinition extends StepDefinition {

    @Cuando("el usuario cierra la sesión")
    public void theUserClosesTheSession() {
        Buyer().attemptsTo(Logout.now());
    }

    @Entonces("debería volver a la página de inicio de sesión")
    public void shouldReturnToTheLoginPage() {
        Buyer().should(seeThat(IsElementVisible.forTarget(LoginPage.LOGIN_BUTTON), equalTo(true)));
    }
}