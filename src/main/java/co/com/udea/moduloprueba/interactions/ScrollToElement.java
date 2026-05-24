package co.com.udea.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

public class ScrollToElement implements Performable {

    private final Target target;

    private ScrollToElement(Target target) {
        this.target = target;
    }

    public static ScrollToElement to(Target target) {
        return new ScrollToElement(target);
    }

        @Step("{0} desplaza la vista hasta {target}")
    public <T extends Actor> void performAs(T actor) {
        agregarDelayParaSocializacion();
        actor.attemptsTo(Scroll.to(target));
    }

    private void agregarDelayParaSocializacion() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}