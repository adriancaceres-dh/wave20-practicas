# Social Meli

Desarrollo de una API REST para mejorar la experiencia entre compradores y vendedores. Los compradores podrán seguir a sus vendedores favoritos y enterarse de sus publicaciones de nuevos productos.

## Desarrollo individual
Responsable: Stocco Gabriela

User GitHub: Gabi-S 

Se desarrollaron las user stories 0010, 0011 y el bonus 0012.

## Requerimientos
**US 0010:** Llevar a cabo la publicación de un nuevo producto en promoción.

**US 0011:** Obtener la cantidad de productos en promoción de un determinado vendedor

**BONUS!**

**US 0012:** Obtener un listado de todos los productos en promoción de un determinado vendedor.

## Endpoints - Payloads - Responses

## **US 0010: POST**
**Endpoint**

/products/promo-post

**Payload**
```bash
{
    "user_id": 1,
    "date": "29-04-2021",
    "product": {
        "product_id": 4,
        "product_name": "Notebook ",
        "color": "Purple",
        "notes": "last generation ",
        "type": "Full hd",
        "brand": "Dell"
    },
    "category": 10,
    "price": 1055.50,
    "hasPromo" : true,
    "discount": 0.65
}
```
**Response**

Status Code 200 (OK)
```bash
{
    "user_id": 3,
    "date": "29-04-2021",
    "product": {
        "product_id": 4,
        "product_name": "Notebook ",
        "color": "Purple",
        "notes": "last generation ",
        "type": "Full hd",
        "brand": "Dell"
    },
    "category": 10,
    "price": 1055.50,
    "hasPromo" : true,
    "discount": 0.65
}
```
Status Code 400 (Bad request)


## **US 0011: GET**

**Endpoint**

/products/promo-post/count?user_id={userId}

**Response**
```bash
{
    "user_id": 1,
    "user_name": "rodri",
    "promo_products_count": 1
}

```
## **US 0012: GET**

**Endpoint**

/products/promo-post/list?user_id={userId}


**Response**

```bash

{
    "user_id": 1,
    "user_name": "rodri",
    "posts": [
        {
            "user_id": 1,
            "post_id": 0,
            "date": "29-04-2021",
            "product": {
                "product_id": 4,
                "product_name": "Notebook ",
                "color": "Purple",
                "notes": "last generation ",
                "type": "Full hd",
                "brand": "Dell"
            },
            "category": 10,
            "price": 1055.5,
            "hasPromo": true,
            "discount": 0.65
        }
    ]
}

```
## Agradecimientos
Al Grupo-4 quienes brindaron de forma espontánea sus conocimientos y experiencias siempre velando por el avance grupal y el alcance de todos los requerimientos.

Especial agradecimiento a Johanna Tabella y a Andrés Bolognesi quienes me ayudaron con inconvenientes técnicos y de configuración de la computadora.



[Diagrama](https://user-images.githubusercontent.com/119961027/209996229-832d4c74-948f-40f8-ba4b-442d76f39a92.png)
