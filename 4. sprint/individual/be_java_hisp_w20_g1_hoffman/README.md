
# Project Title

# Sprint 1 Social MELI. Desarrollo individual

- **Scrum Master** Johanna Tabella.
- **Developer** Karen Hoffman.


## Descripción.

SocialMeli tiene como objetivo extra lograr permitir 
a los vendedores la posibilidad de publicar 
nuevos productos con ofertas o descuentos especiales 
exclusivos para sus seguidores por un determinado 
período de tiempo. 


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
- Faker (para generar los Json).
- Model Mapper.

### Decisiones.

- El valor del descuento se interpreta como porcentaje.
- Se creó un endpoint adicional para la modificación de un posteo.
- El endpoint perteneciente al bonus permitirá también modificar el posteo.
- Todos los datos son modificables a excepción de los identificadores.


### Endpoints 

[Colección de request para importar en Postman](individual.postman_collection.json)


----
**US 00010**

Llevar a cabo la publicación de un nuevo producto en promoción
<p><strong>Sign</strong><strong>:</strong></p>
<table>
<tbody>
<tr>
<td>
<p><strong>Method</strong></p>
</td>
<td>
<p><strong>SIGN</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">POST</span></p>
</td>
<td>
<p><span style="font-weight: 400;">/products/promo-post</span></p>
</td>
</tr>
<tr>
<td>
<p><strong>PAYLOAD:</strong></p>
</td>
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
<tr>
<td>
<p><strong>Response</strong></p>
</td>
<td>
<p><span style="font-weight: 400;">Status Code 200 (OK)</span></p>
<p><span style="font-weight: 400;">Status Code 400 (Bad request)</span></p>
</td>
</tr>
</tbody>
</table>

<p><span style="font-weight: 400;">&nbsp;&nbsp;</span></p>
<p><strong>Filtros/Par&aacute;metros:</strong></p>
<table>
<tbody>
<tr>
<td>
<p><strong>Par&aacute;metros</strong></p>
</td>
<td>
<p><strong>Tipo</strong></p>
</td>
<td>
<p><strong>Descripci&oacute;n/Ejemplo</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">user_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">N&uacute;mero que identifica a cada usuario</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">date</span></p>
</td>
<td>
<p><span style="font-weight: 400;">LocalDate</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Fecha de la publicaci&oacute;n en formato dd-MM-yyyy</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">product_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">N&uacute;mero identificatorio de un producto asociado a una publicaci&oacute;n</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">product_name</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el nombre de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">type</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el tipo de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">brand</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa la marca de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">color</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el color de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">notes</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres para colocar notas u observaciones de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">category</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Identificador que sirve para conocer la categor&iacute;a a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">price</span></p>
</td>
<td>
<p><span style="font-weight: 400;">double</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Precio del producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">has_promo</span></p>
</td>
<td>
<p><span style="font-weight: 400;">boolean</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Campo true o false para determinar si un producto est&aacute; en promoci&oacute;n o no</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">discount</span></p>
</td>
<td>
<p><span style="font-weight: 400;">double</span></p>
</td>
<td>
<p><span style="font-weight: 400;">En caso de que un producto estuviese en promoci&oacute;n ,establece el monto de descuento.</span></p>
</td>
</tr>
</tbody>
</table>


**US 00011**

_Obtener la cantidad de productos en promoción de un determinado vendedor_


<p><span style="font-weight: 400;">&nbsp;&nbsp;</span></p>
<p>&nbsp;</p>
<p><strong>Sign</strong><strong>:</strong></p>
<table>
<tbody>
<tr>
<td>
<p><strong>Method</strong></p>
</td>
<td>
<p><strong>SIGN</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">GET</span></p>
</td>
<td>
<p><span style="font-weight: 400;">/products/promo-post/count?user_id={userId}</span></p>
</td>
</tr>
<tr>
<td>
<p><strong>Response</strong></p>
</td>
<td>
<p><span style="font-weight: 400;">{&nbsp;&nbsp;</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;"user_id" : 234,</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;"user_name": "vendedor1",</span></p>
<p><span style="font-weight: 400;">&nbsp;&nbsp;&nbsp;"promo_products_count": 23</span></p>
<p><span style="font-weight: 400;">}</span></p>
</td>
</tr>
</tbody>
</table>
<p><strong>Filtros/Par&aacute;metros:</strong></p>
<table>
<tbody>
<tr>
<td>
<p><strong>Par&aacute;metros</strong></p>
</td>
<td>
<p><strong>Tipo</strong></p>
</td>
<td>
<p><strong>Descripci&oacute;n/Ejemplo</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">user_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">N&uacute;mero que identifica a cada usuario</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">user_name</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el nombre del usuario</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">promo_products_count</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cantidad num&eacute;rica de productos en promoci&oacute;n de un determinado usuario.</span></p>
</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>


**US 00012**

_Obtener un listado de todos los productos en promoción de un determinado vendedor_

Sign:
Method
SIGN
GET
/products/promo-post/list?user_id={userId}
RESPONSE:
{
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

<p><span style="font-weight: 400;">&nbsp;&nbsp;</span></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><strong>Filtros/Par&aacute;metros:</strong></p>
<table>
<tbody>
<tr>
<td>
<p><strong>Par&aacute;metros</strong></p>
</td>
<td>
<p><strong>Tipo</strong></p>
</td>
<td>
<p><strong>Descripci&oacute;n/Ejemplo</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">user_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">N&uacute;mero que identifica a cada usuario</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">user_name</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el nombre del usuario</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">post_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">N&uacute;mero identificatorio de cada una de las publicaciones</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">date</span></p>
</td>
<td>
<p><span style="font-weight: 400;">LocalDate</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Fecha de la publicaci&oacute;n en formato dd-MM-yyyy</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">product_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">N&uacute;mero identificatorio de un producto asociado a una publicaci&oacute;n</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">product_name</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el nombre de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">type</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el tipo de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">brand</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa la marca de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">color</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres que representa el color de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">notes</span></p>
</td>
<td>
<p><span style="font-weight: 400;">String</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Cadena de caracteres para colocar notas u observaciones de un producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">category</span></p>
</td>
<td>
<p><span style="font-weight: 400;">int</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Identificador que sirve para conocer la categor&iacute;a a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">price</span></p>
</td>
<td>
<p><span style="font-weight: 400;">double</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Precio del producto</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">has_promo</span></p>
</td>
<td>
<p><span style="font-weight: 400;">boolean</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Campo true o false para determinar si un producto est&aacute; en promoci&oacute;n o no</span></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">discount</span></p>
</td>
<td>
<p><span style="font-weight: 400;">double</span></p>
</td>
<td>
<p><span style="font-weight: 400;">En caso de que un producto estuviese en promoci&oacute;n, establece el monto de descuento.</span></p>
</td>
</tr>
</tbody>
</table>

## Agradecimientos

_A mis compañeros y a nustra scrum master (Joy) por brindar todo su conocimiento 
y buena onda_