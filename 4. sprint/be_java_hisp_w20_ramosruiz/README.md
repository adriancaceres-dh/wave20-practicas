
# Sprint 1 Social MELI.

### Miembros del equipo.

- **Scrum Master** Johanna Tabella.
- Agustin Iglesias.
- Esteban Jose Demarchi.
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

### Endpoints (Grupales)

[Colección de request para importar en Postman](User%20Stories.postman_collection.json)

Responsables de cada User Story

| User Story | Responsables |
| --- | --- |
| **US 0001** | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0002** | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi |
| **US 0003** | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi |
| **US 0004** | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi |
| **US 0005** | Karen Hoffman y Lautaro Walsh |
| **US 0006** | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0007** | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |
| **US 0008** | Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi |
| **US 0009** | Franciso Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles |

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


----
----
### Decisiones Individuales.

- Puede actualizarse un producto existente con una promoción siempre y cuando:
  - El userId del post a actualizar sea el mismo userId al que pertenece el post original
  - La fecha de actualización sea posterior a la fecha original
  - Ambas publicaciones contengan el mismo producto
  - Ambas publicaciones coincidan en código de categoría
  - El descuento a actualizar es distinto del original
- Utilizar el endpoint US_0005 (Llevar a cabo una publicación) con un Body con promoción no arroja un error 400, pero no publica el producto con promoción.
- Utilizar el endpoiint US_0010 (Llevar a cabo una publicación con promoción) con un Body sin promoción arroja error 400.
- Implemento US_0012 de ejemplo y le agrego ordenamiento por fecha en US_0013 con más recientes por defecto.

### Endpoints (Individuales)

[Colección de request para importar en Postman](UserStories-ramosruiz.postman_collection.json)

**US 0010**

_Llevar a cabo la publicación de un nuevo producto en promoción_

| Method | Sign |
| --- | --- |
| **POST** | /products/promo-post |

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
 &nbsp;&nbsp;&nbsp;"price": 1500.50,
 &nbsp;&nbsp;&nbsp;"has_promo": "true",
 &nbsp;&nbsp;&nbsp;"discount": 0.10
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
"has_promo": true,
"discount": 0.10
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
<tr>
<td><strong>400</strong></td>
<td>
<pre><code class="language-plaintext">{
"message": "La promoción no es válida",
"status": 400,
"timestamp": "2023-01-05T12:30:18.042318"
}</code></pre>
</td>
</tr>

<tr>
<td><strong>400</strong></td>
<td>
<pre><code class="language-plaintext">{
"message": "Actualización de publicación inválida",
"status": 400,
"timestamp": "2023-01-05T12:27:53.422158"
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
| **color** | String | Cadena de caracteres que representa el color de un producto |
| **notes** | String | Cadena de caracteres para colocar notas u observaciones de un producto |
| **category** | int | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| **price** | String | Precio del producto |
| **has_promo** | boolean | Campo true o false para determinar si un producto está en promoción o no |
| **discount** | double | En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

----
**US 0011**

_Obtener la cantidad de productos en promoción de un determinado vendedor_

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **GET** | /products/promo-post/count?user_id={userId} | /products/promo-post/count?user_id=234 |

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
 &nbsp;&nbsp;&nbsp;"promo_products_count": 23
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
<tr style="height: 23px;">
<td style="height: 23px;"><strong>400</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no es vendedor",
"status": 400,
"timestamp": "2023-01-05T13:36:41.913820"
}</code></pre>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| Parámetros | Tipo | Descripción / Ejemplo |
| --- | --- | --- |
| **userId** | int | Número que identifica a cada usuario |
| **userName** | String | Cadena de caracteres que representa el nombre del usuario |
| **promoProductsCount** | int | Cantidad numérica de productos en promoción de un determinado usuario. |

----
**US 0012**

_Obtener un listado de todos los productos en promoción de un determinado vendedor_

| Method | Sign | Ejemplo |
| --- | --- | --- |
| **GET** | /products/promo-post/list?user_id={userId} | /products/promo-post/list?user_id=234 |

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
"user_id": 234,
"user_name": "vendedor1",
"posts": [
    {
        “user_id”: 234
        "post_id": 18,
        "date": "29-04-2021",
        "product": {
            "product_id": 1,
            "product_name": "Silla Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition"
        },
        "category": "100",
        "price": 15000.50,
        "has_promo": true,
        "discount": 0.25
    }
]
}
</code></pre>
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
<tr style="height: 23px;">
<td style="height: 23px;"><strong>400</strong></td>
<td style="height: 23px;">
<pre><code class="language-plaintext">{
"message": "El usuario no es vendedor",
"status": 400,
"timestamp": "2023-01-05T13:36:41.913820"
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
**US 0013**

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
<p>/products/promo-post/list?user_id={userId}?order=date_desc</p>
<p>/products/promo-post/list?user_id={userId}?order=date_asc</p>
</td>
</tr>
</tbody>
</table>

Filtros / Parámetros

| order | Description |
| --- | --- |
| **date\_asc** | Fecha ascendente (de más antigua a más nueva) |
| **date\_desc** | Fecha descendente (de más nueva a más antigua) |

**Nota:** Este ordenamiento aplica solo para la US-0012

----