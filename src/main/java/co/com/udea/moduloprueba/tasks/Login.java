package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.EnterText;
import co.com.udea.moduloprueba.interactions.Pause;
import co.com.udea.moduloprueba.interactions.WaitForElement;
import co.com.udea.moduloprueba.userinterfaces.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Performable {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Login withCredentials(String username, String password) {
        return instrumented(Login.class, username, password);
    }

    @Step("{0} inicia sesión en SauceDemo con credenciales")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitForElement.toBeVisible(LoginPage.USERNAME_FIELD),
                EnterText.of(username).into(LoginPage.USERNAME_FIELD),
            Pause.ofMillis(Pause.STANDARD_DELAY_MS),
                WaitForElement.toBeVisible(LoginPage.PASSWORD_FIELD),
                EnterText.of(password).into(LoginPage.PASSWORD_FIELD),
            Pause.ofMillis(Pause.STANDARD_DELAY_MS),
                ClickOn.the(LoginPage.LOGIN_BUTTON));
    }
}