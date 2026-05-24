package co.com.udea.moduloprueba.stepdefinitions;

import co.com.udea.moduloprueba.models.UserCredentials;
import co.com.udea.moduloprueba.questions.CartBadgeCount;
import co.com.udea.moduloprueba.questions.ErrorMessageText;
import co.com.udea.moduloprueba.questions.OrderConfirmationMessage;
import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.tasks.AddProductsToCartTask;
import co.com.udea.moduloprueba.tasks.CompleteOrderTask;
import co.com.udea.moduloprueba.tasks.FillCheckoutInfoTask;
import co.com.udea.moduloprueba.tasks.LoginTask;
import co.com.udea.moduloprueba.tasks.ProceedToCheckoutTask;
import co.com.udea.moduloprueba.tasks.RemoveProductFromCartTask;
import co.com.udea.moduloprueba.userinterfaces.CheckoutStepOnePage;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ShoppingStepDefinition extends StepDefinition {

    @Given("que el usuario esta en la pagina de login")
    public void queElUsuarioEstaEnLaPaginaDeLogin() {
        Buyer().wasAbleTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    @When("el usuario inicia sesion con credenciales validas")
    public void elUsuarioIniciaSesionConCredencialesValidas() {
        Buyer().attemptsTo(
                LoginTask.withCredentials(UserCredentials.STANDARD_USER, UserCredentials.PASSWORD),
                WaitForElement.toBeVisible(InventoryPage.PAGE_TITLE)
        );
    }

    @When("el usuario intenta iniciar sesion con {string} y {string}")
    public void elUsuarioIntentaIniciarSesion(String username, String password) {
        Buyer().attemptsTo(
                LoginTask.withCredentials(username, password)
        );
    }

    @When("agrega los siguientes productos al carrito:")
    public void agregaLosSiguientesProductosAlCarrito(List<String> productos) {
        Buyer().attemptsTo(
                AddProductsToCartTask.withNames(productos)
        );
    }

    @When("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String productName) {
        Buyer().attemptsTo(
                AddProductsToCartTask.withNames(List.of(productName))
        );
    }

    @When("elimina {string} del carrito")
    public void eliminaDelCarrito(String productName) {
        Buyer().attemptsTo(
                RemoveProductFromCartTask.called(productName)
        );
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        Buyer().attemptsTo(
                ProceedToCheckoutTask.fromCart()
        );
    }

    @When("completa la informacion de envio con {string}, {string} y {string}")
    public void completaLaInformacionDeEnvio(String firstName, String lastName, String postalCode) {
        Buyer().attemptsTo(
                FillCheckoutInfoTask.withData(firstName, lastName, postalCode)
        );
    }

    @When("intenta continuar sin completar los datos de envio")
    public void intentaContinuarSinCompletarLosDatosDeEnvio() {
        Buyer().attemptsTo(
                ClickOn.the(CheckoutStepOnePage.CONTINUE_BUTTON)
        );
    }

    @When("finaliza la compra")
    public void finalizaLaCompra() {
        Buyer().attemptsTo(
                CompleteOrderTask.now()
        );
    }

    @Then("el usuario deberia ver el mensaje de confirmacion {string}")
    public void elUsuarioDeberiaVerElMensajeDeConfirmacion(String mensajeEsperado) {
        Buyer().should(
                seeThat(OrderConfirmationMessage.displayed(), is(equalTo(mensajeEsperado)))
        );
    }

    @Then("el contador del carrito deberia mostrar {string}")
    public void elContadorDelCarritoDeberiaMostrar(String cantidadEsperada) {
        Buyer().should(
                seeThat(CartBadgeCount.displayed(), is(equalTo(cantidadEsperada)))
        );
    }

    @Then("el usuario deberia ver el mensaje de error {string}")
    public void elUsuarioDeberiaVerElMensajeDeError(String mensajeErrorEsperado) {
        Buyer().should(
                seeThat(ErrorMessageText.displayed(), is(equalTo(mensajeErrorEsperado)))
        );
    }
}
