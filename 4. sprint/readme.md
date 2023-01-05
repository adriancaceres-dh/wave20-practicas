
# SocialMeli

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. 

En SocialMeli es en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## Authors

#### Scrum Master
- Ignacio Feito

#### Developers 

- [@efruizz](https://www.github.com/efruizz)
- [@francoalva](https://www.github.com/francoalva)
- [@itornati](https://www.github.com/itornati)
- [@IvanGonWM](https://www.github.com/IvanGonWM)
- [@lbalestrazzi](https://www.github.com/lbalestrazzi)
- [@FlorSicre](https://www.github.com/octokatherine)
- [@MatiasSegoviaML](https://www.github.com/MatiasSegoviaML)
- [@cindyortegapalma](https://www.github.com/cindyortegapalma)
## Tecnologias Utilizadas

- [Java](https://www.java.com/)
- [SpringBoot](https://spring.io/projects/spring-boot)



## Modelo
- [SocialMeli](https://lucid.app/lucidchart/2259acad-fa27-4b7d-b338-1a7d836a3e1c/edit?viewport_loc=-11%2C-43%2C1579%2C841%2C0_0&invitationId=inv_e65c2102-36f5-4d29-9cd9-9c2ca21f4fa0)
## Decisiones de Equipo

**US003 & US004:** Concluimos usar un unico DTO para ambos casos ya que la unica diferencia era el valor followed, en vez de followers.

**US0010:** Concluimos con usar dos DTOs, uno para los productos de la US0005 y otra para esta misma la cual contiene productos con descuentos. Para poder lograr guardar estos productos en la lista contenida en el repository decidimos modificar el model del producto agregando dos campos (has_promo, discount).

**Generales:** Concluimos devolver en todos los métodos de los controllers un Response Entity, ya sea de tipo String o con un DTO.






## API Reference

#### US0001
Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

```http
  POST /users/{userId}/follow/{userIdToFollow}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica al usuario actual |
| `userIdToFollow` | `int` | Número que identifica al usuario a seguir|

| Response | 
| :-------- | 
| **Status Code 200** (todo OK) - bodyless or dto| 
| **Status Code 400** (Bad Request) -  bodyless or dto| 

#### *Asignado: Matias Federico Segovia*

&nbsp;
#### US0002 
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

```http
  GET /users/{userId}/followers/count
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica a cada usuario |

***Response***
```javasript
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers_count": 35
}

```

#### *Asignado: Franco Andres Alvarez Alvarado*

&nbsp;
#### US0003
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

```http
  GET /users/{userId}/followers/list
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica a cada usuario |

***Response***
```javasript
{
    "user_id": 234,
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

#### *Asignado: Ignacio Tornati*

&nbsp;
#### US0004
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

```http
  GET /users/{userId}/followed/list
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica a cada usuario |

***Response***
```javasript
{
    "user_id": 4698,
    "user_name": "usuario1",
    "followers": [
        {
            "user_id": 234,
            "user_name": "vendedor1"
        },
        {
            "user_id": 6932,
            "user_name": "vendedor2"
        },
        {
            "user_id": 6631,
            "user_name": "vendedor3"
        }
    ]
}

```

#### *Asignado: Efrain Francisco Ruiz*

&nbsp;
#### US0005
Dar de alta una nueva publicación

```http
  POST /products/post
```

***Payload***
```javasript
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

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica a cada usuario |
| `date` | `localDate` | Fecha de la publicación en formato dd-MM-yyyy |
| `product_id` | `int` | Número identificatorio de un producto asociado a una publicación |
| `product_name` | `String` | Cadena de caracteres que representa el nombre de un producto |
| `type` | `String` | Cadena de caracteres que representa el tipo de un producto |
| `brand` | `String` | Cadena de caracteres que representa la marca de un producto |
| `color` | `String` | Cadena de caracteres que representa el color de un producto |
| `notes` | `String` | Cadena de caracteres para colocar notas u observaciones de un producto |
| `category` | `int` | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| `price` | `double` | Precio del producto |

| Response | 
| :-------- | 
| **Status Code 200** (todo OK)| 
| **Status Code 400** (Bad Request)| 


#### *Asignado: Amalia Lucia Balestrazzi Silveira & Florencia Sicre*


&nbsp;
#### US0006
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

```http
  GET /products/followed/{userId}/list
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica a cada usuario |

***Response***
```javasript
{
    "user_id": 4698,
    "posts": [ {
            “user_id”: 123,
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
            “user_id”: 234,
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

#### *Asignado: Cindy Micaela Ortega Palma*

&nbsp;
#### US0007
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

```http
  POST /users/{userId}/unfollow/{userIdToUnfollow}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId` | `int` | Número que identifica al usuario actual |
| `userIdToUnfollow` | `int` | Número que identifica al usuario a dejar de seguir|

| Response | 
| :-------- | 
| **Status Code 200** (todo OK) - bodyless or dto| 
| **Status Code 400** (Bad Request) -  bodyless or dto| 


#### *Asignado: Ivan Amaro*

&nbsp;
#### US0008
Ordenamiento alfabético ascendente y descendente.
***Aplica para US0003 y US0004***

```http
  GET /users/{UserID}/followers/list?order=name_asc
  GET /users/{UserID}/followers/list?order=name_desc
  GET /users/{UserID}/followed/list?order=name_asc
  GET /users/{UserID}/followed/list?order=name_desc
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name_asc` | `String` | Alfabético ascendente |
| `name_desc` | `String` | Alfabético descendente|

| Response | 
| :-------- | 
| **Status Code 200** (todo OK) - bodyless or dto| 
| **Status Code 400** (Bad Request) -  bodyless or dto| 

&nbsp;
#### US0009
Ordenamiento alfabético ascendente y descendente.
***Aplica para US0003 y US0004***

```http
  GET /products/followed/{userId}/list?order=date_asc
  GET /products/followed/{userId}/list?order=date_desc
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `date_asc` | `String` | Fecha ascendente (de más antigua a más nueva) |
| `date_desc` | `String` | Fecha descendente (de más nueva a más antigua)|

| Response | 
| :-------- | 
| **Status Code 200** (todo OK) - bodyless or dto| 
| **Status Code 400** (Bad Request) -  bodyless or dto| 

&nbsp;
#### US0010
 Llevar a cabo la publicación de un nuevo producto en promoción

```http
  POST /products/promo-post
```

***Payload***
```javasript
{
    "user_id": 234,
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
    "price": 1500.50,
    "has_promo": true,
    "discount": 0.25
}


```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | Número que identifica a cada usuario |
| `date` | `localDate` | Fecha de la publicación en formato dd-MM-yyyy |
| `product_id` | `int` | Número identificatorio de un producto asociado a una publicación |
| `product_name` | `String` | Cadena de caracteres que representa el nombre de un producto |
| `type` | `String` | Cadena de caracteres que representa el tipo de un producto |
| `brand` | `String` | Cadena de caracteres que representa la marca de un producto |
| `color` | `String` | Cadena de caracteres que representa el color de un producto |
| `notes` | `String` | Cadena de caracteres para colocar notas u observaciones de un producto |
| `category` | `int` | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| `price` | `double` | Precio del producto |
| `has_promo` | `boolean` | Campo true o false para determinar si un producto está en promoción o no |
| `discount` | `double` | En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

| Response | 
| :-------- | 
| **Status Code 200** (todo OK)| 
| **Status Code 400** (Bad Request)|

&nbsp;
#### US0011
Obtener la cantidad de productos en promoción de un determinado vendedor

```http
  GET /products/promo-post/count?user_id={userId}
```

***Response***
```javasript
{  
   "user_id" : 234,
   "user_name": "vendedor1",
   "promo_products_count": 23
}

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | Número que identifica a cada usuario |
| `user_name` | `String` | Cadena de caracteres que representa el nombre del usuario |
| `promo_products_count` | `int` | Cantidad numérica de productos en promoción de un determinado usuario. |

&nbsp;
#### US0012
Obtener un listado de todos los productos en promoción de un determinado vendedor

```http
  GET /products/promo-post/count?user_id={userId}
```

***Response***
```javasript
{
    "user_id": 234,
    "user_name": "vendedor1",
    "posts": [
        {
            “user_id”: 123
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

```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `user_id` | `int` | Número que identifica a cada usuario |
| `user_name` | `String` | Cadena de caracteres que representa el nombre del usuario |
| `post_id` | `int` | Número identificatorio de cada una de las publicaciones |
| `date` | `localDate` | Fecha de la publicación en formato dd-MM-yyyy |
| `product_id` | `int` | Número identificatorio de un producto asociado a una publicación |
| `product_name` | `String` | Cadena de caracteres que representa el nombre de un producto |
| `type` | `String` | Cadena de caracteres que representa el tipo de un producto |
| `brand` | `String` | Cadena de caracteres que representa la marca de un producto |
| `color` | `String` | Cadena de caracteres que representa el color de un producto |
| `notes` | `String` | Cadena de caracteres para colocar notas u observaciones de un producto |
| `category` | `int` | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| `price` | `double` | Precio del producto |
| `has_promo` | `boolean` | Campo true o false para determinar si un producto está en promoción o no |
| `discount` | `double` | En caso de que un producto estuviese en promoción ,establece el monto de descuento. |
```

&nbsp;
#### US0013
Obtener un listado de todos los usuarios. Ordenamiento alfabético ascendente y descendente

```http
  GET /users?order=name_asc
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  |  |  |

***Response***
```javasript
[
{
	"user_id": 234,	
        "user_name": "usuario1”,
        "followers": [
            {
                "user_id": 6631,
                "user_name": "usuario2"
            },
            {
                "user_id": 4698,
                "user_name": "usuario3"
            }            
        ],
        "followed": [
            {
                "user_id": 4698,
                "user_name": "usuario3"
            }
        ]        
    },
    {
	"user_id": 6631,
        "user_name": "usuario2”,
        "followers": [
            {
                "user_id": 4698,
                "user_name": "usuario3"
            },
            {
                "user_id": 1536,
                "user_name": "usuario4"
            }
        ],
        "followed": [
            {
                "user_id": 234,
                "user_name": "usuario1"
            }
        ]        
    }
   ]
```

&nbsp;
#### US0014
Dar de alta un nuevo usuario

```http
  POST /users/user
```

***Payload***
```javasript
{
    "user_id": 123,
    "user_name": "nuevo usuario",
}

```

| Parameter    | Type     | Description                |
|:-------------| :------- | :------------------------- |
| `userId`     | `int` | Número que identifica a cada usuario |
| `user_name`  | `String` | Cadena de caracteres que representa el nombre del usuario |


| Response | 
| :-------- | 
| **Status Code 200** (todo OK)| 
| **Status Code 400** (Bad Request)| 