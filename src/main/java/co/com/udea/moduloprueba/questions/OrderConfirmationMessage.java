package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import co.com.udea.moduloprueba.userinterfaces.CheckoutCompletePage;

public class OrderConfirmationMessage implements net.serenitybdd.screenplay.Question<String> {

    private OrderConfirmationMessage() {
    }

    public static OrderConfirmationMessage displayed() {
        return new OrderConfirmationMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutCompletePage.CONFIRMATION_HEADER).answeredBy(actor);
    }
}