## Ejercicio zapatillas

- Se creó [zapatillas.csv](zapatillas.csv) que contienen distintas zapatillas para importar en elastic search

- Para verificar que se han cargado correctamente, obtendremos todas las zapatillas que sirvan para jugar Golf.

```
curl -XGET "http://localhost:9200/zapatillas/_search" -H 'Content-Type: application/json' -d'
{
  "query": {
    "match": {
      "tipo": "Golf"
    }
  }
}'
```

```json
{
   "took":1,
   "timed_out":false,
   "_shards":{
      "total":1,
      "successful":1,
      "skipped":0,
      "failed":0
   },
   "hits":{
      "total":{
         "value":4,
         "relation":"eq"
      },
      "max_score":1.540445,
      "hits":[
         {
            "_index":"zapatillas",
            "_type":"_doc",
            "_id":"6O3b3oUBp_ssibb8A_JT",
            "_score":1.540445,
            "_source":{
               "marca":"Adidas",
               "codigo":"AD-03",
               "tipo":"Golf",
               "talle":41
            }
         },
         {
            "_index":"zapatillas",
            "_type":"_doc",
            "_id":"6e3b3oUBp_ssibb8A_JT",
            "_score":1.540445,
            "_source":{
               "marca":"Nike",
               "codigo":"NI-03",
               "tipo":"Golf",
               "talle":48
            }
         },
         {
            "_index":"zapatillas",
            "_type":"_doc",
            "_id":"6u3b3oUBp_ssibb8A_JT",
            "_score":1.540445,
            "_source":{
               "marca":"Puma",
               "codigo":"PU-03",
               "tipo":"Golf",
               "talle":36
            }
         },
         {
            "_index":"zapatillas",
            "_type":"_doc",
            "_id":"6-3b3oUBp_ssibb8A_JT",
            "_score":1.540445,
            "_source":{
               "marca":"Topper",
               "codigo":"TO-03",
               "tipo":"Golf",
               "talle":50
            }
         }
      ]
   }
}
```