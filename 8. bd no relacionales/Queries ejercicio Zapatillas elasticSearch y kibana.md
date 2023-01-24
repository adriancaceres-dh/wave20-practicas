## Queries ejercicio zapatillas!

GET zapatillas/_search?size=12
{
  "query": {
    "match_all": {}
  }
}

PUT zapatillas
{
  "mappings": {
    "properties": {
      "nombre":{
        "type": "text"
      }
    }
  }
  
}

POST zapatillas/_doc
{
  "nombre": "Nike Jordan"
}

GET zapatillas/_search
{
  "query": {
    "match": {
      "nombre": "%Nike%"
    }
  }
}
GET zapatillas/_search
{
  "query": {
    "match": {
      "_id": "QoXy5YUBjy3RXSVOcqls"
    }
  }
}
POST zapatillas/_doc/QoXy5YUBjy3RXSVOcqls
{
  "nombre": "Nike Dunk v2"
}
DELETE zapatillas/_doc/Q4Xz5YUBjy3RXSVOD6mz

