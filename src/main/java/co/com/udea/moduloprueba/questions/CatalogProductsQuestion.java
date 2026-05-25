package co.com.udea.moduloprueba.questions;

import co.com.udea.moduloprueba.models.Product;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogProductsQuestion implements Question<List<Product>> {

    private CatalogProductsQuestion() {
    }

    public static CatalogProductsQuestion displayed() {
        return new CatalogProductsQuestion();
    }

    @Override
    public List<Product> answeredBy(Actor actor) {
        return InventoryPage.ALL_PRODUCT_ITEMS.resolveAllFor(actor).stream()
                .map(CatalogProductsQuestion::toProduct)
                .collect(Collectors.toList());
    }

    private static Product toProduct(WebElementFacade item) {
        String name = item.findBy(".inventory_item_name").getText();
        String priceText = item.findBy(".inventory_item_price").getText().replace("$", "");
        double price = Double.parseDouble(priceText);
        return Product.of(name, price);
    }
}