package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public class RemoveProductFromCartTask implements Task {

    private final String productName;

    public RemoveProductFromCartTask(String productName) {
        this.productName = productName;
    }

    public static RemoveProductFromCartTask called(String productName) {
        return new RemoveProductFromCartTask(productName);
    }

    @Override
    @Step("{0} elimina {productName} del carrito")
    public <T extends Actor> void performAs(T actor) {
        String normalized = productName.toLowerCase()
                .replace(" ", "-")
                .replace("'", "")
                .replace("é", "e");
        Target removeButton = Target.the("boton quitar " + productName)
                .locatedBy("#remove-" + normalized);
        
        // Navegar al carrito primero para asegurar que el boton Remove esta visible
        actor.attemptsTo(
                ClickOn.the(InventoryPage.CART_LINK),
                WaitForElement.toBeVisible(removeButton),
                ClickOn.the(removeButton)
        );
    }
}
