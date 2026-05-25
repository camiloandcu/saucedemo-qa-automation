package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.models.Product;
import co.com.udea.moduloprueba.questions.CatalogProductsQuestion;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class AddRandomProductToCartTask implements Task {

    public static AddRandomProductToCartTask now() {
        return new AddRandomProductToCartTask();
    }

    @Override
    @Step("{0} agrega un producto aleatorio al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitForElement.toBeVisible(InventoryPage.PRODUCT_LIST_CONTAINER));

        List<Product> selectableProducts = CatalogProductsQuestion.displayed().answeredBy(actor).stream()
                .filter(product -> isAddButtonVisibleFor(actor, product))
                .collect(Collectors.toList());

        if (selectableProducts.isEmpty()) {
            throw new IllegalStateException("No hay productos disponibles para agregar al carrito");
        }

        Product selectedProduct = selectableProducts.get(ThreadLocalRandom.current().nextInt(selectableProducts.size()));
        actor.remember("selectedProductName", selectedProduct.getName());
        actor.attemptsTo(ClickOn.the(addButtonFor(selectedProduct)));
    }

    private boolean isAddButtonVisibleFor(Actor actor, Product product) {
        return addButtonFor(product).isVisibleFor(actor);
    }

    private Target addButtonFor(Product product) {
        return Target.the("boton para agregar " + product.getName())
                .locatedBy(product.addButtonSelector());
    }
}