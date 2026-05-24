package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NavigationMenu {

    // Menu lateral
    public static final Target BURGER_MENU_BUTTON = Target.the("boton del menu lateral")
            .locatedBy("#react-burger-menu-btn");
    public static final Target ALL_ITEMS_LINK = Target.the("enlace de todos los productos")
            .locatedBy("#inventory_sidebar_link");
    public static final Target LOGOUT_LINK = Target.the("enlace para cerrar sesion").locatedBy("#logout_sidebar_link");
    public static final Target ABOUT_LINK = Target.the("enlace acerca de").locatedBy("#about_sidebar_link");
    public static final Target RESET_APP_STATE_LINK = Target.the("enlace para reiniciar el estado de la aplicacion")
            .locatedBy("#reset_sidebar_link");
}