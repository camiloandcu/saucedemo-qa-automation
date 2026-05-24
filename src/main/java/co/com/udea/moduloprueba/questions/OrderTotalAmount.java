package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import co.com.udea.moduloprueba.userinterfaces.CheckoutStepTwoPage;

public class OrderTotalAmount implements net.serenitybdd.screenplay.Question<Double> {

    private OrderTotalAmount() {
    }

    public static OrderTotalAmount displayed() {
        return new OrderTotalAmount();
    }

    @Override
    public Double answeredBy(Actor actor) {
        String totalText = Text.of(CheckoutStepTwoPage.TOTAL_LABEL).answeredBy(actor);
        String numericValue = totalText.replaceAll("[^0-9,.-]", "").replace(",", ".");
        return Double.parseDouble(numericValue);
    }
}