# language: es
@auth @logout
Característica: Cierre de sesión en SauceDemo

Antecedentes:
Dado que el usuario está en la página de inicio de sesión

Escenario: Cierre de sesión exitoso
Cuando el usuario inicia sesión con nombre de usuario "standard_user" y contraseña "secret_sauce"
Y el usuario cierra la sesión
Entonces debería volver a la página de inicio de sesión