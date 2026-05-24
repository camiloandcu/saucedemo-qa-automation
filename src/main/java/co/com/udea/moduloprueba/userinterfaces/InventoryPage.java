package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    // Encabezado y contenedor principal
    public static final Target PAGE_TITLE = Target.the("titulo de la pagina de productos").locatedBy(".title");
    public static final Target PRODUCT_LIST_CONTAINER = Target.the("contenedor de productos")
            .locatedBy("#inventory_container");

    // Productos
    public static final Target ALL_PRODUCT_ITEMS = Target.the("todos los productos").locatedBy(".inventory_item");
    public static final Target PRODUCT_NAME = Target.the("nombre del producto").locatedBy(".inventory_item_name");
    public static final Target PRODUCT_PRICE = Target.the("precio del producto").locatedBy(".inventory_item_price");

    // Acciones de carrito
    public static final Target ADD_TO_CART_BUTTON = Target.the("boton generico para agregar al carrito")
            .locatedBy("[data-test^=\"add-to-cart\"]");
    public static final Target ADD_SAUCE_LABS_BACKPACK_BUTTON = Target.the("boton para agregar Sauce Labs Backpack")
            .locatedBy("#add-to-cart-sauce-labs-backpack");
    public static final Target ADD_SAUCE_LABS_BIKE_LIGHT_BUTTON = Target.the("boton para agregar Sauce Labs Bike Light")
            .locatedBy("#add-to-cart-sauce-labs-bike-light");
    public static final Target ADD_BOLT_TSHIRT_BUTTON = Target.the("boton para agregar Bolt T-Shirt")
            .locatedBy("#add-to-cart-sauce-labs-bolt-t-shirt");
    public static final Target REMOVE_BUTTON = Target.the("boton generico para quitar del carrito")
            .locatedBy("[data-test^=\"remove\"]");
    public static final Target REMOVE_SAUCE_LABS_BACKPACK_BUTTON = Target.the("boton para quitar Sauce Labs Backpack")
            .locatedBy("#remove-sauce-labs-backpack");

    // Barra superior
    public static final Target CART_ICON_BADGE = Target.the("insignia del carrito").locatedBy(".shopping_cart_badge");
    public static final Target CART_LINK = Target.the("enlace al carrito").locatedBy(".shopping_cart_link");
    public static final Target SORT_DROPDOWN = Target.the("selector de ordenamiento")
            .locatedBy(".product_sort_container");
    public static final Target BURGER_MENU_BUTTON = NavigationMenu.BURGER_MENU_BUTTON;
}