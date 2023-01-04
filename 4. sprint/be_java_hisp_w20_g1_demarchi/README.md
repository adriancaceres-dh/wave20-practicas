
# Sprint 1 Social MELI.

Entrega individual ❗

### Miembros del equipo.

- **Scrum Master** Johanna Tabella.
- Agustin Iglesias.
- **Esteban Jose Demarchi**. ❗
- Facundo Andres Ruiz.
- Francisco Nicolas Berthet Cosentino.
- Juan Pablo Ramos Ruiz.
- Karen Hoffman.
- Lautaro Walsh.
- Armando Burdiles.

## Descripción.

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.


### Tecnologias usadas.
- Java 11
- JDK 11
- SpringBoot 2.7.7
- Postman
- Maven

### Convenciones.

- Variables en camelCase.
- Código en inglés

### Dependencias.

- Lombok.
- Spring Boot DevTools.
- Spring Web.
- Faker (para generar los Json)
- Model Mapper

### Decisiones de Equipo.

- Un usuario no puede seguirse a si mismo.
- Solo se puede seguir a vendedores.
- Cada post genera un nuevo producto con id único.
- Hay una relación 1-1 de post y producto.
- No se puede tener productos con mismo id
- Se acordó para el próximo sprint implementar el modelo de _Categoria_, utilizando por el momento solo sus Ids.
- Consideramos que un usuario es vendedor si tiene al menos una publicación.
- Al lanzarse excepciones, se mostrará su descripción, código de error y timestamp.

### Decision individuales para la entrega
- El usuario puede agregar un producto que ya exista en promoción con descuento, en este caso se verificará que dicho producto sea exactamente igual al ya definido
- En caso de no existir un producto cuando se lo quiera agregar en promoción, este se creará.

### Endpoints

[Colección de request para importar en Postman](User%20Stories.postman_collection.json)

Responsables de cada User Story

| User Story   | Responsables                                                                 |
|--------------|------------------------------------------------------------------------------|
| **US 0001**  | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0002**  | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi                     |
| **US 0003**  | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi                     |
| **US 0004**  | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi                     |
| **US 0005**  | Karen Hoffman y Lautaro Walsh                                                |
| **US 0006**  | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0007**  | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0008**  | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi                     |
| **US 0009**  | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0010*** | Esteban Jose Demarchi                                                        |
| **US 0011*** |Esteban Jose Demarchi|
| **US 0012*** |Esteban Jose Demarchi|
| **US 0013*** |Esteban Jose Demarchi|

(*) Entregas individuales

----
**US 0001**

_Poder realizar la acción de “Follow” (seguir) a un determinado vendedor_


| Method | Sign | Ejemplo |
| --- | --- | --- |
| **POST** | /users/{userId}/follow/{userIdToFollow} | /users/123/follow/234 |


<table>
<tbody>
<tr style="height: 23px;">
<td style="height: 23px;">Status Code</td>
<td style="height: 23px;">Response / Dto</td>
</tr>
<tr style="height: 313.375px;">
<td style="height: 313.375px;"><strong>200</strong></td>
<td style="height: 313.375px;">
<pre><code class="language-json">{
"user_id": 1,
"user_name": "zchanelleHhanelle",
"followed": [
{
"user_id": 2,
"user_name": "zmohamedDohamed"
},
{
"user_id": 3,
"user_name": "kinaMina"
}
]
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>400 </strong><em>(el usuario a seguir no es vendedor)</em></td>
<td style="height: 23px;">
<pre><code class="language-json">{
"message": "El usuario no es vendedor",
"status": 400,
"timestamp": "2023-01-03T12:22:44.591493"
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>404</strong> (algun usuario no existe)</td>
<td style="height: 23px;">
<pre><code class="language-json">{
"message": "El usuario no existe",
"status": 404,
"timestamp": "2023-01-03T12:21:26.891095"
}</code></pre>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica al usuario actual |
| **userIdToFollow** | int | Número que identifica al usuario actual |

----
**US 0002**

_Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor_

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **GET** | /users/{userId}/followers/count | /users/234/followers/count/ |

<table>
<tbody>
<tr style="height: 23.5px;">
<td style="height: 23.5px;">Status Code</td>
<td style="height: 23.5px;">Response / Dto</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>200</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
 &nbsp;&nbsp;&nbsp;"user_id": 234,
 &nbsp;&nbsp;&nbsp;"user_name": "vendedor1",
 &nbsp;&nbsp;&nbsp;"followers_count": 35
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>400</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no es vendedor",
"status": 400,
"timestamp": "2023-01-03T12:25:57.628851"
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>404</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no existe",
"status": 404,
"timestamp": "2023-01-03T12:26:58.065217"
}</code></pre>
</td>
</tr>
</tbody>
</table>


Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica a cada usuario |

----
**US 0003**

_Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)_

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **GET** | /users/{userId}/followers/list | /users/{userId}/followers/list |

