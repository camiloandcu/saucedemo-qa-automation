package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;

import co.com.udea.moduloprueba.userinterfaces.InventoryPage;

public class IsCartBadgeVisible implements net.serenitybdd.screenplay.Question<Boolean> {

    private IsCartBadgeVisible() {
    }

    public static IsCartBadgeVisible visible() {
        return new IsCartBadgeVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return InventoryPage.CART_ICON_BADGE.isVisibleFor(actor);
    }
}