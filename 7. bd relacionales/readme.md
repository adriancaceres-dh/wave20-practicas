# 📚 Apuntes sobre tema 📚

## 🎛 Orden de ejecución de las operaciones 🎛
_____

| Prioridad | Operación     |
|-----------|---------------|
| 1         | FROM          |
| 2         | ON            |
| 3         | OUTER         |
| 4         | WHERE         |
| 5         | GROUP BY      |
| 6         | CUBE O ROLLUP |
| 7         | HAVING        |
| 8         | SELECT        |
| 9         | DISTINCT      |
| 10        | ORDER BY      |
| 11        | TOP           |

# 🧮 Soluciones ejercicios 🧮

## 📈 Ejercicio normalización -> Optimización de BD 📈
____

Luego de un análisis realizado en un sistema de facturación, se ha detectado un mal diseño en la base de datos. La misma, 
cuenta con una tabla facturas que almacena datos de diferente naturaleza. Como se puede observar, la tabla cuenta con 
datos que podrían ser normalizados y separados en diferentes entidades.

![Tabla de ejercicio normalización](Ejercicio de normalización/Tabla ejercicio normalización.png)

Se solicita para el escenario anterior:
- Aplicar reglas de normalización y elaborar un modelo de DER que alcance la tercera forma normal (3FN).
- Describir con sus palabras cada paso de la descomposición y aplicación de las reglas para visualizar el planteo realizado.

### ⓵ Normalización en 1FN ⓵

1. La dirección_cliente debe ser atómica a la hora de ser ingresada en la tabla, ya que pueden existir muchas formas
    diferentes de colocar una dirección, es por esto que para una dirección es recomendable separarla de la siguiente manera:
   (calle - numero_casa - barrio(opcional) - numero_apt).
2. El apellido_cliente solo debe tener un campo y no un campo compuesto con todos los apellidos juntos. De lo contrario,
    se debe separar en 1er_apellido - 2do_apellido - ...
3. El nombre_cliente solo debe tener un campo y no un campo compuesto con todos los nombres juntos. De lo contrario,
   se debe separar en 1er_nombre - 2do_nombre - ...

### ⓶ Normalización en 2FN ⓶

1. Separar y crear una nueva tabla para lo que es el nombre y apellido de las personas de la manera:

| id_persona | nombre_cliente  | apellido_cliente  |
|------------|-----------------|-------------------|
| 1          | Emanuel         | Fonseca           |
| 2          | Luis            | Suarez            |

|  id_factura (PK)  |  fecha_factura  | forma_pago | IVA | cantidad | importe | id_persona (FK) | descripcion_articulo   |
|:-----------------:|:---------------:|:----------:|:---:|:--------:|:-------:|:---------------:|------------------------|
|         1         |   2000-10-10    |     1      |  0  |    5     |   12    |        1        | "Compra de alta gama"  |
|         2         |   2000-11-10    |     2      |  5  |    2     |   34    |        2        | "Compra de media gama" |

2. 

### ⓷ Normalización en 2FN ⓷

1. 

