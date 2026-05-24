# language: es
Característica: Compra en SauceDemo

  Como usuario de la tienda online SauceDemo
  Quiero realizar compras, gestionar mi carrito
  Y validar mensajes de error ante acciones invalidas

  Antecedentes:
    Dado que el usuario esta en la pagina de login

  @HappyPath
  Escenario: Compra exitosa de multiples productos
    Cuando el usuario inicia sesion con credenciales validas
    Y agrega los siguientes productos al carrito:
      | Sauce Labs Backpack |
      | Sauce Labs Bike Light |
    Y procede al checkout
    Y completa la informacion de envio con "Juan", "Perez" y "050001"
    Y finaliza la compra
    Entonces el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"

  @AlternativePath
  Escenario: Eliminar un producto del carrito y verificar el contador
    Cuando el usuario inicia sesion con credenciales validas
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y agrega el producto "Sauce Labs Bike Light" al carrito
    Y elimina "Sauce Labs Backpack" del carrito
    Entonces el contador del carrito deberia mostrar "1"

  @ExceptionalPath
  Escenario: Login fallido con usuario bloqueado
    Cuando el usuario intenta iniciar sesion con "locked_out_user" y "secret_sauce"
    Entonces el usuario deberia ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."

  @ExceptionalPath
  Escenario: Checkout con campos obligatorios vacios
    Cuando el usuario inicia sesion con credenciales validas
    Y agrega el producto "Sauce Labs Backpack" al carrito
    Y procede al checkout
    Y intenta continuar sin completar los datos de envio
    Entonces el usuario deberia ver el mensaje de error "Error: First Name is required"
