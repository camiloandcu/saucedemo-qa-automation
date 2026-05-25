# language: es
Característica: Compra en SauceDemo

Como usuario de SauceDemo
Quiero navegar, comprar y gestionar el carrito
Para vitrinear y comprar productos de manera eficiente

Antecedentes:
Dado que el usuario esta en la pagina de login

@auth @negative
Escenario: Usuario entra con credenciales invalidas y no puede iniciar sesion
Cuando el usuario inicia sesion con credenciales invalidas
Entonces el usuario deberia ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"

@auth @negative
Esquema del escenario: Usuario no validado intenta entrar directamente al inventario o al carrito
Cuando el usuario intenta ingresar directamente a "<ruta>"
Entonces el usuario deberia ver un mensaje de error 

Ejemplos:
| ruta           |
| inventory.html |
| cart.html      |

@checkout @happy_path
Escenario: Usuario entra con credenciales validas y compra un producto aleatorio
Cuando el usuario inicia sesion con credenciales validas
Y agrega un producto aleatorio al carrito
Y procede al checkout
Y completa la informacion de envio
Y finaliza la compra
Entonces el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"

@checkout @sort
Escenario: Usuario entra con credenciales validas y compra el producto mas barato
Cuando el usuario inicia sesion con credenciales validas
Y ordena el catalogo por precio de menor a mayor
Entonces el catalogo deberia estar ordenado de menor a mayor
Y agrega el producto mas barato al carrito
Y procede al checkout
Y completa la informacion de envio
Y finaliza la compra
Entonces el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"

@checkout @negative
Esquema del escenario: Usuario entra con credenciales validas pero no completa todos los datos de compra
Cuando el usuario inicia sesion con credenciales validas
Y agrega un producto aleatorio al carrito
Y procede al checkout
Y completa la informacion de envio con "<firstName>", "<lastName>" y "<postalCode>"
Y intenta continuar sin completar los datos de envio
Entonces el usuario deberia ver el mensaje de error "<expectedMessage>"

Ejemplos:
| firstName | lastName | postalCode | expectedMessage                |
|           | Perez    | 050001     | Error: First Name is required  |
| Juan      |          | 050001     | Error: Last Name is required   |
| Juan      | Perez    |            | Error: Postal Code is required |

@cart @checkout @positive
Escenario: Usuario agrega cosas al carrito, elimina una y aun asi compra
Cuando el usuario inicia sesion con credenciales validas
Y agrega un producto aleatorio al carrito
Y agrega un producto aleatorio al carrito
Y elimina un producto del carrito
Entonces el contador del carrito deberia mostrar "1"
Y procede al checkout
Y completa la informacion de envio
Y finaliza la compra
Entonces el usuario deberia ver el mensaje de confirmacion "Thank you for your order!"

@cart @negative
Escenario: Usuario agrega productos y los elimina todos antes de comprar
Cuando el usuario inicia sesion con credenciales validas
Y agrega un producto aleatorio al carrito
Y agrega un producto aleatorio al carrito
Y elimina todos los productos del carrito
Entonces el carrito deberia estar vacio
