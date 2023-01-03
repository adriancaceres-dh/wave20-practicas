# MeliSocial
## Sprint 1

## Miembros
* Alejandro Torres
* Augusto Díaz
* Daniel Andres Angel Rojas
* Daniela Villamizar
* David Nuñez
* Diana Parra
* Juan Carlos Ortiz
## Consigna del ejercicio

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. 

Para poder realizar esto, un analista funcional relevó una serie de requerimientos que deben llevarse a cabo.
## Tecnologías
* Java 11
* SpringBoot 2.7.7
## Decisiones de equipo


## Modelado

### Usuario
![Modelado de clase Usuario](https://i.ibb.co/dBqjCJP/Diagrama-Sprint1-Pa-gina-1-3.jpg)

### Producto
![Modelado de clase producto](https://i.ibb.co/DKpNSpt/Diagrama-Sprint1-Pa-gina-1-4.jpg)

### Publicación
![Modelado de la clase publicación](https://i.ibb.co/t4xHWZH/Diagrama-Sprint1-Pa-gina-1-5.jpg)

<!---[Enlace al repo original](https://github.com/alejandrotm20/be_java_hisp_w20_g6)-->

## Endpoints
**US0001**:
Poder realizar la acción de "Follow" (seguir) a un determinado vendedor

| METHOD | SIGN | EJEMPLO |
|:------- | :------- | :-------|
|`POST`| `/users/{userId}/follow/{userIdToFollow}` | `/users/1/followers/count`


RESPONSE: Status code 200 - Bodyless | Status code 400 - Bodyless

RESPONSABLE: Daniela Villamizar
***
**US0002**:
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

| METHOD | SIGN | EJEMPLO | 
|:-------|:-------|:-------|
|`GET`| `/users/{userId}/followers/count` | `/users/1/followers/count` |



RESPONSE:
~~~json
{
    "user_id": 1,
    "user_name": "pablito1",
    "followers_count": 35
}
~~~

Responsable: Alejandro Torres
***
**US0003**:
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

| METHOD | SIGN | EJEMPLO|
|:-------|:---------------|:--------------------|
|`GET`| `/users/{userId}/followers/list` | `/users/1/followers/list`|



RESPONSE:
```json
{
    "user_id": 1,
    "user_name": "vendedor1",
    "followers": [
        {
            "user_id": 4698,
            "user_name": "usuario1"
        },
        {
            "user_id": 1536,
            "user_name": "usuario2"
        },
        {
            "user_id": 2236,
            "user_name": "usuario3"
        }
    ]
}
```
RESPONSABLE: Daniel Andres Angel Rojas
***
**US0004**: 
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

| METHOD | SIGN | EJEMPLO|
|:--------|:----------|:----------|
|`POST` | `/users/{userId}/followed/list`| `/users/1/followed/list` |

RESPONSE:
```json
{
    "user_id": 1,
    "user_name": "vendedor1",
    "followed": [
        {
            "user_id": 4698,
            "user_name": "usuario1"
        },
        {
            "user_id": 1536,
            "user_name": "usuario2"
        },
        {
            "user_id": 2236,
            "user_name": "usuario3"
        }
    ]
}
```

RESPONSABLE: Augusto Díaz
***
**US0005**: 
Dar de alta una nueva publicación
|METHOD | SIGN |
|:-------|:------|
|`POST` | `/products/post`|

PAYLOAD:
```json
{
    "user_id": 123,
    "date": "29-04-2021",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```
RESPONSE: Status code 200 (OK) | Status code 400 (Bad request)

Responsable: Juan Carlos Ortiz
***
**US0006**: 
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

| METHOD | SIGN | EJEMPLO |
|:--------|:--------|:----------|
|`GET` | `/products/followed/{userId}/list` | `/products/followed/1/list`|

RESPONSE:
```json
{
    "user_id": 4698,
    "posts": [ {
            "user_id": 123,
            "post_id": 32,
            "date": "01-05-2021",
            "product": {
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
        },
        {
            "user_id": 234,
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.50
        }
    ]
}
```
RESPOSANBLE: David Nuñez
***
**US0007**: 
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

|METHOD | SIGN | EJEMPLO |
|:-----|:--------|:--------|
|`POST` | `/users/{userId}/unfollow/{userIdToUnfollow}` | ` /users/234/unfollow/123`|

RESPONSE: Status code 200 (OK) - Bodyless | Status code 400 (Bad request) - Bodyless

RESPONSABLE: Diana Parra
***
**US0008**:
Ordenamiento alfabético ascendente y descendente

|METHOD | EJEMPLOS|
|:--------- | :--------|
|`GET`  |`/users/{UserID}/followers/list?order=name_asc`<br>`/users/{UserID}/followers/list?order=name_desc`<br>`/users/{UserID}/followed/list?order=name_asc`<br>`/users/{UserID}/followed/list?order=name_desc`

|ORDER | DESCRIPTION |
|:------| :--------|
|`name_asc` | Alfabético ascendente |
|`name_desc` | Alfabético descendente |

**NOTA**: Este ordenamiento solo aplica para **US0003** y **US0004**

RESPONSABLE: Daniela Villamizar
***
**US0009**:
Ordenamiento por fecha ascendente y descendente

|METHOD|EJEMPLOS|
|:-------|:-------|
|`GET`|`/products/followed/{userId}/list?order=date_asc`<br>`/products/followed/{userId}/list?order=date_desc`|

|ORDER|DESCRIPTION|
|:------|:--------|
|`date_asc`|Fecha ascendente (de más antigua a más nueva)|
|`date_desc` |Fecha descendente (de más nueva a más antigua)| 

**NOTA**: Este ordenamiento solo aplica para **US0006**


