package co.com.udea.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

public class ClickOn implements Performable {

    private final Target target;

    private ClickOn(Target target) {
        this.target = target;
    }

    public static ClickOn the(Target target) {
        return new ClickOn(target);
    }

    @Step("{0} hace clic en {target}")
    public <T extends Actor> void performAs(T actor) {
        agregarDelayParaSocializacion();
        actor.attemptsTo(Click.on(target));
    }

    private void agregarDelayParaSocializacion() {
        try {
            Thread.sleep(Pause.STANDARD_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}