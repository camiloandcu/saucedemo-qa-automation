package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.EnterText;
import co.com.udea.moduloprueba.userinterfaces.CheckoutStepOnePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class FillCheckoutInfoTask implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutInfoTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static FillCheckoutInfoTask withData(String firstName, String lastName, String postalCode) {
        return new FillCheckoutInfoTask(firstName, lastName, postalCode);
    }

    @Override
    @Step("{0} completa la informacion de envio")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterText.of(firstName).into(CheckoutStepOnePage.FIRST_NAME_FIELD),
                EnterText.of(lastName).into(CheckoutStepOnePage.LAST_NAME_FIELD),
                EnterText.of(postalCode).into(CheckoutStepOnePage.POSTAL_CODE_FIELD),
                ClickOn.the(CheckoutStepOnePage.CONTINUE_BUTTON)
        );
    }
}
