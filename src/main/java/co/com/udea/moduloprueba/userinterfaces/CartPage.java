package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    // Lista del carrito
    public static final Target CART_ITEMS_LIST = Target.the("lista de productos del carrito").locatedBy(".cart_item");
    public static final Target ITEM_NAME = Target.the("nombre del producto en el carrito")
            .locatedBy(".inventory_item_name");
    public static final Target ITEM_QUANTITY = Target.the("cantidad del producto en el carrito")
            .locatedBy(".cart_quantity");
    public static final Target REMOVE_BUTTON = InventoryPage.REMOVE_BUTTON;

    // Acciones del carrito
    public static final Target CONTINUE_SHOPPING_BUTTON = Target.the("boton para continuar comprando")
            .locatedBy("#continue-shopping");
    public static final Target CHECKOUT_BUTTON = Target.the("boton para iniciar el checkout").locatedBy("#checkout");
}