<table>
<tbody>
<tr style="height: 23.5px;">
<td style="height: 23.5px;">Status Code</td>
<td style="height: 23.5px;">Response / Dto</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>200</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"user_id": 2,
"user_name": "zmohamedDohamed",
"followers": [
{
"user_id": 1,
"user_name": "zchanelleHhanelle"
},
{
"user_id": 3,
"user_name": "kinaMina"
},
{
"user_id": 4,
"user_name": "marshallBarshall"
}
]
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>404</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no existe",
"status": 404,
"timestamp": "2023-01-03T12:28:38.959081"
}</code></pre>
</td>
</tr>
</tbody>
</table>


Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica a cada usuario |

----
**US 0004**

_Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)_

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **GET** | /users/{userId}/followed/list | /users/4698/followed/list |

<table>
<tbody>
<tr style="height: 23.5px;">
<td style="height: 23.5px;">Status Code</td>
<td style="height: 23.5px;">Response / Dto</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>200</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
 &nbsp;&nbsp;&nbsp;"user_id": 4698,
 &nbsp;&nbsp;&nbsp;"user_name": "usuario1",
 &nbsp;&nbsp;&nbsp;"followed": [
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_id": 234,
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_name": "vendedor1"
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_id": 6932,
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_name": "vendedor2"
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_id": 6631,
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_name": "vendedor3"
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
 &nbsp;&nbsp;&nbsp;]
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>404</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no existe",
"status": 404,
"timestamp": "2023-01-03T12:31:01.167923"
}</code></pre>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica a cada usuario |

----
**US 0005**

_Dar de alta una nueva publicación_

| Method | Sign |
| --- | --- |
| **POST** | /products/post |

<table>
<tbody>
<tr>
<td>Payload</td>
</tr>
<tr>
<td>
<pre><code class="language-plaintext">{
 &nbsp;&nbsp;&nbsp;"user_id": 123,
 &nbsp;&nbsp;&nbsp;"date": "29-04-2021",
 &nbsp;&nbsp;&nbsp;"product": {
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"product_id": 1,
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"product_name": "Silla Gamer",
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"type": "Gamer",
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"brand": "Racer",
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"color": "Red &amp; Black",
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"notes": "Special Edition"
 &nbsp;&nbsp;&nbsp;},
 &nbsp;&nbsp;&nbsp;"category": 100,
 &nbsp;&nbsp;&nbsp;"price": 1500.50
}</code></pre>
</td>
</tr>
</tbody>
</table>

