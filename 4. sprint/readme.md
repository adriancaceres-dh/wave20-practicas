
# Proyectos Wave 20 - Sprint 1

1 - **PROYECTO GRUPAL** -> ./Parte-grupal/be_java_hisp_w20_g05

Consta de toda la base de el proyecto, el cual personalmente colabore con el US 003 y el diseño de la misma.

US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor.

Endpoint -> /users/{userId}/followers/list

----------------------------------

2 - **PROYECTO INDIVIDUAL** -> ./Parte-Individual/be_java_hisp_w20_g05

* Consta de la US10 y US11 (NO BONUS).
* 
     > Link con pruebas de POSTMAN:
    [Click aqui.](Individual.postman_collection.json)

**US 0010: Llevar a cabo la publicación de un nuevo producto en promoción.**

 
    # Endpoint : /products/promo-post

    La implementacion consiste en registrar un POST pero que esta vez se le setea un descuento 
    a diferencia de los POST que no son promo que se les setea un descuento en 0. 

    Se debe enviar en el cuerpo de el request el siguiente formato:
 
    {
        "user_id": 1,
        "date": "04-02-2023",
        "product": {
            "product_id": 1,
            "product_name": "Silla Gamer 2",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition"
        },
        "category": 100,
        "price": 1500.50,
        "has_promo": true,
        "discount": 1
    }
    
    -> SI EL POST TIENE DESCUENTO, ES UNA PROMO.

    // Logica de la funcion:
    * Si fue seteado has_promo en true y con un descuento mayor a 0, Retorna 200 OK
    * Caso contrario, 400 Bad Request + mensaje de error.
 

**US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor.**

    # Endpoint : /products/promo-post/count?user_id={userId}

    La implementacion consiste en buscar dentro de un vendedor dado, si cuenta con posteos y filtrarlo por los que tengan un descuento > 0.

    -> Se solicita userId, retorna dto con el formato solicitado: 

    {  
    "user_id" : 234,
    "user_name": "vendedor1",
    "promo_products_count": 23
    }

 
    -> Caso contrario, 400 BAD REQUEST + mensaje error.

