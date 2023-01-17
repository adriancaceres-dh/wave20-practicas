# Sprint 2 - wave20 - Tests SocialMeli (PARTE UNITARIA Y BONUS)
SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.
​
## Objetivo
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.
​
## Parte individual realizada por:
- John Edward Garcia Saavedra **github: EdwardGs1702**
​
## Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado a partir del proyecto grupal final del primer sprint: **SocialMeli**.
Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.
​
## Consideraciones generales
- Solamente se permiten caracteres alfanuméricos en los campos de texto del payload, además de espacios en cada uno.
- El test **T-0008** se realizó sobre el repositorio, no sobre el servicio, debido a que el filtro de las últimas dos semanas se hace directamente en el repo.
- Se agregó la anotación **@Validated** en los controladores para poder validar los **@PathVariable**.
- No se incluyó la validación del campo **id_post**, ya que el mismo no se require como parámetro en ningún endpoint. (Este tema lo comentamos con Adrian Caceres).
​
## Refactorización
- Se realizó un cambio en el factor de comparación del método **findPostById** en **PostRepositoryImpl**.
  - Ahora se hace una comparación en base a **ChronoUnit.DAYS** y no a **ChronoUnit.WEEKS**.
- Se eliminaron los IF para validar que todos los campos estuvieran presentes en el payload. Se reemplazó esa función mediante las validaciones de cada campo en los DTO.
- Se modificó el constructor de **PostRepositoryImpl** para quitar un argumento innecesario.
- Se renombraron algunas variables.
- Se agregó documentación de **Javadoc** a los métodos de los servicios.
​
## Colección de Postman
- Además de los endpoints normales, se agregaron 4 endpoints con campos inválidos para probar las validaciones de los mismos, según lo acordado con Adrian Caceres:
  - US-0001 - Negative PathVariable
  - US-0005 - Missing Product Validation
  - US-0005 - Special Character Validation
  - US-0005 - Missing Date Validation
​
## Consideraciones individuales
​
- Para la segunda parte (apartado individual) opté por realizar los test de los metodos del controlador: PostController, los escenarios tomados en cuenta fueron.

  PostController:

  - TI-Find all posts by id user.
  - TI-Find all posts by id user invalid.
  - TI-count post promo by id user.
  - TI-count post promo by id user invalid.
  - TI-Find all products promo by id user.
  - TI-Find all products promo by id user invalid.
  - TI-Create new post.
  - TI-Create new post promo.


​
- Para la tercera parte (Bonus) con el fin de lograr el coverage esperado (Mayor al 75%) opté por realizar test de integración sobre las clase "SellerController" y "UserController"
con ruta: /users/ para los UsersController y para los SellerController no se definio prefijo. Lo cual al abarcar todas las capas y un número amplio de métodos permitió conseguir el objetivo en un 86% de lineas cubiertas. Los escenarios tomados en cuenta fueron:
​
  UserController:

  - TI-Find followed by id user.
  - TI-Find followed by id user invalid.
  - TI-Find followed by id user is cero.
  - TI-New follow.
  - TI-New follow user id cero.
  - TI-New follow user id to follow cero.
  - TI-Unfollow follow.
  - TI-Unfollow user id cero.
  - TI-Unfollow user id to follow cero.

  SellerController:

  - TI-Count followers by id user
  - TI-Count followers by id user invalid.
  - TI-Find seller followers by id user.
  - TI-Find seller followers by id user invalid.


- Por ultimo se realizo un nuevo endpoint de manera individual para crear post con promociones. Este endpoint no utiliza un metodo aparte de crear post, simplemente se reutiliza el endpoint que ya existe para crear los post y se hace una validacion
  Sobre si los campos hash_promo y discount vienen con algun valor, se ingresa el post con promo, de lo contrario se ingresa el post sin promo.

  Endpoint: /promo-post

  Se modifico el DTO de PostDTO para que no admitiera valores por defecto en los atributos de la clase, con el fin de que cuando se ingrese un post sin promocion no setee los valores por defecto de los campos hash_promo y discount
  Esto se logro mediante la anotacion a nivel de clase: @JsonInclude(JsonInclude.Include.NON_DEFAULT)

- Se agrego un endpoint para contar los productos en promocion que tenia determinado usuario.

  Endpoint: /promo-post/count

- Se agrego un endpoint para listar todos los productos en promocion que tenia determinado usuario.

  Endpoint: /promo-post/list