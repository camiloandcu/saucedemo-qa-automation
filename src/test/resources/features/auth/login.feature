      # language: es
      @auth
      Característica: Autenticación de usuario

      Antecedentes:
      Dado que el usuario está en la página de inicio de sesión

      @happy_path @smoke
      Escenario: Inicio de sesión exitoso con usuario estándar
      Cuando el usuario inicia sesión con nombre de usuario "standard_user" y contraseña "secret_sauce"
      Entonces el usuario debería ser redirigido a la página de productos
      Y el título de la página debería mostrar "Products"

      @exception @locked
      Escenario: Intento de inicio de sesión con usuario bloqueado
      Cuando el usuario inicia sesión con nombre de usuario "locked_out_user" y contraseña "secret_sauce"
      Entonces debería mostrarse un mensaje de error
      Y el mensaje de error debería contener "Sorry, this user has been locked out"

      @exception @invalid_credentials
      Esquema del escenario: Inicio de sesión con credenciales inválidas
      Cuando el usuario inicia sesión con nombre de usuario "<username>" y contraseña "<password>"
      Entonces debería mostrarse un mensaje de error
      Y el mensaje de error debería contener "Username and password do not match"

      Ejemplos:
      | username      | password       |
      | standard_user | wrong_password |
      | invalid_user  | secret_sauce   |
      | invalid_user  | wrong_password |

@exception @empty_fields
Escenario: Inicio de sesión con usuario vacío
Cuando el usuario inicia sesión con nombre de usuario "" y contraseña ""
Entonces debería mostrarse un mensaje de error
Y el mensaje de error debería contener "Username is required"

@exception @empty_password
Escenario: Inicio de sesión con usuario pero contraseña vacía
Cuando el usuario inicia sesión con nombre de usuario "standard_user" y contraseña ""
Entonces debería mostrarse un mensaje de error
Y el mensaje de error debería contener "Password is required"