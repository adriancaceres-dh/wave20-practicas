# EJERCICIO DE ZAPATILLAS

## 1 - UTILIZANDO LA CONSOLA SE LEVANTÓ LOS SERVIDORES EN LAS URL 
ELASTIC SEARCH http://localhost:5600
KIBANA http://localhost:9200

## UTILIZANDO POSTMAN:

## CREACIÓN DE INDICE:

PUT: http://localhost:9200/zapatillas

## CHEQUEO:

GET: http://localhost:9200/_cat/indices

## RESPONSE:

yellow open zapatillas                      RZdI5k_NRMipF5vYTRTsjQ 1 1   0     0    226b    226b

## CREACION DE DOCUMENTO:

POST: http://localhost:9200/zapatillas/_doc

PAYLOAD:

{
    "marca": "Nike",
    "talle": 40,
    "edicion_especial": true,
    "nombre": "Jordan",
    "color": "rojo & blanco",
    "cantidad": 10,
    "proveedor": "Nike Argentina"
}

## CONSULTA DE REGISTRO:

GET: http://localhost:9200/zapatillas/_search

## RESPONSE:

{
    "took": 3,
    "timed_out": false,
    "_shards": {
        "total": 1,
        "successful": 1,
        "skipped": 0,
        "failed": 0
    },
    "hits": {
        "total": {
            "value": 1,
            "relation": "eq"
        },
        "max_score": 1.0,
        "hits": [
            {
                "_index": "zapatillas",
                "_type": "_doc",
                "_id": "u8_j34UBwGFuUg8kF9oA",
                "_score": 1.0,
                "_source": {
                    "marca": "Nike",
                    "talle": 40,
                    "edicion_especial": true,
                    "nombre": "Jordan",
                    "color": "rojo & blanco",
                    "cantidad": 10,
                    "proveedor": "Nike Argentina"
                }
            }
        ]
    }
}
