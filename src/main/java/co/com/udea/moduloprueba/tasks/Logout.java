package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.Pause;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.userinterfaces.NavigationMenu;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Logout implements Performable {

    public Logout() {
    }

    public static Logout now() {
        return instrumented(Logout.class);
    }

    @Step("{0} cierra la sesion de SauceDemo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(NavigationMenu.BURGER_MENU_BUTTON),
                Pause.ofMillis(500),
                WaitForElement.toBeVisible(NavigationMenu.LOGOUT_LINK),
                Pause.ofMillis(500),
                ClickOn.the(NavigationMenu.LOGOUT_LINK),
                Pause.ofMillis(500));
    }
}