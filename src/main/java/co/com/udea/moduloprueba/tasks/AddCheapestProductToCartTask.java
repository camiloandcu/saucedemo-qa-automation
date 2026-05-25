package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.questions.CatalogProductsQuestion;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.Optional;

public class AddCheapestProductToCartTask implements Task {

    public static AddCheapestProductToCartTask now() {
        return new AddCheapestProductToCartTask();
    }

    @Override
    @Step("{0} agrega el producto mas barato al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SortCatalogByPriceTask.lowToHigh());

        List<co.com.udea.moduloprueba.models.Product> products = CatalogProductsQuestion.displayed().answeredBy(actor);
        Optional<co.com.udea.moduloprueba.models.Product> cheapest = products.stream()
                .filter(product -> addButtonFor(product).isVisibleFor(actor))
                .findFirst();

        if (cheapest.isEmpty()) {
            throw new IllegalStateException("No se encontro un producto barato disponible para agregar");
        }

        co.com.udea.moduloprueba.models.Product selectedProduct = cheapest.get();
        actor.remember("selectedProductName", selectedProduct.getName());
        actor.attemptsTo(ClickOn.the(addButtonFor(selectedProduct)));
    }

    private Target addButtonFor(co.com.udea.moduloprueba.models.Product product) {
        return Target.the("boton para agregar " + product.getName())
                .locatedBy(product.addButtonSelector());
    }
}