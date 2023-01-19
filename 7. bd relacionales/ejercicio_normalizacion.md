```mermaid
erDiagram
    facturas ||--|{ articulos_comprados : tiene
    facturas }o--|| clientes : pertenece
    facturas }o--|| formas_de_pago : tiene
    facturas {
        INT id PK
        DATE fecha
        INT id_forma_de_pago FK
        DECIMAL iva
        DECIMAL importe
        INT id_cliente FK
    }

    articulos_comprados {
        INT id PK
        INT id_factura FK
        INT id_articulo FK
        INTEGER cantidad
    }

    articulos ||--o{ articulos_comprados : pertenece
    articulos {
        INT id PK
        DECIMAL precio_base
        VARCHAR[40] descripcion
    }

    formas_de_pago {
        INT id PK
        DECIMAL codigo
        VARCHAR[40] nombre
    }

    clientes {
        INT id PK
        VARCHAR[40] nombre
        VARCHAR[40] apellido
        VARCHAR[40] direccion
    }
```

## Decisiones:
#### Facturas
- Decidí conservar en la tabla factura las columnas directamente relacionadas con la misma.
- Agregué las `FK` a las nuevas tablas.

#### Artículos comprados
- En el caso de los artículos considero que es algo que debería persistirse aparte,
puesto que un artículo en sí es algo que puede repetirse en varias facturas y
una factura puede tener varios artículos. Para representar esto cree la tabla intermedia
`articulos_comprados` que además indica la cantidad comprada.

#### Artículos
- La tabla `articulos` con la descripción que se mostraba en la tabla desnormalizada.
- Agregué la columna precio base, que tendría bastante sentido en este dominio.

#### Formas de pago
- Consideré que las formas de pago disponibles deberían persistirse para mantener mayor
consistencia.
- Agregué una columna nombre que describe la forma de pago.
- Agregué un código haciendo referencia a la columna que antes se encontraba en la factura
debido a que desconozco si hay algún estandar de ese estilo para identificar medios de pago/para
poder mantener la API previa.

#### Clientes
- La tabla `clientes` contiene todos los datos de los clientes a quienes pertenecen las facturas.