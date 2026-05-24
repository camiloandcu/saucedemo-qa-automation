package co.com.udea.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    // Formulario de acceso
    public static final Target USERNAME_FIELD = Target.the("campo de nombre de usuario").locatedBy("#user-name");
    public static final Target PASSWORD_FIELD = Target.the("campo de contrasena").locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("boton de iniciar sesion").locatedBy("#login-button");

    // Mensajes de error
    public static final Target ERROR_MESSAGE_BOX = Target.the("mensaje de error").locatedBy("[data-test=\"error\"]");
    public static final Target ERROR_CLOSE_BUTTON = Target.the("boton para cerrar el error").locatedBy(".error-button");
}