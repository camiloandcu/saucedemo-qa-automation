package co.com.udea.moduloprueba.stepdefinitions;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.models.Product;
import co.com.udea.moduloprueba.models.UserCredentials;
import co.com.udea.moduloprueba.questions.CatalogProductsQuestion;
import co.com.udea.moduloprueba.questions.CartProductsQuestion;
import co.com.udea.moduloprueba.questions.CartBadgeCount;
import co.com.udea.moduloprueba.questions.ErrorMessageText;
import co.com.udea.moduloprueba.questions.OrderConfirmationMessage;
import co.com.udea.moduloprueba.tasks.AddCheapestProductToCartTask;
import co.com.udea.moduloprueba.tasks.AddRandomProductToCartTask;
import co.com.udea.moduloprueba.tasks.CompleteOrderTask;
import co.com.udea.moduloprueba.tasks.FillCheckoutInfoTask;
import co.com.udea.moduloprueba.tasks.LoginTask;
import co.com.udea.moduloprueba.tasks.ProceedToCheckoutTask;
import co.com.udea.moduloprueba.tasks.RemoveAllProductsFromCartTask;
import co.com.udea.moduloprueba.tasks.RemoveOneProductFromCartTask;
import co.com.udea.moduloprueba.tasks.SortCatalogByPriceTask;
import co.com.udea.moduloprueba.userinterfaces.LoginPage;
import co.com.udea.moduloprueba.userinterfaces.CheckoutStepOnePage;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingStepDefinition extends StepDefinition {

    @When("agrega un producto aleatorio al carrito")
    public void agregaUnProductoAleatorioAlCarrito() {
        Buyer().attemptsTo(
                AddRandomProductToCartTask.now()
        );
    }

    @When("agrega el producto mas barato al carrito")
    public void agregaElProductoMasBaratoAlCarrito() {
        Buyer().attemptsTo(
                AddCheapestProductToCartTask.now()
        );
    }

    @When("ordena el catalogo por precio de menor a mayor")
    public void ordenaElCatalogoPorPrecioDeMenorAMayor() {
        Buyer().attemptsTo(
                SortCatalogByPriceTask.lowToHigh()
        );
    }

    @When("elimina un producto del carrito")
    public void eliminaUnProductoDelCarrito() {
        Buyer().attemptsTo(
                RemoveOneProductFromCartTask.now()
        );
    }

    @When("elimina todos los productos del carrito")
    public void eliminaTodosLosProductosDelCarrito() {
        Buyer().attemptsTo(
                RemoveAllProductsFromCartTask.now()
        );
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        Buyer().attemptsTo(
                ProceedToCheckoutTask.fromCart()
        );
    }
    
    @When("completa la informacion de envio")
    public void completaLaInformacionDeEnvio() {
        Buyer().attemptsTo(
                FillCheckoutInfoTask.withData("Juan", "Perez", "5001")
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

    @Then("el carrito deberia estar vacio")
    public void elCarritoDeberiaEstarVacio() {
        List<String> cartItems = CartProductsQuestion.displayed().answeredBy(Buyer());
        assertThat(cartItems, empty());
    }

    @Then("el catalogo deberia estar ordenado de menor a mayor")
    public void elCatalogoDeberiaEstarOrdenadoDeMenorAMayor() {
        List<Double> currentPrices = new ArrayList<>(CatalogProductsQuestion.displayed().answeredBy(Buyer()).stream()
                .map(Product::getPrice)
                .toList());
        List<Double> orderedPrices = new ArrayList<>(currentPrices);
        Collections.sort(orderedPrices);

        assertThat(currentPrices, equalTo(orderedPrices));
    }

}
