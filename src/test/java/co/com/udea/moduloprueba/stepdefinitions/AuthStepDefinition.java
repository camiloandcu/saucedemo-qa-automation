package co.com.udea.moduloprueba.stepdefinitions;

import co.com.udea.moduloprueba.models.UserCredentials;
import co.com.udea.moduloprueba.questions.ErrorMessageText;
import co.com.udea.moduloprueba.questions.ProductsPageTitle;
import co.com.udea.moduloprueba.tasks.Login;
import co.com.udea.moduloprueba.tasks.LoginTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AuthStepDefinition extends StepDefinition {

    @Cuando("el usuario inicia sesion con credenciales validas")
    public void elUsuarioIniciaSesionConCredencialesValidas() {
        Buyer().attemptsTo(
                LoginTask.withCredentials(UserCredentials.STANDARD_USER, UserCredentials.PASSWORD)
        );
    }

    @Cuando("el usuario inicia sesion con credenciales invalidas")
    public void elUsuarioIniciaSesionConCredencialesInvalidas() {
        Buyer().attemptsTo(
                LoginTask.withCredentials(UserCredentials.STANDARD_USER, "wrong_password")
        );
    }

    @Entonces("el usuario deberia ver el mensaje de error {string}")
    public void elUsuarioDeberiaVerElMensajeDeError(String mensajeErrorEsperado) {
        Buyer().should(
                seeThat(ErrorMessageText.displayed(), is(equalTo(mensajeErrorEsperado)))
        );
    }

    @Entonces("el usuario deberia ver un mensaje de error")
    public void anErrorMessageShouldBeDisplayed() {
        Buyer().should(seeThat(ErrorMessageText.displayed(), notNullValue()));
        Buyer().should(seeThat(ErrorMessageText.displayed(), org.hamcrest.Matchers.not(isEmptyOrNullString())));
    }

}