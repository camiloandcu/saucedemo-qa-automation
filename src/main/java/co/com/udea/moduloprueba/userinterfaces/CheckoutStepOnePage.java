package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutStepOnePage {

    // Datos del comprador
    public static final Target FIRST_NAME_FIELD = Target.the("campo de nombre").locatedBy("#first-name");
    public static final Target LAST_NAME_FIELD = Target.the("campo de apellido").locatedBy("#last-name");
    public static final Target POSTAL_CODE_FIELD = Target.the("campo de codigo postal").locatedBy("#postal-code");

    // Acciones
    public static final Target CONTINUE_BUTTON = Target.the("boton para continuar").locatedBy("#continue");
    public static final Target CANCEL_BUTTON = Target.the("boton para cancelar").locatedBy("#cancel");

    // Error
    public static final Target ERROR_MESSAGE = LoginPage.ERROR_MESSAGE_BOX;
}