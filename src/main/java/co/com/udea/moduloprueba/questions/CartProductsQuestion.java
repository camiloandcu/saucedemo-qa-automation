package co.com.udea.moduloprueba.questions;

import co.com.udea.moduloprueba.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class CartProductsQuestion implements Question<List<String>> {

    private CartProductsQuestion() {
    }

    public static CartProductsQuestion displayed() {
        return new CartProductsQuestion();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return CartPage.CART_ITEMS_LIST.resolveAllFor(actor).stream()
                .map(CartProductsQuestion::nameOf)
                .collect(Collectors.toList());
    }

    private static String nameOf(WebElementFacade item) {
        return item.findBy(".inventory_item_name").getText();
    }
}