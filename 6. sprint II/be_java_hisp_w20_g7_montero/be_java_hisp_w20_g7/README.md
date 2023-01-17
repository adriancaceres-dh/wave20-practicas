# Bootcamp Backend Java Sprint N°2 - Spring

# Grupo 7

## Roadmap

![Logo](https://assets.digitalhouse.com/content/AR/CTD/DESAFIO%20SPRING_Mesa%20de%20trabajo%201.jpg)

## Proyecto individual
- 👩🏻‍💻 [@NathamgML](https://github.com/NathamgML)


## Objetivo

El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing),
haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto,
una especificación de requerimientos y documentación técnica.
## Pautas para la actividad
El desafío que se propone a continuación consta de 2 partes:

#### B. Apartado Individual:
Luego de lograr implementar tests unitarios con todos los miembros del equipo, deberás implementar al menos un test de integración de manera individual.

##  Requerimientos técnicos funcionales (Punto B)

Siguiendo con el principio de que MeLi posee unos estándares de calidad muy altos, un especialista sugirió la posibilidad de contar con la implementación de al menos un test de integración

### Test de Integración 

Se crea un archivo para el test de integración del endpoint que obtiene los datos correspondientes a la cantidad de seguidores que tiene un usuario.

|      | Situaciones de entrada                   | Comportamiento Esperado                   |
|:-----------------|:-----------------------------------------|:------------------------------------------|
| `T-0001`| `Verificar los datos del Get. (US-0002)` | `Mismo userId, userName y followersCount` |

#### C. Bonus:
En caso de que hayas logrado resolver tanto el apartado A de manera grupal como todo el apartado B de forma individual y aún cuentes con tiempo, te invitamos a que propongas otros tests de integración (diferentes al que hayas implementado en el punto B).  No te olvides que este apartado es 100% OPCIONAL y NO OBLIGATORIO.

## Tecnologias Utilizadas

Git, Java, Spring y Testing


#### A. Implementar validaciones y diferentes tests a un escenario determinado (grupal):
A partir de un primer incremento de un escenario conocido (Sprint Nº 1), se deberán establecer distintos procesos de validación de datos y de test unitarios necesarios.


## Miembros del Proyecto

- 👨🏼‍💻 [@manueldiazmeli](https://github.com/manueldiazmeli)
- 👨🏻‍💻 [@TomasGonzalezDev](https://github.com/TomasGonzalezDev)
- 👨🏻‍💻 [@santtury](https://github.com/santtury)
- 👩🏻‍💻 [@NathamgML](https://github.com/NathamgML)
- 👨🏻‍💻 [@JuanSHenao](https://github.com/JuanSHenao)
- 👨🏻‍💻 [@RonaldRosero](https://github.com/RonaldRosero)
- 👩🏻‍💻 [@SoriGonzalezR](https://github.com/SoriGonzalezR)


## Decisiones de Equipo

- Todos los usuarios serán compradores y vendedores así no tengan productos posteados para la venta.
- Todos los usuarios pueden seguirse mutuamente.
- Se agregó hasPromo desde el inicio del desarrollo y se tomó la decisión que se pasaría a falso si no está en
  promoción.


##  Requerimientos técnicos funcionales (Punto A)


#### User Stories
SocialMeli contaba anteriormente con las siguientes User Stories y requerimientos técnicos:



**US-0001:** Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.

**US-0002::** Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.

**US-0003:** Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).

**US-0004:** Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).

**US-0005:** Dar de alta una nueva publicación.

**US-0006:** Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

**US-0007:** Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado.

**US-0008:** Ordenamiento alfabético ascendente y descendente.

**US-0009:** Ordenamiento por fecha ascendente y descendente.

##  Resumen de Datos de entrada (todas las US):


| Datos/Parámetros      | Tipo  | Longitud  | Descripción |
|:-----------------|:------|:-----------------|:--------------------------|
| `userId`         | `Integer` |   |Número que identifica al usuario actual |
| `user_id_to_follow`| `Integer` |   |Número que identifica al usuario a seguir |
| `user_name`         | `String` |  15 |Nombre de usuario asociado a la user_id |
| `followers_count`| `Integer` |   |Cantidad de seguidores|
| `id_post`         | `Integer` |   |Número identificatorio de cada una de las publicaciones|
| `date`         | `LocalDate` |   |Fecha de la publicación en formato dd-MM-yyyy|
| `product_id`  | `Integer` |   |Número identificatorio de cada uno de los productos asociados a una publicación|
| `product_name`| `String` | 40  |Cadena de caracteres que representa el nombre de un producto|
| `type`         | `String` |  15 |Cadena de caracteres que representa el tipo de un producto|
| `brand`| `String` |  25 |Cadena de caracteres que representa la marca de un producto|
| `color` | `String` |  15 |Cadena de caracteres que representa el color de un producto|
| `notes`   | `String` |  80 |Cadena de caracteres para colocar notas u observaciones de un producto|
| `category`| `Integer` |   |Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados|
| `price` | `Double` | 10.000.000 (Max) |Precio del producto|
| `user_id_to_unfollow`| `Integer` |   |Número que identifica al usuario a dejar de seguir|
| `order` | `String` |  15 |Cadena de caracteres que representa el color de un producto|
| `notes`   | `String` |  80 |Establece el ordenamiento. Puede poseer los valores: name_asc, name_desc, date_asc, date_desc|

#### Validaciones en campos (Todas las US):
| Dato/Parámetro    | ¿Obligatorio?| Validación | Mensaje de error |
|:-----------------|:------|:----------------------|----------|
| `userId` | `Si` | - Que el campo no esté vacío - Mayor 0 |-El  id no puede estar vacío.  - El id debe ser mayor a cero|
| `id_post`| `SI` |  - Que el campo no esté vacío - Mayor 0 |- El id_post no puede estar vacío. - El id_post debe ser mayor a cero.
| `date`         | `SI` |  Que el campo no esté vacío. |- La fecha no puede estar vacía.|
| `product_id`| `SI` | - Que el campo no esté vacío - Mayor 0   |- La id no puede estar vacía. -El id debe ser mayor a cero|
| `product_name`| `SI` | - Que el campo no esté vacío. -Longitud máxima de 40 caracteres. - Que no posea caracteres especiales (%, &, $, etc) |- El campo no puede estar vacío. - La longitud no puede superar los 40 caracteres. - El campo no puede poseer caracteres especiales.|
| `type`         | `SI` | - Que el campo no esté vacío. -Longitud máxima de 15 caracteres. - Que no posea caracteres especiales (%, &, $, etc) |- El campo no puede estar vacío. - La longitud no puede superar los 15 caracteres. - El campo no puede poseer caracteres especiales.|
| `brand`  | `SI` | - Que el campo no esté vacío. -Longitud máxima de 25 caracteres. - Que no posea caracteres especiales (%, &, $, etc) |-El campo no puede estar vacío. - La longitud no puede superar los 25 caracteres. - El campo no puede poseer caracteres especiales.|
| `color`| `SI` | - Que el campo no esté vacío.  - Que no posea caracteres especiales (%, &, $, etc), permite espacios. |- El campo no puede estar vacío. - La longitud no puede superar los 15 caracteres. - El campo no puede poseer caracteres especiales.|
| `notes` | `No` | - Longitud máxima de 80 caracteres especiales -Que no posea caracteres especiales (%, &, $, etc), permite espacios. |- La longitud no puede superar los 80 caracteres. - El campo no puede poseer caracteres especiales.|
| `category`| `SI` | - Que el campo no esté vacío. |- El campo no puede estar vacío.|
| `price` | `SI` |  - Que el campo no esté vacío. -El precio máximo puede ser 10.000.000. |- El campo no puede estar vacío. - El precio máximo por producto es de 10.000.000|

#### *Nota: Tener en cuenta que para la devolución de los mensajes de error es recomendable utilizar los status code correspondientes.



#### Tests Unitarios::


|      | Situaciones de entrada | Comportamiento Esperado   | Responsables |
|:-----------------|:------|:------------------------------------------|:------------------------------------------|
| `T-0001`| `Verificar que el usuario a seguir exista. (US-0001)` | `Se cumple:` Permite continuar con normalidad. `No se cumple:` Notifica la no existencia mediante una excepción.| Manuel Alejandro Diaz Isaza y Ronald Esteban Rosero Montana|
| `T-0002` | `Verificar que el usuario a dejar de seguir exista. (US-0007)` |`Se cumple:` Permite continuar con normalidad. `No se cumple:` Notifica la no existencia mediante una excepción. |Manuel Alejandro Diaz Isaza y Ronald Esteban Rosero Montana|
| `T-0003` | `Verificar que el tipo de ordenamiento alfabético exista (US-0008)` | `Se cumple:` Permite continuar con normalidad. `No se cumple:` Notifica la no existencia mediante una excepción. |Tomas Giovanny Gonzalez Romero y Juan Sebastian Henao Ramirez|
| `T-0004` | `Verificar el correcto ordenamiento ascendentey descendente por nombre. (US-0008)` | Devuelve la lista ordenada según el criterio solicitado|Stiven Gonzalez y Sebastian Camilo Anttury Sanchez |
| `T-0005` | `Verificar que el tipo de ordenamiento por fecha exista (US-0009)` |`Se cumple:` Permite continuar con normalidad. `No se cumple:` Notifica la no existencia mediante una excepción.|Soraya Gonzalez y Nathalia Montero Gomez|
| `T-0006` | `Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)` | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)|Soraya Gonzalez y Nathalia Montero Gomez|
| `T-0007` | `Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)` | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario. |Soraya Gonzalez y Nathalia Montero Gomez|
| `T-0008` | `Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006)` | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha.|Soraya Gonzalez y Nathalia Montero Gomez|

##   

#### Agradecimientos: A nuestra queridisima Scrum Master Johanna Tabella ❤️  por apoyo incondicional y a nuestros instructores Martin y Adrian por compartir su conocimiento!! 
