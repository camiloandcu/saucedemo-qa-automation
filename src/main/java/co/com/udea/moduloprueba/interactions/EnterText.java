package co.com.udea.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

public class EnterText implements Performable {

    private final String value;
    private Target target;

    private EnterText(String value) {
        this.value = value;
    }

    public static EnterText of(String value) {
        return new EnterText(value);
    }

    public EnterText into(Target target) {
        this.target = target;
        return this;
    }

    @Step("{0} escribe '{value}' en {target}")
    public <T extends Actor> void performAs(T actor) {
        agregarDelayParaSocializacion();
        actor.attemptsTo(Enter.theValue(value).into(target));
    }

    private void agregarDelayParaSocializacion() {
        try {
            Thread.sleep(Pause.STANDARD_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}