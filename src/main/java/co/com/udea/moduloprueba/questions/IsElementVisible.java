package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class IsElementVisible implements net.serenitybdd.screenplay.Question<Boolean> {

    private final Target target;

    private IsElementVisible(Target target) {
        this.target = target;
    }

    public static IsElementVisible forTarget(Target target) {
        return new IsElementVisible(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.isVisibleFor(actor);
    }
}