<table>
<tbody>
<tr>
<td>Status Code</td>
<td>Response / Dto</td>
</tr>
<tr>
<td><strong>200</strong></td>
<td>
<pre><code class="language-plaintext">{
"date": "29-04-2021",
"user_id": 1,
"product": {
"product_id": 17,
"product_name": "Silla Gamer",
"type": "Gamer",
"brand": "Racer",
"color": "Red &amp; Black",
"notes": "Special Edition"
},
"category": 100,
"price": 1500.5,
"has_promo": false,
"discount": 0.0
}</code></pre>
</td>
</tr>
<tr>
<td><strong>400</strong></td>
<td>
<pre><code class="language-plaintext">{
"message": "El producto ya existe",
"status": 400,
"timestamp": "2023-01-03T12:32:22.635063"
}</code></pre>
<p>&nbsp;</p>
<pre><code class="language-plaintext">{
"message": "Usuario invalido.",
"status": 400,
"timestamp": "2023-01-03T12:36:40.474285"
}</code></pre>
</td>
</tr>
<tr>
<td><strong>404</strong></td>
<td>
<pre><code class="language-plaintext">{
"message": "Producto no existente",
"status": 404,
"timestamp": "2023-01-03T12:32:43.051445"
}</code></pre>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **user\_Id** | int | Número que identifica a cada usuario |
| **date** | LocalDate | Fecha de la publicación en formato dd-MM-yyyy |
| **product\_id** | int | Número identificatorio de un producto asociado a una publicación |
| **product\_name** | String | Cadena de caracteres que representa el nombre de un producto |
| **type** | String | Cadena de caracteres que representa el tipo de un producto |
| **brand** | String | Cadena de caracteres que representa la marca de un producto |

----
**US 0006**

_Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero)._

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **GET** | /products/followed/{userId}/list | /products/followed/4698/list |

<table>
<tbody>
<tr style="height: 23px;">
<td style="height: 23px;">Status Code</td>
<td style="height: 23px;">Response / Dto</td>
</tr>
<tr style="height: 23.25px;">
<td style="height: 23.25px;"><strong>200</strong></td>
<td style="height: 23.25px;">
<pre><code class="language-plaintext">{
"user_id": 1,
"posts": [
{
"user_id": 2,
"post_id": 3,
"date": "01-02-2023",
"product": {
"product_id": 2,
"product_name": "Intelligent Leather Coat",
"type": "Plastic",
"brand": "Lang and Sons",
"color": "magenta",
"notes": "Est cum aut quidem quo illo."
},
"category": 4,
"price": 19.0
}
]
}</code></pre>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;"><strong>404</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no existe",
"status": 404,
"timestamp": "2023-01-03T12:52:15.010738"
}</code></pre>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica a cada usuario |

----
**US 0007**

_Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor._

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **POST** | /users/{userId}/unfollow/{userIdToUnfollow | /users/234/unfollow/123 |

<table>
<tbody>
<tr style="height: 43px;">
<td style="width: 85px; height: 43px;">Status Code</td>
<td style="width: 284.391px; height: 43px;">Response / Dto</td>
</tr>
<tr style="height: 23.5px;">
<td style="width: 85px; height: 23.5px;"><strong>200</strong></td>
<td style="width: 284.391px; height: 23.5px;">
<pre><code class="language-plaintext">{
"user_id": 1,
"user_name": "zchanelleHhanelle",
"followed": [
{
"user_id": 3,
"user_name": "kinaMina"
}
]
}</code></pre>
</td>
</tr>
<tr >
<td ><strong>404</strong></td>
<td >
<pre><code class="language-plaintext">{
"message": "El usuario no existe",
"status": 404,
"timestamp": "2023-01-03T12:59:24.254171"
}</code></pre>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica al usuario actual |
| **userIdToUnfollow** | int | Número que identifica al usuario a dejar de seguir |

----
**US 0008**

_Ordenamiento alfabético ascendente y descendente_

<table>
<tbody>
<tr>
<td>Method</td>
<td>Sign</td>
</tr>
<tr>
<td><strong>GET</strong></td>
<td>
<p>/users/{UserID}/followers/list?order=name_asc</p>
<p>/users/{UserID}/followers/list?order=name_desc</p>
<p>/users/{UserID}/followed/list?order=name_asc</p>
<p>/users/{UserID}/followed/list?order=name_desc</p>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| order | Description |
| --- | --- |
| **name\_asc** | Alfabético ascendente. |
| **name\_desc** | Alfabético descendente. |

**Nota:** Este ordenamiento aplica solo para US-003 y US-004.

----
**US 0009**

_Ordenamiento por fecha ascendente y descendente_

<table>
<tbody>
<tr>
<td>Method</td>
<td>Sign</td>
</tr>
<tr>
<td><strong>GET</strong></td>
<td>
<p>/products/followed/{userId}/list?order=date_asc</p>
<p>/products/followed/{userId}/list?order=date_desc</p>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| order | Description |
| --- | --- |
| **date\_asc** | Fecha ascendente (de más antigua a más nueva) |
| **date\_desc** | Fecha descendente (de más nueva a más antigua) |

**Nota:** Este ordenamiento aplica solo para la US-006


**US 0010**

_Llevar a cabo la publicación de un nuevo producto en promoción_

| Method   | Sign |
|----------| --- |
| **POST** | /products/promo-post|

<table>
<tbody>
<tr>
<td>Payload</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">{</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"user_id": 234,</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"date": "29-04-2021",</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"product": {</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"product_id": 1,</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"product_name": "Silla Gamer",</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"type": "Gamer",</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"brand": "Racer",</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"color": "Red &amp; Black",</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"notes": "Special Edition"</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;},</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"category": 100,</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"price": 1500.50,</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"has_promo": true,</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;&nbsp;"discount": 0.25</span></p>
<p><span style="font-weight: 400;">}</span></p>
</td>
</tr>
</tbody>
</table>

