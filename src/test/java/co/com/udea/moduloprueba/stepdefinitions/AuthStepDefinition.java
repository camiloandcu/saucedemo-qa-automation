package co.com.udea.moduloprueba.stepdefinitions;

import co.com.udea.moduloprueba.questions.ErrorMessageText;
import co.com.udea.moduloprueba.questions.ProductsPageTitle;
import co.com.udea.moduloprueba.tasks.Login;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.notNullValue;

public class AuthStepDefinition extends StepDefinition {

    @Cuando("el usuario inicia sesión con nombre de usuario {string} y contraseña {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        Buyer().attemptsTo(Login.withCredentials(username, password));
    }

    @Entonces("el usuario debería ser redirigido a la página de productos")
    public void theUserShouldBeRedirectedToTheProductsPage() {
        Buyer().should(seeThat(ProductsPageTitle.displayed(), equalTo("Products")));
    }

    @Entonces("el título de la página debería mostrar {string}")
    public void thePageTitleShouldDisplay(String expectedTitle) {
        Buyer().should(seeThat(ProductsPageTitle.displayed(), equalTo(expectedTitle)));
    }

    @Entonces("debería mostrarse un mensaje de error")
    public void anErrorMessageShouldBeDisplayed() {
        Buyer().should(seeThat(ErrorMessageText.displayed(), notNullValue()));
        Buyer().should(seeThat(ErrorMessageText.displayed(), org.hamcrest.Matchers.not(isEmptyOrNullString())));
    }

    @Entonces("el mensaje de error debería contener {string}")
    public void theErrorMessageShouldContain(String expectedMessage) {
        Buyer().should(seeThat(ErrorMessageText.displayed(), containsString(expectedMessage)));
    }
}