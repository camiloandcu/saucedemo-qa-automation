# Taller de automatización 

# Calidad de Software 2026-1

# Título: Automatización de pruebas

**Objetivo del talle**r: Desarrollar un conjunto de pruebas automatizadas para resolver un reto funcional específico, aplicando el patrón Screenplay con buenas prácticas de ingeniería de pruebas (abstracción, reusabilidad, validación clara).

Deben construir como mínimo Tasks, Interactions, Questions, StepDefinition, Runners y un flujo de pruebas modular y mantenible.

**2\. Modalidad**: Equipos. 

**3\. Resultado de aprendizaje:** El estudiante demostrará sus conocimientos en el diseño de escenarios para pruebas automatizadas generando la ruta feliz y posibles caminos excepcionales de la aplicación, mediante el lenguaje Gherkin

**4\. Recursos:** El estudiante cuenta con los materiales fundamentales, así como la información dada por el profesor en clase, conocimientos del patrón screenPlay, lenguaje Gherkin y configuraciones básicas en la máquina local.

**5**. **Rúbrica de evaluación**

| Criterio | Descripción | Puntos |
| :---- | :---- | :---- |
| Cobertura y profundidad funcional | Cobertura de casos clave del reto, manejo de errores, escenarios límite | 15 |
| **Reportes de la prueba automatizada** | Generación de los reportes en SerenityBDD | 10 |
| Calidad del código y buenas prácticas | Legibilidad, modularidad, documentación mínima, uso de PageObjects si aplica | 10 |
| Creatividad e innovación | Soluciones creativas, uso de herramientas adicionales, resolución original | 10 |
| **Socialización** | Claridad, tiempo, calidad de exposición, entendimiento del problema.  Uso del **Delay ó sleep** entre paso y paso para observar la prueba con detenimiento y verificar las acciones de la misma | 55 |

**6\. Indicaciones para la definición de la automatización de pruebas**

1. Definir el actor principal que ejecutará la prueba E2E  
2. Diseñar la batería de pruebas mediante escenarios en Gherkin  
3. **Definir las tareas en términos del negocio – Task. De acuerdo a unos criterios de aceptación construidos en Gherkin. (importante)**  
4. las interacciones que operarán el detalle de la tarea – Interaction \-  “Diseñar La menuda”  
5. Verificar los resultados esperados \-  Question  
6. **Generar el reporte de automatización (importante)**

**7\. De la siguiente lista, seleccionar al menos un sitio a automatizar**

| Id. | Sito a automatizar | De qué trata | Qué automatizar |
| :---- | :---- | :---- | :---- |
|  1 |  https://www.saucedemo.com/ |  Tienda online | Realizar una E2E completa loqueándose, seleccionando elementos al carrito de compras y eliminando productos. Comprobar la cantidad de productos en el carrito etc. |