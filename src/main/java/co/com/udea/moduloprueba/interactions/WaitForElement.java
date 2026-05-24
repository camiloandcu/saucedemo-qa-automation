package co.com.udea.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WaitForElement implements Performable {

    private final Target target;

    private WaitForElement(Target target) {
        this.target = target;
    }

    public static WaitForElement toBeVisible(Target target) {
        return new WaitForElement(target);
    }

        @Step("{0} espera a que {target} sea visible")
    public <T extends Actor> void performAs(T actor) {
        agregarDelayParaSocializacion();
        actor.attemptsTo(WaitUntil.the(target, isVisible()));
    }

    private void agregarDelayParaSocializacion() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}