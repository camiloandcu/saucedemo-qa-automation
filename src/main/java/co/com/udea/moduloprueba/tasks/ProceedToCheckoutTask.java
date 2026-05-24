package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.userinterfaces.CartPage;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ProceedToCheckoutTask implements Task {

    public static ProceedToCheckoutTask fromCart() {
        return new ProceedToCheckoutTask();
    }

    @Override
    @Step("{0} procede al checkout")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(InventoryPage.CART_LINK),
                WaitForElement.toBeVisible(CartPage.CHECKOUT_BUTTON),
                ClickOn.the(CartPage.CHECKOUT_BUTTON)
        );
    }
}
