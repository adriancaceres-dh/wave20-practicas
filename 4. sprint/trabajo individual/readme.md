
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
## Alcance

Este proyecto incluye todas las US desarrolladas en el trabajo grupal con sus mismas consideraciones y las US individuales (US0010 y US0011) y bonus (US0012) 



## API Reference
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

