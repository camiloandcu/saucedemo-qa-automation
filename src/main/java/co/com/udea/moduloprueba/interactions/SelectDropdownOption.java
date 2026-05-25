package co.com.udea.moduloprueba.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownOption implements Performable {

    private final String value;
    private Target target;

    private SelectDropdownOption(String value) {
        this.value = value;
    }

    public static SelectDropdownOption byValue(String value) {
        return new SelectDropdownOption(value);
    }

    public SelectDropdownOption from(Target target) {
        this.target = target;
        return this;
    }

    @Step("{0} selecciona la opcion {value} en {target}")
    public <T extends Actor> void performAs(T actor) {
        Select select = new Select(target.resolveFor(actor));
        select.selectByValue(value);
    }
}