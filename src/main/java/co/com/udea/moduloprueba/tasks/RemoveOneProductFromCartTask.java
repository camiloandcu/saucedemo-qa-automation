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

import java.util.List;

public class RemoveOneProductFromCartTask implements Task {

    public static RemoveOneProductFromCartTask now() {
        return new RemoveOneProductFromCartTask();
    }

    @Override
    @Step("{0} elimina un producto del carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(InventoryPage.CART_LINK),
                WaitForElement.toBeVisible(CartPage.CART_ITEMS_LIST)
        );

        List<String> productNames = CartProductsQuestion.displayed().answeredBy(actor);
        if (productNames.isEmpty()) {
            throw new IllegalStateException("El carrito esta vacio y no se puede eliminar un producto");
        }

        String productName = productNames.get(0);
        actor.attemptsTo(ClickOn.the(removeButtonFor(productName)));
    }

    private Target removeButtonFor(String productName) {
        return Target.the("boton para quitar " + productName)
                .locatedBy("#remove-" + Product.toSlug(productName));
    }
}