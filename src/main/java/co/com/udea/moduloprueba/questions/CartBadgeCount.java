package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import co.com.udea.moduloprueba.userinterfaces.InventoryPage;

public class CartBadgeCount implements net.serenitybdd.screenplay.Question<String> {

    private CartBadgeCount() {
    }

    public static CartBadgeCount displayed() {
        return new CartBadgeCount();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(InventoryPage.CART_ICON_BADGE).answeredBy(actor);
    }
}