| Parámetros        | Tipo      | Descripción / Ejemplo                                                                                                    |
|-------------------|-----------|--------------------------------------------------------------------------------------------------------------------------|
| **user\_Id**      | int       | Número que identifica a cada usuario                                                                                     |
| **date**          | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| **product\_id**   | int       | Número identificatorio de un producto asociado a una publicación                                                         |
| **product\_name** | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| **type**          | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| **brand**         | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| **color**         | String    | Cadena de caracteres que representa el color de un producto                                                              |
| **notes**         | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| **category**      | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| **price**         | double    | Precio del producto                                                                                                      |
| **has_promo**     | boolean   | Campo true o false para determinar si un producto está en promoción o no                                                              |
| **discount**      | double    | En caso de que un producto estuviese en promoción ,establece el monto de descuento.                                                              |

<table>
<tbody>
<tr>
<td>Status Code</td>
<td>Response</td>
</tr>
<tr>
<td>200</td>
<td>
<div>
<div>{</div>
<div>"date":"29-04-2021",</div>
<div>"user_id":1,</div>
<div>"post_id":7,</div>
<div>"product":{</div>
<div>"product_id":133,</div>
<div>"product_name":"Silla Gamer",</div>
<div>"type":"Gamer",</div>
<div>"brand":"Racer",</div>
<div>"color":"Red &amp; Black",</div>
<div>"notes":"Special Edition"</div>
<div>},</div>
<div>"category":100,</div>
<div>"price":1500.5,</div>
<div>"has_promo":true,</div>
<div>"discount":0.25,</div>
<div>"price_with_discount":1125.375</div>
<div>}</div>
</div>
</td>
</tr>
<tr>
<td>400 (usuario invalido)</td>
<td>
<div>
<div>{</div>
<div>"message":"Usuario invalido.",</div>
<div>"status":400,</div>
<div>"timestamp":"2023-01-04T16:06:08.513660"</div>
<div>}</div>
</div>
</td>
</tr>
<tr>
<td>400 (diferencias en el producto)</td>
<td>
<div>
<div>{</div>
<div>"message":"El producto tiene caracter&iacute;sticas distintas",</div>
<div>"status":400,</div>
<div>"timestamp":"2023-01-04T16:06:48.533857"</div>
<div>}</div>
</div>
</td>
</tr>
</tbody>
</table>

**US 0011**

_Obtener la cantidad de productos en promoción de un determinado vendedor_

| Method | Sign | Ejemplo                              |
| --- | --- |--------------------------------------|
| **GET** | /products/promo-post/count?user_id={userId} | /products/promo-post/count?user_id=1 |

Filtros / Parámetros

| Parámetros  | Tipo   | Descripción / Ejemplo |
|-------------|--------| --- |
| **user_id** | int    | Número que identifica a cada usuario |
| **user_name** | String | Cadena de caracteres que representa el nombre del usuario |
| **promo_products_count** | int    | Cantidad numérica de productos en promoción de un determinado usuario. |

