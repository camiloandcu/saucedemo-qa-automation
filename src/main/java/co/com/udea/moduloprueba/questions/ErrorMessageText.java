package co.com.udea.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;

import co.com.udea.moduloprueba.userinterfaces.LoginPage;

public class ErrorMessageText implements net.serenitybdd.screenplay.Question<String> {

    private ErrorMessageText() {
    }

    public static ErrorMessageText displayed() {
        return new ErrorMessageText();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LoginPage.ERROR_MESSAGE_BOX).answeredBy(actor);
    }
}