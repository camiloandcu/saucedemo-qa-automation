package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import co.com.udea.moduloprueba.userinterfaces.InventoryPage;

public class ProductsPageTitle implements net.serenitybdd.screenplay.Question<String> {

    private ProductsPageTitle() {
    }

    public static ProductsPageTitle displayed() {
        return new ProductsPageTitle();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(InventoryPage.PAGE_TITLE).answeredBy(actor);
    }
}