## API Reference

### Products

#### Crear nuevo Post

```http
  POST /products/post
```

Request body esperado:

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

| Parámetro      | Tipo     | Descripción                                                                      |
|:---------------|:---------|:---------------------------------------------------------------------------------|
| `user_id`      | `int`    | Número que identifica a cada usuario                                             |
| `date`         | `string` | Fecha de la publicación en formato dd-MM-yyyy                                    |
| `product_id`   | `int`    | Número identificatorio de un producto asociado a una publicación                 |
| `product_name` | `string` | Cadena de caracteres que representa el nombre de un producto                     |
| `type`         | `string` | Cadena de caracteres que representa el tipo de un producto                       |
| `brand`        | `string` | Cadena de caracteres que representa la marca de un producto                      |
| `color`        | `string` | Cadena de caracteres que representa el color de un producto                      |
| `notes`        | `string` | Cadena de caracteres para colocar notas u observaciones de un producto           |
| `category`     | `int`    | Identificador que sirve para conocer la categoría a la que pertenece un producto |
| `price`        | `double` | Precio del producto                                                              |

#### Obtener listado de publicaciones

Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas

```http
  GET /products/followed/${user_id}/list
```

| Parámetro | Tipo     | Descripción                                                                          |
|:----------|:---------|:-------------------------------------------------------------------------------------|
| `user_id` | `int`    | Id del usuario sobre el cual se realizará la búsqueda de seguidores y sus posteos    |
| `order`   | `string` | **Opcional**. `date_asc` o `date_desc` para orden por fecha ascendente o descendente |