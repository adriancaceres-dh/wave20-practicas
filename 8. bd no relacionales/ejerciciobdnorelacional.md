# Ejercicio tienda de zapatos

Se crea el index mediante postman accediendo a la url
`http://localhost:9200/shoes_shop`y se envia la estructura de la base de datos en formato JSON de la siguiente forma, mediante el metodo **PUT**

    {
        "mappings":{
            "properties":{
                "id":{
                        "type":"integer"
                },
                "model":{
                    "type":"text"
                },
                "color":{
                    "type":"text"
                },
                "brand":{
                    "type":"text"
                },
                "size":{
                    "type":"text"
                },
                "price":{
                    "type":"double"
                },
                "stock":{
                    "type":"integer"
                }
            }
        }
    }

Una vez creado el indice se enviaron datos de 2 formas, la primera fue un documento a la vez de la siguiente forma:

        POST shoes_shop/_doc
        {"id":1,
        "model":"Jordan air1",
        "color":"Black&White", 
        "brand":"Nike",
        "size":"38", 
        "price": 550.0,
        "stock":10
        } 

o de forma masiva mediante un _bulk:

        POST /_bulk
        {"create": { "_index": "shoes_shop"}}
        {"id":2,"model":"Jordan airI","color":"Red&White", "brand":"Nike","size":"39", "price": 250.0,"stock":10}
        {"create": { "_index": "shoes_shop"}}
        {"id":3,"model":"Jordan airII","color":"Blue", "brand":"Nike","size":"37", "price": 350.0,"stock":5}
        {"create": { "_index": "shoes_shop"}}
        {"id":4,"model":"Nike Air Max 90","color":"Crimson", "brand":"Nike","size":"39", "price": 150.0,"stock":20}
        {"create": { "_index": "shoes_shop"}}
        {"id":5,"model":"Nike Blazer Mid 70","color":"Green", "brand":"Nike","size":"40", "price": 50.0,"stock":50}
        {"create": { "_index": "shoes_shop"}}
        {"id":6,"model":"Adidas Samba","color":"Black&White", "brand":"Adidas","size":"40", "price": 50.0,"stock":50}
        {"create": { "_index": "shoes_shop"}}
        {"id":7,"model":"Adidas OZelia","color":"light green", "brand":"Adidas","size":"38", "price": 150.0,"stock":20}
        {"create": { "_index": "shoes_shop"}}
        {"id":8,"model":"Adidas Yeeze","color":"gray", "brand":"Adidas","size":"38", "price": 1150.0,"stock":15}
        {"create": { "_index": "shoes_shop"}}
        {"id":9,"model":"Adidas Munchen","color":"Brown&Orange", "brand":"Adidas","size":"38", "price": 150.0,"stock":20}
        {"create": { "_index": "shoes_shop"}}
        {"id":10,"model":"Adidas Mid","color":"White&Orange", "brand":"Adidas","size":"41", "price": 250.0,"stock":25}
        {"create": { "_index": "shoes_shop"}}
        {"id":11,"model":"Vans Authentic","color":"Black&Orange", "brand":"Vans","size":"38", "price": 250.0,"stock":20}
        {"create": { "_index": "shoes_shop"}}
        {"id":12,"model":"Vans Era","color":"Black&White", "brand":"Vans","size":"40", "price": 150.0,"stock":30}
        {"create": { "_index": "shoes_shop"}}
        {"id":13,"model":"Vans Old Skool","color":"Black&White", "brand":"Vans","size":"35", "price": 100.0,"stock":35}
        {"create": { "_index": "shoes_shop"}}
        {"id":14,"model":"Vans Sk8-Hi","color":"Black&White", "brand":"Vans","size":"35", "price": 100.0,"stock":35}
        {"create": { "_index": "shoes_shop"}}
        {"id":15,"model":"Vans Trek","color":"MultiColor", "brand":"Vans","size":"35", "price": 55.0,"stock":55}

Finalmente se realizaron algunas querys para comprobar los datos agregaods

    #Obtener todos los registros
    GET shoes_shop/_search?size=1000
    {
    "query": {
        "match_all": {
        }
    }
    }

    #querys para obtener datos
    GET shoes_shop/_search?q=brand: vans

    GET shoes_shop/_search
    {
    "query":{
        "multi_match": {
        "query": "Black",
        "fields": ["color"]
        }
    }
    }