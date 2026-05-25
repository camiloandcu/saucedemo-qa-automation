package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.SelectDropdownOption;
import co.com.udea.moduloprueba.userinterfaces.InventoryPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SortCatalogByPriceTask implements Task {

    public static SortCatalogByPriceTask lowToHigh() {
        return new SortCatalogByPriceTask();
    }

    @Override
    @Step("{0} ordena el catalogo por precio de menor a mayor")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectDropdownOption.byValue("lohi").from(InventoryPage.SORT_DROPDOWN));
    }
}