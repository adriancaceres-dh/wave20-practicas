# ❗️📜 Bootcamp backend Java Sprint N°1 - Spring ❗️📜
______
## 🔍🧮 Índice 🧮🔍
1. _**[Objetivo](#-objetivo-)**_
2. _**[Putas para la actividad](#-pautas-para-la-actividad-)**_
3. _**[Escenario y requerimientos iniciales - Desarrollo grupal](#-escenario-y-requerimientos-iniciales---desarrollo-grupal---)**_
4. _**[Requerimientos incrementales - Desarrollo Individual -](#-requerimientos-incrementales---desarrollo-individual---)**_
5. _**[Bonus - Desarrollo Individual EXTRA -](#-bonus---desarrollo-individual-extra---)**_
6. _**[Bitácora](#-bitácora-)**_
   1. _**[Desarrollo Multicapa](#-desarrollo-multicapa-)**_
   2. _**[Repository](#-repository-)**_
   3. _**[Model](#-model-)**_
   4. _**[DTO](#-dto-)**_
   5. _**[Service](#-service-)**_
   6. _**[Controller](#-controller-)**_
   7. _**[Exception y config](#-exception-y-config-)**_
   8. _**[Utils y Utils/Mapper](#-utils-y--utilsmapper-)**_
7. _**[Endpoints](#-endpoints-)**_
8. _**[Miembros del Equipo N°2](#-miembros-del-equipo-n2-)**_
9. _**[Tecnologías utilizadas](#-tecnologías-utilizadas-)**_

## 📌 Objetivo 📌
El objetivo de este sprint es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), 
con la finalidad de poder implementar una API REST a partir de un enunciado propuesto, una especificación de requisitos y 
documentación anexada.

## 🛠 Pautas para la actividad 🛠
A. **Desarrollar una API para un escenario determinado de manera grupal**. En el punto A de la siguiente sección se 
encuentra una descripción detallada del escenario y cada uno de los requerimientos solicitados. La idea es que puedan trabajar 
en equipo, haciendo la correspondiente división de tareas para lograr la resolución en conjunto del escenario correspondiente.

B. **Apartado Individual**. Luego de lograr un proyecto BASE con todos los miembros del equipo, encontrarás dos requerimientos 
individuales obligatorios. Los mismos son incrementales al desarrollo que hayas logrado con tu equipo de trabajo

C. **Bonus**. En caso de que hayas logrado resolver tanto el apartado A de manera grupal como todo el apartado B de forma individual 
y aún cuentes con tiempo, te invitamos a que propongas tus propias mejoras o requerimientos que creas necesarios y que los 
implementes como extra. Para ello tendrás un requerimiento de referencia para que sepas a qué tipo de mejoras podés apuntar.

## 🫂 Escenario y requerimientos iniciales - Desarrollo grupal - 🫂
Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas 
que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido
como **“SocialMeli”**, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades 
que los mismos posteen.
Para poder realizar esto, un analista funcional relevó una serie de requerimientos que deben llevarse a cabo; sin embargo, 
como cuentan con una determinada complejidad y los tiempos son escasos, deberán ser ejecutados en **equipos de trabajo**. Los 
mismos se detallan a continuación:

Para esta parte se plantea la creación de una API Rest que permita:
1. Poder realizar la acción de “Follow” (seguir) a un determinado usuario.
2. Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
3. Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).
4. Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).
5. Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
6. Dar de alta una nueva públicación.
7. Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue 
(para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

Por otra parte, dado que se pretende una buena experiencia de usuario con respecto a la forma de presentación de los resultados 
de cada consulta, se necesita que los mismos puedan ser ordenados mediante cualquiera de los siguientes criterios:
8. Alfabético Ascendente y Descendente.
9. Fecha Ascendente y Descendente.

Un analista funcional llevó a cabo el **relevamiento de los requerimientos técnicos funcionales** y ha proporcionado la documentación 
que se cita a continuación para tener en cuenta a la hora de llevar a cabo el desarrollo correspondiente:

**[Especificación técnica funcional](https://docs.google.com/document/d/1L9zmNgsB_YZoB6V5LpPyciwCXD2ir6-X/edit)**

## 👤 Requerimientos incrementales - Desarrollo Individual - 👤
**SocialMeli** tiene como objetivo extra lograr permitir a los vendedores la posibilidad de publicar nuevos productos con ofertas 
o descuentos especiales exclusivos para sus seguidores por un determinado período de tiempo. Para ello propone los siguientes 
requerimientos:
10. Llevar a cabo la publicación de un nuevo producto en promoción.
11. Obtener la cantidad de productos en promoción de un determinado vendedor.

Estos requerimientos están pensados para ser llevados a cabo de manera individual por un especialista.
Tener en cuenta que, como son requerimientos incrementales al trabajo que se haya hecho en equipo, se debe respetar el desarrollo 
base que se haya logrado en éste.
Por otro lado, tener en cuenta para estos requerimientos la posibilidad de poder ordenarlos alfabéticamente por nombre de cada 
producto tanto de forma ascendente como descendente.

## 🧨 Bonus - Desarrollo Individual EXTRA - 🧨
Para finalizar, desde Mercado Libre dieron a conocer que están abiertos a cualquier nueva funcionalidad o propuesta de mejora 
para **“SocialMeli”**. En caso de que esto se lleve a cabo, será necesario, además de desarrollar la funcionalidad, **presentar 
la documentación técnica asociada**.

# 🗄 _Bitácora_ 🗄
______________
En la siguiente sección desarrollaremos las elecciones por parte de nuestro equipo en el por qué de las elecciones para una mejor
performance de código, asimilación de lógica de negocio, entre otras.

## 📚 Desarrollo Multicapa 📚
Se realiza un desarrollo multicapa para el proyecto realizado en Spring, donde cada capa posee una determinada función o 
tarea. Esta división consta de 5 capas:
- Repository
- Model
- DTO
- Service
- Controller
- Exception
- Config

### 🗂 Repository 🗂
Se desarrollan las clases _CategoryRepository_, _PostRepository_, _ProductRepository_, _UserRepository_. Cada una de estas realiza 
la simulación de nuestra Base de Datos. De momento solamente tendremos datos hardcodeados porque no poseemos datos reales por parte
del usuario. Cada una de estas posee una interfaz para, de esta manera, si en un futuro se ejecutan cambios dentro de dichas
clases, el resto del código no tenga que ser modificado según cambios de implementación en los Repository.

1. Todas las interfaces de Repository extienden de la interfaz GenericRepository. La cual es una interfaz muy similar a la de repositorios de 
Spring el cual tiene el comportamiento básico que todos los Repository deberían tener.
2. Cómo no poseemos una base de datos para poder guardar los datos de nuestro modelo, se optó por la implementación de
una colección Map, específicamente un HashMap donde la key será el Wrapper Integer para identificar los obetos y como clave
el objeto. Esto ayuda en tiempo de búsqueda, eliminación y agregación, por ejemplo, lo que puede ser un usuario o producto, el tiempo de ejecución
es O(1).
3. Destaquemos que los objetos Category ya deben estar cargadas en nuestro código, al igual que los usuarios. Esto es así, porque
los requerimientos no especifican la creación de usuarios o categorías por parte del usuario.

### ⛏ Model ⛏
Capa donde se desarrolla el modelo de negocio, el mismo refleja la puesta a punto del equipo según la lectura de los requerimientos proporcionados
por el Scrum Master. Dejaremos el acceso al archivo de Lucidchart para poder ver la representación de cada clase especificada por el equipo.
En esta capa se destacan las clases:
- Category
- Post
- Product
- User

La **clase User** poseerá colecciones de Listas para poder almacenar los _seguidores que posee un usuario_, los _usuarios que
sigue_ y una _lista de publicaciones_ (Post) que ha publicado. Para el equipo de trabajo, se tomó la resolución de no diferenciar, en
tema de clases, a un seguidor y seguidores, sino que ambos serán representados por el mismo modelo. De esta manera, cualquier
usuario puede postear, seguir y ser seguido por otros usuarios de la aplicación.

La **clase Category** fue implementada para poder representar las diferentes categoria de los productos. Esto podemos verlo
en las especificaciones técnicas por parte del Scrum Master en el US0005 donde la categoria es un identificador para conocer la categoría
que pertenece cada producto. Por ejemplo, 100:Sillas, 58:Teclados...

### 🛡 DTO 🛡
Serán las clases desarrolladas para la transferencia de datos y de esta manera desacoplar la representación de datos de 
los verdaderos objetos del modelo. Recordemos que en estas clases se evita las operaciones de negocios o métodos que realicen cálculos
sobre datos. Solo poseerán métodos GET y SET.
Destacamos la implementación de una clase _ProductDTO_, y dos package _Request_ y _Response_ para poder separar las 
implementaciones de respuestas y consultas, para y por, del usuario.

### 🏪 Service 🏪
Clases que contiene la lógica de negocio de la aplicación. Los service también poseen sus interfaces para separar los cambios
en sus métodos al resto de la aplicación.
Tenemos dos servicios principales:
- _PostService_
- _UserService_

### 🛃 Controller 🛃
Son las clases encargadas de atender las solicitudes por parte del usuario, desde el momento en que es interceptada hasta la generación
respuestas y su transmisión. Estas clases llaman a una o más función de la capa de servicio. También gestiona la deserialización de una 
solicitud y la serialización de la respuesta, a través de la capa, anteriormente mencionada, DTO.
Destacamos las clases:
- PostController
- UserController

### 🆘 Exception y Config 🆘
Estas capas son creadas para el manejo de excepciones de nuestro código. Como programadores nos aseguramos de no enviar excepciones
o pilas de errores a los clientes (por temas de seguridad de la empresa y por simplicidad al cliente para recuperarse de errores).
Los mensajes de excepción y error enviados serán breves y significativos.
- BadRequestException
- PostCreationException
- UserNotFoundException

### 🧰 Utils y  Utils/Mapper 🧰

Se crea, por decisión del equipo, el package _Utils_ y dentro de él se encuentra la clase _LoadExampleData_, un package
que posee las clases _PostMapper_ y _ProductMapper_.
- _LoadExampleData_: Es la encargada, a través de una anotación @EventListener, detectar de eventos de la aplicación. En este método
se inicializan algunos usuarios, categorías, productos y posts en nuestras "base de datos" dentro de los Repository.
- _PostMapper_: Posee la responsabilidad, a través de funciones, de transformar objetos de nuestro modelo en DTO o viceversa.
- _ProductMapper_: Posee la responsabilidad, a través de funciones, de transformar objetos de nuestro modelo en DTO o viceversa.


# 📌 _Endpoints_ 📌
____
#### US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor 

_**Sign:**_

|     Method     | SIGN                                        |
|:--------------:|---------------------------------------------|
|    **POST**    | /users/{userId}/follow/{userIdToFollow}     |
|                | Ejemplo: /users/123/follow/234              |
|  **Response**  | Status Code 200 (todo OK) - bodyless or dto |
 |                | Status Code 400 (Bad Request) -  bodyless or dto |

_**Filtros/Parámetros:**_

| Parámetros     |                       Tipo                       | Descripción/Ejemplo                         |
|----------------|:------------------------------------------------:|---------------------------------------------|
| **userId**         |                       int                        | Número que identifica al usuario actual     |
| **userIdToFollow** |                       int                        | Número que identifica al usuario a seguir   | 


Fue desarrollado por: _[Diego Fernando Alderete](https://github.com/DiegoFernandoAlderete) y [Flavio Ambroggio](https://github.com/flavio-ambroggio-meli)_

-------
#### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

_**Sign:**_

|     Method     | SIGN                                                                                              |
|:--------------:|---------------------------------------------------------------------------------------------------|
|    **GET**     | /users/{userId}/followers/count                                                                   |
|                | Ejemplo: /users/234/followers/count/                                                              |
|  **Response**  | <pre>{<br/>  "user_id": 234, <br/>  "user_name": "vendedor1", <br/>  "followers_count": 35 <br/>} |


_**Filtros/Parámetros:**_

| Parámetros |                       Tipo                       | Descripción/Ejemplo                |
|------------|:------------------------------------------------:|------------------------------------|
| **userId** |                       int                        | Número que identifica al usuario   | 

Fue desarrollado por: _[Diego Fernando Alderete](https://github.com/DiegoFernandoAlderete) y [Flavio Ambroggio](https://github.com/flavio-ambroggio-meli)_

-------
#### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

_**Sign:**_

|     Method     | SIGN                                                                                                                                                                                                                                                                                                                       |
|:--------------:|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|    **GET**     | /users/{userId}/followers/list                                                                                                                                                                                                                                                                                             |
|                | Ejemplo: /users/234/followers/list                                                                                                                                                                                                                                                                                         |
|  **Response**  | <pre>{<br/>  "user_id": 234,<br/>  "user_name": "vendedor1",<br/>  "followers":[<br/>  {<br/>    "user_id": 4698,<br/>    "user_name": "usuario1"<br/>  },<br/>  {<br/>    "user_id": 1536,<br/>    "user_name": "usuario2"<br/>  },<br/>  {<br/>    "user_id": 2236,<br/>    "user_name": "usuario3"<br/>  }<br/> ]<br/>} |


_**Filtros/Parámetros:**_

| Parámetros |                       Tipo                       | Descripción/Ejemplo                  |
|------------|:------------------------------------------------:|--------------------------------------|
| **userId** |                       int                        | Número que identifica a cada usuario | 

Fue desarrollado por: _[Francisco Liz Mardones](https://github.com/FranLizMeli) y [Alejandra Espindola](https://github.com/ale-espindola)_

-------
#### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

_**Sign:**_

|     Method     | SIGN                                                                                                                                                                                                                                                                                                                        |
|:--------------:|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|    **GET**     | /users/{userId}/followed/list                                                                                                                                                                                                                                                                                               |
|                | Ejemplo: /users/4698/followed/list                                                                                                                                                                                                                                                                                          | 
|  **Response**  | <pre>{<br/>  "user_id": 4698,<br/>  "user_name": "usuario1",<br/>  "followed":[<br/>  {<br/>    "user_id": 234,<br/>    "user_name": "vendedor1"<br/>  },<br/>  {<br/>    "user_id": 6932,<br/>    "user_name": "vendedor2"<br/>  },<br/>  {<br/>    "user_id": 6631,<br/>    "user_name": "vendedor3"<br/>  }<br/> ]<br/>} |


_**Filtros/Parámetros:**_

| Parámetros |                       Tipo                       | Descripción/Ejemplo                  |
|------------|:------------------------------------------------:|--------------------------------------|
| **userId** |                       int                        | Número que identifica a cada usuario | 

Fue desarrollado por: _[Francisco Liz Mardones](https://github.com/FranLizMeli) y [Alejandra Espindola](https://github.com/ale-espindola)_

-------
#### US 0005: Dar de alta una nueva publicación

_**Sign:**_

|    Method    | SIGN                                                                                                                                                                                                                                                                                                                                |
|:------------:|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|   **POST**   | products/post                                                                                                                                                                                                                                                                                                                       | 
| **PAYLOAD**  | <pre>{<br/>  "user_id": 123,<br/>  "date": "29-04-2021",<br/>  "product":{<br/>     "product_id": 1,<br/>     "product_name": "Silla Gamer",<br/>     "type": "Gamer",<br/>     "brand": "Racer",<br/>     "color": "Red & Black",<br/>     "notes": "Special Edition"<br/>  },<br/>  "category": 100,<br/>  "price": 1500.50<br/>} |
| **RESPONSE** | Status Code 200 (todo OK)                                                                                                                                                                                                                                                                                                           |
|              | Status Code 400 (Bad Request)                                                                                                                                                                                                                                                                                                       |

_**Filtros/Parámetros:**_

| Parámetros       |   Tipo   | Descripción/Ejemplo                                                                                                      |
|------------------|:--------:|--------------------------------------------------------------------------------------------------------------------------|
| **userId**       |   int    | Número que identifica a cada usuario                                                                                     | 
| **date**         | Localate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| **product_id**   |   int    | Número identificatorio de un producto asociado a una publicación                                                         |
| **product_name** |  String  | Cadena de caracteres que representa el nombre de un producto                                                             |
| **type**         |  String  | Cadena de caracteres que representa el tipo de un producto                                                               |
| **brand**        |  String  | Cadena de caracteres que representa la marca de un producto                                                              |
| **color**        |  String  | Cadena de caracteres que representa el color de un producto                                                              |
| **notes**        |  String  | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| **category**     |   int    | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| **price**        |  double  | Precio del producto                                                                                                      |

Fue desarrollado por: _[Franciso Idalgo](https://github.com/franidalgoml) y [Emanuel Fonseca](https://github.com/Emanoide47)_

-------
#### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

_**Sign:**_

|     Method     | SIGN                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
|:--------------:|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|    **GET**     | /products/followed/{userId}/list                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
|                | Ejemplo: /products/followed/4698/list                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | 
|  **Response**  | <pre>{<br/>  "user_id": 4698,<br/>  "posts":[<br/>  {<br/>    “user_id”: 123,<br/>    "post_id": 32,<br/>    "date": "01-05-2021",<br/>    "product":{<br/>        "product_id": 62,<br/>        "product_name": "Headset RGB Inalámbrico",<br/>        "type": "Gamer",<br/>        "brand": "Razer",<br/>        "color": "Green with RGB",<br/>        "notes": "Sin Batería"<br/>    },<br/>    "category": 120,<br/>    "price": 2800.69<br/>  },<br/>  {<br/>    “user_id”: 234,<br/>    "post_id": 18,<br/>    "date": "29-04-2021",<br/>    "product":{<br/>        "product_id": 1,<br/>        "productName": "Silla Gamer",<br/>        "type": "Gamer",<br/>        "brand": "Racer",<br/>        "color": "Red & Black",<br/>        "notes": "Special Edition"<br/>   },<br/>   "category": 100,<br/>   "price": 15000.50 <br/>   }<br/>  ]<br/>} |

_**Filtros/Parámetros:**_

| Parámetros |                       Tipo                       | Descripción/Ejemplo                  |
|------------|:------------------------------------------------:|--------------------------------------|
| **userId** |                       int                        | Número que identifica a cada usuario | 

Fue desarrollado por: _[Franciso Idalgo](https://github.com/franidalgoml) y [Emanuel Fonseca](https://github.com/Emanoide47)_

-------
#### US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

_**Sign:**_

|  Method  | SIGN                                        |
|:--------:|---------------------------------------------|
| **POST** | /users/{userId}/unfollow/{userIdToUnfollow} |
|          | Ejemplo:  /users/234/unfollow/123           |

_**Filtros/Parámetros:**_

| Parámetros           | Tipo | Descripción/Ejemplo                                |
|----------------------|:----:|----------------------------------------------------|
| **userId**           | int  | Número que identifica al usuario actual            |
| **userIdToUnfollow** | int  | Número que identifica al usuario a dejar de seguir |

Fue desarrollado por: _[Federico Javier Veron](https://github.com/fedeveron) y [Lorenzo Pedro Podio](https://github.com/lpodio)_

-------
#### US 0008: Ordenamiento alfabético ascendente y descendente

_**Sign:**_

| Method  | SIGN                                           |
|:-------:|------------------------------------------------|
| **GET** | Ejemplos:                                      |
|         | /users/{UserID}/followers/list?order=name_asc  |
|         | /users/{UserID}/followers/list?order=name_desc |
|         | /users/{UserID}/followed/list?order=name_asc   |
|         | /users/{UserID}/followed/list?order=name_desc  |

_**Filtros/Parámetros:**_

| order         | Descripción/Ejemplo     |
|---------------|-------------------------|
| **name_asc**  | Alfabético ascendente.  |
| **name_desc** | Alfabético descendente. |

***Nota**: Este ordenamiento aplica solo para US-003 y US-004.

Fue desarrollado por: _[Diego Fernando Alderete](https://github.com/DiegoFernandoAlderete), [Alejandra Espindola](https://github.com/ale-espindola),
[Federico Javier Veron](https://github.com/fedeveron), [Flavio Ambroggio](https://github.com/flavio-ambroggio-meli), [Francisco Liz Mardones](https://github.com/FranLizMeli),
[Lorenzo Pedro Podio](https://github.com/lpodio), [Franciso Idalgo](https://github.com/franidalgoml), [Emanuel Fonseca](https://github.com/Emanoide47)._

-------
#### US 0009: Ordenamiento por fecha ascendente y descendente

_**Sign:**_

| Method  | SIGN                                               |
|:-------:|----------------------------------------------------|
| **GET** | Ejemplos:                                          |
|         | /products/followed/{userId}/list?order=date_asc    |
|         | /products/followed/{userId}/list?order=date_desc   |

_**Filtros/Parámetros:**_

| order         | Descripción/Ejemplo                             |
|---------------|-------------------------------------------------|
| **date_asc**  | Fecha ascendente (de más antigua a más nueva)   |
| **date_desc** | Fecha descendente (de más nueva a más antigua)  |

***Nota**: Este ordenamiento aplica solo para US-003 y US-004.

Fue desarrollado por: _[Diego Fernando Alderete](https://github.com/DiegoFernandoAlderete), [Alejandra Espindola](https://github.com/ale-espindola),
[Federico Javier Veron](https://github.com/fedeveron), [Flavio Ambroggio](https://github.com/flavio-ambroggio-meli), [Francisco Liz Mardones](https://github.com/FranLizMeli),
[Lorenzo Pedro Podio](https://github.com/lpodio), [Franciso Idalgo](https://github.com/franidalgoml), [Emanuel Fonseca](https://github.com/Emanoide47)._

-------
#### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

_**Sign:**_

|  Method  | SIGN                |
|:--------:|---------------------|
| **POST** | /products/promo-post|

_**Filtros/Parámetros:**_

| Parámetros   | Tipo      | Descrpición / Ejemplo                                                                                                    |
|--------------|-----------|--------------------------------------------------------------------------------------------------------------------------|
| user_id      | int       | Número que identifica a cada usuario                                                                                     |
| date         | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| product_id   | int       | Número identificatorio de un producto asociado a una publicación                                                         |
| product_name | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| type         | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| brand        | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| color        | String    | Cadena de caracteres que representa el color de un producto                                                              |
| notes        | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| category     | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price        | double    | Precio del producto                                                                                                      |
| has_promo    | boolean   | Campo true o false para determinar si un producto está en promoción o no                                                 |
| discount     | double    | En caso de que un producto estuviese en promoción, establece el monto de descuento                                       |

***Nota**: Este ordenamiento aplica solo para US-003 y US-004.

Fue desarrollado por: [Francisco Liz Mardones](https://github.com/FranLizMeli)

-------
#### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

_**Sign:**_

| Method  | SIGN                                        |
|:-------:|---------------------------------------------|
| **GET** | /products/promo-post/count?user_id={userId} |

_**Filtros/Parámetros:**_

| Parámetros           | Tipo      | Descrpición / Ejemplo                                                 |
|----------------------|-----------|-----------------------------------------------------------------------|
| user_id              | int       | Número que identifica a cada usuario                                  |
| date                 | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                         |
| promo_products_count | int       | Cantidad numérica de productos en promoción de un determinado usuario |


Fue desarrollado por: [Francisco Liz Mardones](https://github.com/FranLizMeli)

-------
#### US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
_**Sign:**_

| Method  | SIGN                                       |
|:-------:|--------------------------------------------|
| **GET** | /products/promo-post/list?user_id={userId} |

_**Filtros/Parámetros:**_

| Parámetros   | Tipo      | Descrpición / Ejemplo                                                                                                    |
|--------------|-----------|--------------------------------------------------------------------------------------------------------------------------|
| user_id      | int       | Número que identifica a cada usuario                                                                                     |
| user_name    | String    | Cadena de caracteres que representa el nombre del usuario                                                                |
| post_id      | int       | Número identificatorio de cada una de las publicaciones                                                                  |
| date         | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| product_id   | int       | Número identificatorio de un producto asociado a una publicación                                                         |
| product_name | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| type         | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| brand        | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| color        | String    | Cadena de caracteres que representa el color de un producto                                                              |
| notes        | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| category     | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price        | double    | Precio del producto                                                                                                      |
| has_promo    | boolean   | Campo true o false para determinar si un producto está en promoción o no                                                 |
| discount     | double    | En caso de que un producto estuviese en promoción, establece el monto de descuento                                       |

Fue desarrollado por: [Francisco Liz Mardones](https://github.com/FranLizMeli)

____

# 🇨🇱🇺🇾🇦🇷 _Miembros del equipo N°2_ 🇨🇱🇺🇾🇦🇷
____
- [Diego Fernando Alderete](https://github.com/DiegoFernandoAlderete)
- [Alejandra Espindola](https://github.com/ale-espindola)
- [Federico Javier Veron](https://github.com/fedeveron)
- [Flavio Ambroggio](https://github.com/flavio-ambroggio-meli)
- [Francisco Liz Mardones](https://github.com/FranLizMeli)
- [Lorenzo Pedro Podio](https://github.com/lpodio)
- [Franciso Idalgo](https://github.com/franidalgoml)
- [Emanuel Fonseca](https://github.com/Emanoide47)

## 💻 Tecnologías utilizadas 💻

- Java 11
- Postman 
- Intellij IDEA 
- Spring Boot 2.7.7
- Maven 
- Git
- Git Hub
- Lombok 