<table>
<tbody>
<tr>
<td>Status Code</td>
<td>Response</td>
</tr>
<tr>
<td>200</td>
<td>
<div>
<div>{</div>
<div>"user_id":1,</div>
<div>"user_name":"zchanelleHhanelle",</div>
<div>"promo_products_count":2</div>
<div>}</div>
</div>
</td>
</tr>
<tr>
<td>400 (usuario no existe)</td>
<td>
<div>
<div>{</div>
<div>"message":"Usuario invalido.",</div>
<div>"status":400,</div>
<div>"timestamp":"2023-01-04T13:37:52.654604"</div>
<div>}</div>
</div>
</td>
</tr>
<tr>
<td>400 (usuario no es vendedor)</td>
<td>
<div>
<div>{</div>
<div>"message":"El usuario no es vendedor",</div>
<div>"status":400,</div>
<div>"timestamp":"2023-01-04T13:37:16.304540"</div>
<div>}</div>
</div>
</td>
</tr>
<tr>
<td>412 (falta indicar el query parameter)</td>
<td>
<div>
<div>{</div>
<div>"message":"Se esperaban query parameters, verifique documentacion",</div>
<div>"status":412,</div>
<div>"timestamp":"2023-01-04T16:13:13.960858"</div>
<div>}</div>
</div>
</td>
</tr>
</tbody>
</table>

**US 0012** (Bonus)

_Obtener un listado de todos los productos en promoción de un determinado vendedor_

| Method | Sign | Ejemplo                             |
| --- | --- |-------------------------------------|
| **GET** | /products/promo-post/list?user_id={userId} | /products/promo-post/list?user_id=1 |

Filtros / Parámetros

| Parámetros  | Tipo      | Descripción / Ejemplo |
|-------------|-----------| --- |
| **user_id** | int       | Número que identifica a cada usuario |
| **user_name** | String    | Cadena de caracteres que representa el nombre del usuario |
| **post_id** | int       | Número identificatorio de cada una de las publicaciones |
| **date** | LocalDate | Fecha de la publicación en formato dd-MM-yyyy |
| **product_id** | int       | Número identificatorio de un producto asociado a una publicación |
| **product_name** | String    | Cadena de caracteres que representa el nombre de un producto |
| **type** | String    | Cadena de caracteres que representa el tipo de un producto |
| **brand** | String    | Cadena de caracteres que representa la marca de un producto |
| **color** | String    | Cadena de caracteres que representa el color de un producto |
| **notes** | String    | Cadena de caracteres para colocar notas u observaciones de un producto |
| **category** | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| **price** | double    | Precio del producto |
| **has_promo** | boolean   | Campo true o false para determinar si un producto está en promoción o no |
| **discount** | double    | En caso de que un producto estuviese en promoción, establece el monto de descuento. |

