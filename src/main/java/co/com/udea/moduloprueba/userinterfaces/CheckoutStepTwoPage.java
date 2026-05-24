package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutStepTwoPage {

    // Resumen de la orden
    public static final Target ITEM_TOTAL_LABEL = Target.the("etiqueta del subtotal")
            .locatedBy(".summary_subtotal_label");
    public static final Target TAX_LABEL = Target.the("etiqueta del impuesto").locatedBy(".summary_tax_label");
    public static final Target TOTAL_LABEL = Target.the("etiqueta del total").locatedBy(".summary_total_label");

    // Acciones
    public static final Target FINISH_BUTTON = Target.the("boton para finalizar").locatedBy("#finish");
    public static final Target CANCEL_BUTTON = CheckoutStepOnePage.CANCEL_BUTTON;
}