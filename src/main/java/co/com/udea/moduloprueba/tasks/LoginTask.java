package co.com.udea.moduloprueba.tasks;

import co.com.udea.moduloprueba.interactions.ClickOn;
import co.com.udea.moduloprueba.interactions.EnterText;
import co.com.udea.moduloprueba.userinterfaces.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTask withCredentials(String username, String password) {
        return new LoginTask(username, password);
    }

    @Override
    @Step("{0} inicia sesion con credenciales validas")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterText.of(username).into(LoginPage.USERNAME_FIELD),
                EnterText.of(password).into(LoginPage.PASSWORD_FIELD),
                ClickOn.the(LoginPage.LOGIN_BUTTON)
        );
    }
}
