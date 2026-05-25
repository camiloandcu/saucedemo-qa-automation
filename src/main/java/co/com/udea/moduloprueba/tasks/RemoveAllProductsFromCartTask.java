package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.models.Product;
import co.com.udea.moduloprueba.questions.CartProductsQuestion;
import co.com.udea.moduloprueba.userinterfaces.CartPage;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllProductsFromCartTask implements Task {

    public static RemoveAllProductsFromCartTask now() {
        return new RemoveAllProductsFromCartTask();
    }

    @Override
    @Step("{0} elimina todos los productos del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(InventoryPage.CART_LINK),
                WaitForElement.toBeVisible(CartPage.CART_ITEMS_LIST)
        );

        List<String> productNames = new ArrayList<>(CartProductsQuestion.displayed().answeredBy(actor));
        for (String productName : productNames) {
            actor.attemptsTo(
                    WaitForElement.toBeVisible(removeButtonFor(productName)),
                    ClickOn.the(removeButtonFor(productName))
            );
        }
    }

    private Target removeButtonFor(String productName) {
        return Target.the("boton para quitar " + productName)
                .locatedBy("#remove-" + Product.toSlug(productName));
    }
}