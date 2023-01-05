# Social Meli

## Scrum Master:
Andres Bolognesi
## Participantes:
Joaquin Pereyra, Martin Gonzalez, Tammara Trivelli, Emiliano Asprea, Ivan Majewski, Gabriela Stocco, Rodrigo Cabrera

## Tecnologías Utilizadas 🛠:
* Java 11
* Maven
* Spring Framework + Plugins (Web, DevTools, Lombok)
* Github.

## Descripción de la API
Desarrollo de una API REST para mejorar la experiencia entre compradores y vendedores.
Los compradores podran seguir a sus vendedores favoritos y enterarse de sus posteos de nuevos productos.

Decidimos trabajar de forma grupal y desarrollamos los primeros 9 requisitos en equipo, recibiendo recomendaciones y feedback constante.
Los requisitos 10, 11 y 12 se trabajaron de forma individual.

Para el USS 12 se implementó un endpoint para filtrar publicaciones por precio. Los parámetros `minPrice` y `maxPrice` son opcionales y pueden usarse en simultáneo o individualmente. Incluso podrían no incluirse y el endpoint simplemente retornará el listado de publicaciones completo (sin filtrar)

## Decisiones funcionales:
* Req 1
  * Un usuario no se puede seguir a sí mismo.
  * Un vendedor puede seguir a un vendedor.
  * Un vendedor puede seguir a un comprador.
  * Un comprador puede seguir a un comprador.
  * Retorna el dto del usuario al que siguió con estado 200.

* Req 2:
  * Es un count a la lista de followers del vendedor.

* Req 3:
  * En caso de que no tenga seguidores devuelve una lista vacía.

* Req 4:
  * En caso de no tener seguidos devuelve una lista vacía.

* Req 5:
  * Un vendedor tiene una lista de publicaciones.
  * Un vendedor puede no tener publicaciones.
  * Una publicación si o si tiene un producto únicamente.
  * Categoría es una entidad aparte.
  * Una publicación tiene una categoría, precio, si tiene promo y el descuento correspondiente.
  * Un usuario puede tener varias publicaciones idénticas siempre y cuando el id de la misma sea diferente.
  * En caso de que un producto no exista o el id sea incorrecto devuelve un 400

* Req 7:
  * No se puede dejar de seguirte a ti mismo.
  * No se puede dejar de seguir a un usuario que no existes

* Req 8 & Req 9:
  * Para ordenar se utilizara un request param en la ruta donde especificará el el orden de ordenamiento


### [Endpoints](https://github.com/adriancaceres-dh/wave20-practicas/files/10354848/3.b.W20.-.Esp.de.Req.tecnicos.funcionales.-.Sprint.N.1.-.Spring.docx.pdf): Responsable Emiliano Asprea

#### US 001:
```http
POST /users/{userId}/follow/{userIdToFollow}
```

#### US 002: 
```http
GET /users/{userId}/followers/count
```

#### US 003:
```http
GET /users/{userId}/followers/list
```

#### US 004:
```http
GET /users/{userId}/followed/list
```

#### US 005:
```http
POST /products/post
```

#### US 006:
```http
GET /products/followed/{userId}/list
```

#### US 007:
```http
POST /users/{userId}/unfollow/{userIdToUnfollow}
```

#### USS 08:
```http
GET /users/{UserID}/followers/list?order=name_asc
GET /users/{UserID}/followers/list?order=name_desc
GET /users/{UserID}/followed/list?order=name_asc
GET /users/{UserID}/followed/list?order=name_desc
```

#### USS 09:
```http
GET /products/followed/{userId}/list?order=date_asc
GET /products/followed/{userId}/list?order=date_desc
```

#### USS 10:
```http
POST /products/promo-post
```

#### USS 11:
```http
GET /products/promo-post/count?user_id={userId}
```

#### USS 12 (BONUS):
```http
GET /products/posts
```

```http
GET /products/posts?min={minPrice}&max={maxPrice}
GET /products/posts?min={minPrice}
GET /products/posts?max={maxPrice}
```

Response
```json
[
  {
    "user_id": 2,
    "post_id": 1,
    "date": "31-12-2022",
    "product": {
      "product_id": 1,
      "product_name": "producto1",
      "type": "tipo",
      "brand": "adidas",
      "color": "yellow",
      "notes": "nota"
    },
    "category": {
      "id": 10,
      "name": "football"
    },
    "price": 15.55,
    "has_promo": false,
    "discount": 15.0
  },
  {
    "user_id": 2,
    "post_id": 2,
    "date": "26-12-2022",
    "product": {
      "product_id": 2,
      "product_name": "producto2",
      "type": "tipo2",
      "brand": "nike",
      "color": "red",
      "notes": "nota2"
    },
    "category": {
      "id": 20,
      "name": "basketball"
    },
    "price": 16.55,
    "has_promo": false,
    "discount": 10.0
  }
]
```

Diagrama UML sprint 1
<img width="866" alt="Captura de pantalla 2022-12-29 a la(s) 15 45 44" src="https://user-images.githubusercontent.com/119961027/209996229-832d4c74-948f-40f8-ba4b-442d76f39a92.png">

Agradecimientos para el equipo de Digital House y los coordinadores del Bootcamp Backend JAVA.