
## QUERYS ELASTICSEARCH

#### Get declarando el size
```
GET employee/_search?size=1000
 {
       "query": {
         "match_all": {
           
         }
       }
        
}
```

#### Get sin body. Busca la query en todos los datos 
```
GET employee/_search?q=Janenna
```

#### Busqueda campo específico y operador and 
```
GET employee/_search?q=firstname: Janenna AND lastname: Nance
```
#### Busqueda campo específico y operador or

```
GET employee/_search?q=firstname: Janenna OR lastname: Fidelia
```


#### Busqueda con comparadores 
```
GET employee/_search?q=firstname:(>= Meriel)
```
## 
| Sigla | Descripción                     | |
| :---- | :------------------------------ |:---- |
| GTE | greater than equals () |>=
| GT | greater than |>
| LTE| lesss than esqual |<=
| LT| greater than |< 

## Filtrar por fecha 
```
```
```

GET employee/_search
{
  "query": {
    "bool": {
      "filter": [
        {
          "range": {
            "birthdate": {
              "gte": "1998-02-05",
              "lte": "2002-02-05"
            }
          }
        }
      ]
    }
  }
}
```

## 
| Sigla | Descripción                     | 
| :---- | :------------------------------ |
| must not | debe cumplirse
| must | and
| should| or


## Uso Must Not
```
GET employee/_search
{
  "query": {
    "bool": {
     "must_not": [
        {
          "range": {
            "birthdate": {
              "gte": "1998-02-05",
              "lte": "2002-02-05"
            }
          }
        }
      ]
    }
  }
}
```
## Search en un campo especifico con body 
```
GET employee/_search
{
  "query": {
    "multi_match": {
      "query": "Jean",
      "fields": ["firstname","lastname"]
    }
  }
}
```
#Con should
```
GET employee/_search
{
  "query": {
    "bool": {
      "should": [
        {
          "term": {
            "firstname": {
              "value": "Janenna"
            }
          }
        },
        {
          "term": {
            "lastname": {
              "value": "Leonard"
            }
          }
        }
      ]
    }
  }
}
```
## Con must 
```
GET employee/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "term": {
            "firstname": {
              "value": "Janenna"
            }
          }
        },
        {
          "term": {
            "lastname": {
              "value": "Leonard"
            }
          }
        }
      ]
    }
  }
}
```
❗️Concatenacion mas facil sin body 

## POST: INSERT, UPDATE Y DELETE DE DOCS 
✨ busca si hay un documento con ese id. Si no hay crea uno y después inserta
```
POST employee/_doc
{
   "profession" : "developer",
          "firstname" : "Flor",
          "birthdate" : "1998-03-15",
          "lastname" : "Leonard",
          "email2" : "Flor.Leonard@gmail.com",
          "@timestamp" : "1996-04-02T00:00:00.000-03:00",
          "id" : 605,
          "email" : "Janenna.Leonard@yopmail.com",
          "campo_nuevo": "prueba"
}
````
### GET para ver resultados de POST
```
GET employee/_search?q=firstname:Flor
```
## Caso de update pero por una query 
```
POST employee/_update_by_query
{
  "query": {
    "bool": {
      "filter": [
        {
          "term": {
            "firstname": "Flor"
          }
        }
      ]
    }
  },
   "script":{
     "source": "ctx._source['firstname']='Flor2'"
     , "lang": "painless"
   
  }
}
```
## Delete por id
```
DELETE employee/_doc/zMRF34UBDVcTZlOWoWOd
````

## Varios campos a la vez
```
POST /_bulk
{"create": { "_index": "employee"}}
{"profession": "programador","email2": "Janenna.Cullin@gmail.com","firstname": "Janenna1","birthdate": "1917-03-21","@timestamp": "1917-03-21T00:00:00.000-04:16","id": 936,"email": "Janenna.Cullin@yopmail.com","lastname": "Cullin"}
{"create": { "_index": "employee"}}
{"profession": "programador","email2": "Janenna.Cullin@gmail.com","firstname": "Janenna2","birthdate": "1917-03-21","@timestamp": "1917-03-21T00:00:00.000-04:16","id": 936,"email": "Janenna.Cullin@yopmail.com","lastname": "Cullin"}
{"create": { "_index": "employee"}}
{"profession": "programador","email2": "Janenna.Cullin@gmail.com","firstname": "Janenna3","birthdate": "1917-03-21","@timestamp": "1917-03-21T00:00:00.000-04:16","id": 936,"email": "Janenna.Cullin@yopmail.com","lastname": "Cullin"}
{"create": { "_index": "employee"}}
{"profession": "programador","email2": "Janenna.Cullin@gmail.com","firstname": "Janenna4","birthdate": "1917-03-21","@timestamp": "1917-03-21T00:00:00.000-04:16","id": 936,"email": "Janenna.Cullin@yopmail.com","lastname": "Cullin"}
```