<table>
<tbody>
<tr style="height: 23.5px;">
<td style="height: 23.5px;">Status Code</td>
<td style="height: 23.5px;">Response</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;">200</td>
<td style="height: 23px;">
<div>
<div>{</div>
<div>"user_id":1,</div>
<div>"user_name":"zchanelleHhanelle",</div>
<div>"posts":[</div>
<div>{</div>
<div>"date":"10-02-2022",</div>
<div>"user_id":1,</div>
<div>"post_id":2,</div>
<div>"product":{</div>
<div>"product_id":1,</div>
<div>"product_name":"Durable Steel Bottle",</div>
<div>"type":"Steel",</div>
<div>"brand":"Pagac, Lemke and Langosh",</div>
<div>"color":"green",</div>
<div>"notes":"Labore explicabo accusamus a."</div>
<div>},</div>
<div>"category":5,</div>
<div>"price":14.0,</div>
<div>"has_promo":true,</div>
<div>"discount":0.1,</div>
<div>"price_with_discount":12.6</div>
<div>},</div>
<div>{</div>
<div>"date":"01-01-2023",</div>
<div>"user_id":4,</div>
<div>"post_id":5,</div>
<div>"product":{</div>
<div>"product_id":4,</div>
<div>"product_name":"Practical Plastic Lamp",</div>
<div>"type":"Linen",</div>
<div>"brand":"Rowe LLC",</div>
<div>"color":"salmon",</div>
<div>"notes":""</div>
<div>},</div>
<div>"category":1,</div>
<div>"price":61.0,</div>
<div>"has_promo":true,</div>
<div>"discount":0.25,</div>
<div>"price_with_discount":45.75</div>
<div>},</div>
<div>{</div>
<div>"date":"29-04-2021",</div>
<div>"user_id":1,</div>
<div>"post_id":7,</div>
<div>"product":{</div>
<div>"product_id":133,</div>
<div>"product_name":"Silla Gamer",</div>
<div>"type":"Gamer",</div>
<div>"brand":"Racer",</div>
<div>"color":"Red &amp; Black",</div>
<div>"notes":"Special Edition"</div>
<div>},</div>
<div>"category":100,</div>
<div>"price":1500.5,</div>
<div>"has_promo":true,</div>
<div>"discount":0.25,</div>
<div>"price_with_discount":1125.375</div>
<div>}</div>
<div>]</div>
<div>}</div>
</div>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;">400 (usuario no existente)</td>
<td style="height: 23px;">
<div>
<div>{</div>
<div>"message":"Usuario invalido.",</div>
<div>"status":400,</div>
<div>"timestamp":"2023-01-04T16:30:32.239261"</div>
<div>}</div>
</div>
</td>
</tr>
<tr style="height: 23px;">
<td style="height: 23px;">400 (usuario no vendedor)</td>
<td style="height: 23px;">
<div>
<div>{</div>
<div>"message":"El usuario no es vendedor",</div>
<div>"status":400,</div>
<div>"timestamp":"2023-01-04T16:30:54.862667"</div>
<div>}</div>
</div>
</td>
</tr>
</tbody>
</table>

**US 0013** (Bonus)

_Se permite filtrar los productos en promoción por precio mínimo y precio máximo (referido al total con descuento aplicado), por categoría y también filtrar por descuentos mayores al indicado._

<table>
<tbody>
<tr>
<td>Method</td>
<td>Sign</td>
</tr>
<tr>
<td>GET</td>
<td>
<p>products/promo-post/list?userId={userId}&amp;category={category}</p>
<p>products/promo-post/list?userId={userId}&amp;minPrice={minPrice}&amp;maxPrice={maxPrice}</p>
<p>products/promo-post/list?userId={userId}&amp;minDiscount={minDiscount}</p>
</td>
</tr>
</tbody>
</table>

<table>
<tbody>
<tr>
<td>Query Param</td>
<td>Descripcion</td>
<td>Tipo de valor</td>
<td>Ejemplo</td>
</tr>
<tr>
<td>minPrice</td>
<td>Se obtienen las publicaciones cuyo precio total sea superior al&nbsp;definido</td>
<td>double</td>
<td>/products/promo-post/list?userId=5&amp;minPrice=10</td>
</tr>
<tr>
<td>maxPrice</td>
<td>Se obtienen las publicaciones cuyo precio total sea inferior al definido</td>
<td>double</td>
<td>/products/promo-post/list?userId=5&amp;maxPrice=100</td>
</tr>
<tr>
<td>category</td>
<td>Se obtienen las publicaciones de esa categor&iacute;a en particular</td>
<td>int</td>
<td>/products/promo-post/list?userId=5&amp;category=5</td>
</tr>
<tr>
<td>minDiscount</td>
<td>Se obtienen las publicaciones cuyo descuento sea superior al definido</td>
<td>double</td>
<td>/products/promo-post/list?userId=5&amp;minDiscount=0.2</td>
</tr>
</tbody>
</table>

También se puede filtrar por todos los query param juntos, por ejemplo:

```
/products/promo-post/list?userId=5&category=1&minPrice=20&maxPrice=50&minDiscount=0.15
```

**Nota:** Este ordenamiento aplica solo para US-0012