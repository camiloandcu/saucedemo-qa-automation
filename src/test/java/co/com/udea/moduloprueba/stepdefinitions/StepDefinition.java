package co.com.udea.moduloprueba.stepdefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public abstract class StepDefinition {

    protected Actor Buyer() {
        return OnStage.theActorInTheSpotlight();
    }
}