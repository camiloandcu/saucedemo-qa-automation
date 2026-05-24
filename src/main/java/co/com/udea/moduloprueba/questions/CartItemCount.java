package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;

import co.com.udea.moduloprueba.userinterfaces.CartPage;

public class CartItemCount implements net.serenitybdd.screenplay.Question<Integer> {

    private CartItemCount() {
    }

    public static CartItemCount counted() {
        return new CartItemCount();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return CartPage.CART_ITEMS_LIST.resolveAllFor(actor).size();
    }
}