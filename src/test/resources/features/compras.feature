# language: es
Característica: Compra en SauceDemo - E2E completa

  Como usuario de la tienda online SauceDemo
  Quiero realizar un flujo completo de compra
  Incluyendo escenarios de error y recuperacion

  Antecedentes:
    Dado que el usuario esta en la pagina de login

  @E2E
  Escenario: E2E completa - flujo integral con manejo de errores
    Cuando el usuario intenta iniciar sesion con "standard_user" y "wrong_password"
    Entonces el usuario deberia ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"
    Cuando el usuario inicia sesion con credenciales validas
    Y agrega los siguientes productos al carrito:
      | Sauce Labs Backpack |
      | Sauce Labs Bike Light |
    Y elimina "Sauce Labs Backpack" del carrito
    Entonces el contador del carrito deberia mostrar "1"
    Y procede al checkout
    Y intenta continuar sin completar los datos de envio
    Entonces el usuario deberia ver el mensaje de error "Error: First Name is required"
    Cuando completa la informacion de envio con "Juan", "Perez" y "050001"
    Y finaliza la compra
    Entonces el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"
    Y el usuario cierra la sesión
    Entonces debería volver a la página de inicio de sesión
