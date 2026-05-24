package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class AddProductsToCartTask implements Task {

    private final List<String> productNames;

    public AddProductsToCartTask(List<String> productNames) {
        this.productNames = productNames;
    }

    public static AddProductsToCartTask withNames(List<String> productNames) {
        return new AddProductsToCartTask(productNames);
    }

    @Override
    @Step("{0} agrega los productos al carrito")
    public <T extends Actor> void performAs(T actor) {
        for (String productName : productNames) {
            Target addButton = getAddButtonForProduct(productName);
            actor.attemptsTo(ClickOn.the(addButton));
        }
    }

    private Target getAddButtonForProduct(String productName) {
        String normalized = productName.toLowerCase()
                .replace(" ", "-")
                .replace("'", "")
                .replace("é", "e");
        return Target.the("boton agregar " + productName)
                .locatedBy("#add-to-cart-" + normalized);
    }
}
