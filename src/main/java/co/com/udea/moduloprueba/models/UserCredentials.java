package co.com.udea.moduloprueba.models;

/**
 * Credenciales publicas de prueba para SauceDemo.
 *
 * <p>
 * Comportamiento de cada usuario:
 * </p>
 * <ul>
 * <li>STANDARD_USER: acceso completo al flujo principal.</li>
 * <li>LOCKED_OUT_USER: muestra error de cuenta bloqueada.</li>
 * <li>PROBLEM_USER: presenta fallas visuales e imagenes rotas.</li>
 * <li>PERFORMANCE_GLITCH_USER: carga lenta para pruebas de rendimiento.</li>
 * <li>ERROR_USER: genera errores aleatorios en interacciones.</li>
 * <li>VISUAL_USER: aplica diferencias visuales de la interfaz.</li>
 * </ul>
 */
public final class UserCredentials {

    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_OUT_USER = "locked_out_user";
    public static final String PROBLEM_USER = "problem_user";
    public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
    public static final String ERROR_USER = "error_user";
    public static final String VISUAL_USER = "visual_user";
    public static final String PASSWORD = "secret_sauce";

    private UserCredentials() {
    }
}