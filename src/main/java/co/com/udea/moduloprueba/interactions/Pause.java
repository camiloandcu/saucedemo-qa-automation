package co.com.udea.moduloprueba.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class Pause implements Performable {

    private final long milliseconds;

    private Pause(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public static Pause ofMillis(long milliseconds) {
        return new Pause(milliseconds);
    }

    @Step("{0} espera {milliseconds} milisegundos")
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("La pausa fue interrumpida", exception);
        }
    }
}