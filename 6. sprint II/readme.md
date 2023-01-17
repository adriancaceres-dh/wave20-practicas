# Sprint 2 - wave20 - Tests SocialMeli (PARTE UNITARIA Y BONUS)
SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## Objetivo
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

## Parte individual realizada por:
- Diego Alejandro Malagon Ruiz **github: DiegoAlejandroMalagon**

## Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado a partir del proyecto grupal final del primer sprint: **SocialMeli**.
Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.

## Consideraciones generales
- Solamente se permiten caracteres alfanuméricos en los campos de texto del payload, además de espacios en cada uno.
- El test **T-0008** se realizó sobre el repositorio, no sobre el servicio, debido a que el filtro de las últimas dos semanas se hace directamente en el repo.
- Se agregó la anotación **@Validated** en los controladores para poder validar los **@PathVariable**.
- No se incluyó la validación del campo **id_post**, ya que el mismo no se require como parámetro en ningún endpoint. (Este tema lo comentamos con Adrian Caceres).

## Refactorización
- Se realizó un cambio en el factor de comparación del método **findPostById** en **PostRepositoryImpl**.
  - Ahora se hace una comparación en base a **ChronoUnit.DAYS** y no a **ChronoUnit.WEEKS**.
- Se eliminaron los IF para validar que todos los campos estuvieran presentes en el payload. Se reemplazó esa función mediante las validaciones de cada campo en los DTO.
- Se modificó el constructor de **PostRepositoryImpl** para quitar un argumento innecesario.
- Se renombraron algunas variables.
- Se agregó documentación de **Javadoc** a los métodos de los servicios.

## Colección de Postman
- Además de los endpoints normales, se agregaron 4 endpoints con campos inválidos para probar las validaciones de los mismos, según lo acordado con Adrian Caceres:
  - US-0001 - Negative PathVariable
  - US-0005 - Missing Product Validation
  - US-0005 - Special Character Validation
  - US-0005 - Missing Date Validation

## Consideraciones individuales

- Para la segunda parte (apartado individual) opté por realizar el test de integración sobre el endpoint que consumía el servicio que testee de manera unitaria, denominado "newFollow"
en la clase "UserController" con ruta: /users/users/{userId}/follow/{userIdToFollow}. Los escenarios tomados en cuenta fueron:

  - Caso feliz.
  - Usuario seguidor no existente.
  - Vendedor a seguir no existente.
  - testeo de la validación que impide ingresar ids negativos.


- Para la tercera parte (Bonus) con el fin de lograr el coverage esperado (Mayor al 75%) opté por realizar test de integración sobre el endpoint denominado "postPost" en la clase "PostController"
con ruta: /products/post, el cual al abarcar todas las capas y un número amplio de métodos permitió conseguir el objetivo. Los escenarios tomados en cuenta fueron:

 - Caso feliz.
 - Vendedor que postea la publicación no existe.
 - Testeo de la validación que impide crear un post sin producto (ProductDTO nulo)