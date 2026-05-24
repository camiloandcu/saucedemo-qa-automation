package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletePage {

    // Confirmacion de compra
    public static final Target CONFIRMATION_HEADER = Target.the("encabezado de confirmacion")
            .locatedBy(".complete-header");
    public static final Target CONFIRMATION_TEXT = Target.the("texto de confirmacion").locatedBy(".complete-text");
    public static final Target BACK_HOME_BUTTON = Target.the("boton para volver al inicio")
            .locatedBy("#back-to-products");
}