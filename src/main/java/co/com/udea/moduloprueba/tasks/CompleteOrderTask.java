package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.userinterfaces.CheckoutStepTwoPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class CompleteOrderTask implements Task {

    public static CompleteOrderTask now() {
        return new CompleteOrderTask();
    }

    @Override
    @Step("{0} finaliza la compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.the(CheckoutStepTwoPage.FINISH_BUTTON)
        );
    }
}
