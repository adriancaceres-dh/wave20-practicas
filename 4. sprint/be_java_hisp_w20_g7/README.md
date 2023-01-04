# Bootcamp Backend Java Sprint N°1 - Spring

# Grupo 7

## Roadmap

![Logo](https://assets.digitalhouse.com/content/AR/CTD/DESAFIO%20SPRING_Mesa%20de%20trabajo%201.jpg)

## Miembros del Proyecto

- [@manueldiazmeli](https://github.com/manueldiazmeli)
- [@TomasGonzalezDev](https://github.com/TomasGonzalezDev)
- [@santtury](https://github.com/santtury)
- [@NathamgML](https://github.com/NathamgML)
- [@JuanSHenao](https://github.com/JuanSHenao)
- [@RonaldRosero](https://github.com/RonaldRosero)
- [@SoriGonzalezR](https://github.com/SoriGonzalezR)
- [@steveng45](https://github.com/steveng45)

## Documentación

Mercado Libre sigue creciendo y para el año que viene tiene como objetivo empezar a implementar una serie de
herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo
que los una sea mucho más cercano.

La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser
conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas
las novedades que los mismos posteen.

## Tecnologias Utilizadas

Java, Spring Boot

## Decisiones de Equipo

- Todos los usuarios serán compradores y vendedores así no tengan productos posteados para la venta.
- Todos los usuarios pueden seguirse mutuamente.
- Se agregó hasPromo desde el inicio del desarrollo y se tomó la decisión que se pasaría a falso si no está en
  promoción.

## Endpoints

#### A. Requerimientos Iniciales (Desarrollo GRUPAL)

**Responsables:** Manuel Alejandro Diaz Isaza y Ronald Esteban Rosero Montana.

```http
  US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
```

#### Sign:

| Method.    | SIGN                                              |
|------------|---------------------------------------------------|
| `POST`     | /users/{userId}/follow/{userIdToFollow}           |
| Ejemplo:   | /users/123/follow/234                             |
| `Response` | /Status Code 200 (todo OK) - bodyless or dto      |
|            | /Status Code 400 (Bad Request) -  bodyless or dto |

#### Filtros/Parámetros:

| Parámetros       | Tipo  | Descripción/Ejemplo                       |
|:-----------------|:------|:------------------------------------------|
| `userId`         | `int` | Número que identifica al usuario actual   |
| `userIdToFollow` | `int` | Número que identifica al usuario a seguir |

##  

**Responsables:** Todo el equipo.

```http
  US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
```

#### Sign:

| Method.  | SIGN                            |
|----------|---------------------------------|
| `GET`    | /users/{userId}/followers/count |
| Ejemplo: | /users/234/followers/count/     |

`Response`

```http
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers_count": 35
}
```

#### Filtros/Parámetros:

| Parámetros | Tipo  | Descripción/Ejemplo                      |
|:-----------|:------|:-----------------------------------------|
| `userId`   | `int` | Número que identifica a cantidad usuario |

##  

**Responsables:** Tomas Giovanny Gonzalez Romero y Juan Sebastian Henao Ramirez.

```http
  US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
```

#### Sign:

| Method.  | SIGN                           |
|----------|--------------------------------|
| `GET`    | /users/{userId}/followers/list |
| Ejemplo: | /users/234/followers/list      |

`Response`

```http
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

#### Filtros/Parámetros:

| Parámetros | Tipo  | Descripción/Ejemplo                      |
|:-----------|:------|:-----------------------------------------|
| `userId`   | `int` | Número que identifica a cantidad usuario |

##  

**Responsables:** Stiven Gonzalez y Sebastian Camilo Anttury Sanchez.

```http
  US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

```

#### Sign:

| Method.  | SIGN                          |
|----------|-------------------------------|
| `GET`    | /users/{userId}/followed/list |
| Ejemplo: | /users/4698/followed/list     |

`Response`

```http
{
    "user_id": 4698,
    "user_name": "usuario1",
    "followed": [
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

#### Filtros/Parámetros:

| Parámetros | Tipo  | Descripción/Ejemplo                      |
|:-----------|:------|:-----------------------------------------|
| `userId`   | `int` | Número que identifica a cantidad usuario |

##  

**Responsables:** Soraya Carolina Gonzalez Ramirez y Nathalia Montero Gomez.

```http
  US 0005: Dar de alta una nueva publicación

```

#### Sign:

| Method. | SIGN           |
|---------|----------------|
| `POST`  | /products/post |

`PAYLOAD:`

```http
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

| RESPONSE | Status Code 200 (todo OK)     |
|----------|-------------------------------|
|          | Status Code 400 (Bad Request) 

#### Filtros/Parámetros:

| Parámetros     | Tipo        | Descripción/Ejemplo                                                                                                      |
|:---------------|:------------|:-------------------------------------------------------------------------------------------------------------------------|
| `userId`       | `int`       | Número que identifica a cantidad usuario                                                                                 |
| `date`         | `LocalDate` | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| `product_id`   | `int`       | Número identificatorio de un producto asociado a una publicación                                                         |
| `product_name` | `String`    | Cadena de caracteres que representa el nombre de un producto                                                             |
| `type`         | `String`    | Cadena de caracteres que representa el tipo de un producto                                                               |
| `brand`        | `String`    | Cadena de caracteres que representa la marca de un producto                                                              |
| `color`        | `String`    | Cadena de caracteres que representa el color de un producto                                                              |
| `notes`        | `String`    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| `category`     | `int`       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| `price`        | `double`    | Precio del producto                                                                                                      |

###

**Responsables:** Todo el equipo.

```http
  US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
```

#### Sign:

| Method.  | SIGN                             |
|----------|----------------------------------|
| `GET`    | /products/followed/{userId}/list |
| Ejemplo: | /products/followed/4698/list     |

`Response`

```http
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

#### Filtros/Parámetros:

| Parámetros | Tipo  | Descripción/Ejemplo                      |
|:-----------|:------|:-----------------------------------------|
| `userId`   | `int` | Número que identifica a cantidad usuario |

##  

**Responsables:** Manuel Alejandro Diaz Isaza y Ronald Esteban Rosero Montana.

```http
  US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
```

#### Sign:

| Method.  | SIGN                                        |
|----------|---------------------------------------------|
| `POST`   | /users/{userId}/unfollow/{userIdToUnfollow} |
| Ejemplo: | /users/234/unfollow/123                     |

#### Filtros/Parámetros:

| Parámetros         | Tipo  | Descripción/Ejemplo                                |
|:-------------------|:------|:---------------------------------------------------|
| `userId`           | `int` | Número que identifica al usuario actual            |
| `userIdToUnfollow` | `int` | Número que identifica al usuario a dejar de seguir |

###

**Responsables:** Stiven Gonzalez y Sebastian Camilo Anttury Sanchez.

```http
  US 0008: Ordenamiento alfabético ascendente y descendente.
```

#### Sign:

| Method. | SIGN                                           |
|---------|------------------------------------------------|
| `GET`   | Ejemplo:                                       |
|         | /users/{UserID}/followers/list?order=name_asc  |
|         | /users/{UserID}/followers/list?order=name_desc |
|         | /users/{UserID}/followed/list?order=name_asc   |
|         | /users/{UserID}/followed/list?order=name_desc  |

| order     | Description            |
|-----------|------------------------|
| name_asc  | Alfabético ascendente  |
| name_desc | Alfabético descendente |

**Nota:** Este ordenamiento aplica solo para US-003 y US-004.

###

**Responsables:** Todo el equipo.

```http
  US 0009: Ordenamiento por fecha ascendente y descendente
```

#### Sign:

| Method. | SIGN                                             |
|---------|--------------------------------------------------|
| `GET`   | Ejemplo:                                         |
|         | /products/followed/{userId}/list?order=date_asc  |
|         | /products/followed/{userId}/list?order=date_desc |

| order     | Description                                    |
|-----------|------------------------------------------------|
| date_asc  | Fecha ascendente (de más antigua a más nueva)  |
| date_desc | Fecha descendente (de más nueva a más antigua) |

**Nota:** Este ordenamiento aplica solo para la US-006. 
