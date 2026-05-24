package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;

import co.com.udea.moduloprueba.userinterfaces.CartPage;

public class IsProductInCart implements net.serenitybdd.screenplay.Question<Boolean> {

    private final String productName;

    private IsProductInCart(String productName) {
        this.productName = productName;
    }

    public static IsProductInCart of(String productName) {
        return new IsProductInCart(productName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        for (var item : CartPage.ITEM_NAME.resolveAllFor(actor)) {
            if (productName.equals(item.getText())) {
                return true;
            }
        }
        return false;
    }
}