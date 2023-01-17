# Sprint 2 - wave20 - Tests SocialMeli
SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## Objetivo
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

## Rama grupal
Se utilizó como repositorio principal la rama **grupo8**.

## Proyecto grupal realizado por:
- John Edward Garcia Saavedra **github: EdwardGs1702**
- Juan Camilo Arango Valle **github: jcamiloarangov**
- Julian Atehortua Zapata **github: juatehortua**
- Dimas Hernandez Mendoza **github: dimashernandez14**
- Adrian Isaac Gomez **github: IsaacGmz**
- Luis Francisco López **github: luis-lopezgomez**
- Diego Alejandro Malagon Ruiz **github: DiegoAlejandroMalagon**

## Sección individual realizada por:
- Luis Francisco López **github: luis-lopezgomez**

## Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado a partir del proyecto grupal final del primer sprint: **SocialMeli**.
Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.

## Consideraciones generales
- Solamente se permiten caracteres alfanuméricos en los campos de texto del payload, además de espacios en cada uno.
- El test **T-0008** se realizó sobre el repositorio, no sobre el servicio, debido a que el filtro de las últimas dos semanas se hace directamente en el repo.
- Se agregó la anotación **@Validated** en los controladores para poder validar los **@PathVariable**.
- No se incluyó la validación del campo **id_post**, ya que el mismo no se require como parámetro en ningún endpoint. (Este tema lo comentamos con Adrian Caceres).

## Refactorización
- Se realizó un cambio en el factor de comparación del método **findPostById** en **PostRepositoryImpl**.
  - Ahora se hace una comparación en base a **ChronoUnit.DAYS** y no a **ChronoUnit.WEEKS**.
- Se eliminaron los IF para validar que todos los campos estuvieran presentes en el payload. Se reemplazó esa función mediante las validaciones de cada campo en los DTO.
- Se modificó el constructor de **PostRepositoryImpl** para quitar un argumento innecesario.
- Se renombraron algunas variables.
- Se agregó documentación de **Javadoc** a los métodos de los servicios.

## Colección de Postman
- Además de los endpoints normales, se agregaron 4 endpoints con campos inválidos para probar las validaciones de los mismos, según lo acordado con Adrian Caceres:
  - US-0001 - Negative PathVariable
  - US-0005 - Missing Product Validation
  - US-0005 - Special Character Validation
  - US-0005 - Missing Date Validation

## User Stories
SocialMeli contaba anteriormente con las siguientes User Stories y requerimientos técnicos:

- **US-0001**: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
- **US-0002**: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- **US-0003**: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
- **US-0004**: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
- **US-0005**: Dar de alta una nueva publicación.
- **US-0006**: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
- **US-0007**: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
- **US-0008**: Ordenamiento alfabético ascendente y descendente.
- **US-0009**: Ordenamiento por fecha ascendente y descendente.

## Validaciones en campos (Todas las US)
| Dato/Parámetro | ¿Obligatorio? |                                                             Validación                                                             |                                                        Mensaje de error                                                        |
|:---------------|:-------------:|:----------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------:|
| user_id        |      Si       |                                                Que el campo no esté vacío. Mayor 0                                                 |                                    El  id no puede estar vacío. El id debe ser mayor a cero                                    |
| id_post        |      SI       |                                                Que el campo no esté vacío. Mayor 0                                                 |                               El id_post no puede estar vacío. El id_post debe ser mayor a cero                                |
| date           |      SI       |                                                    Que el campo no esté vacío.                                                     |                                                 La fecha no puede estar vacía.                                                 |
| product_id     |      SI       |                                                Que el campo no esté vacío. Mayor 0                                                 |                                    La id no puede estar vacía. El id debe ser mayor a cero                                     |
| product_name   |      SI       | Que el campo no esté vacío. Longitud máxima de 40 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios. | El campo no puede estar vacío. La longitud no puede superar los 40 caracteres. El campo no puede poseer caracteres especiales. |
| type           |      SI       |          Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)           | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| brand          |      SI       |          Que el campo no esté vacío. Longitud máxima de 25 caracteres. Que no posea caracteres especiales (%, &, $, etc)           | La longitud no puede superar los 25 caracteres. El campo no puede estar vacío. El campo no puede poseer caracteres especiales. |
| color          |      SI       |          Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)           | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| notes          |      NO       |               Longitud máxima de 80 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios.               |                La longitud no puede superar los 80 caracteres. El campo no puede poseer caracteres especiales.                 |
| category       |      SI       |                                                    Que el campo no esté vacío.                                                     |                                                 El campo no puede estar vacío.                                                 |
| price          |      SI       |                                 Que el campo no esté vacío. El precio máximo puede ser 10.000.000.                                 |                         El campo no puede estar vacío. El precio máximo por producto es de 10.000.000                          |

## Tests Unitarios
| Código |                                                                   Situaciones de entrada                                                                   |                                                              Comportamiento esperado                                                               |                           By |
|:-------|:----------------------------------------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------------------------------:|-----------------------------:|
| T-0001 |                                                         Verificar que el usuario a seguir exista.                                                          |                    Se cumple: Permite continuar con normalidad. No se cumple: Notifica la no existencia mediante una excepción.                    | Diego Alejandro Malagon Ruiz |
| T-0002 |                                                     Verificar que el usuario a dejar de seguir exista.                                                     |                    Se cumple: Permite continuar con normalidad. No se cumple: Notifica la no existencia mediante una excepción.                    |      Dimas Hernandez Mendoza |
| T-0003 |                                                  Verificar que el tipo de ordenamiento alfabético exista.                                                  |                    Se cumple: Permite continuar con normalidad. No se cumple: Notifica la no existencia mediante una excepción.                    |     Juan Camilo Arango Valle |
| T-0004 |                                          Verificar el correcto ordenamiento ascendente y descendente por nombre.                                           |                                              Devuelve la lista ordenada según el criterio solicitado                                               |         Luis Francisco López |
| T-0005 |                                                  Verificar que el tipo de ordenamiento por fecha exista.                                                   |                    Se cumple: Permite continuar con normalidad. No se cumple: Notifica la no existencia mediante una excepción.                    |  John Edward Garcia Saavedra |
| T-0006 |                                           Verificar el correcto ordenamiento ascendente y descendente por fecha.                                           |                                       Verificar el correcto ordenamiento ascendente y descendente por fecha.                                       |           Adrian Isaac Gomez |
| T-0007 |                                      Verificar que la cantidad de seguidores de un determinado usuario sea correcta.                                       |                             Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.                              |      Julian Atehortua Zapata |
| T-0008 | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. |                       Grupal |

## Tests de Integración
| Código |                                                Situaciones de entrada                                                 |                                                  Comportamiento esperado                                                   |                   By |
|:-------|:---------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------:|---------------------:|
| T-0009 |           Verificar que se pueda agregar una publicación correctamente tomando en cuenta alguna validación.           |    Se cumple: Permite continuar con normalidad. No se cumple: Notifica por mensaje la validación que se ha de cumplir.     | Luis Francisco López |
| T-0010 |             Verificar que se obtenga un arreglo de posts de los sellers a quien sigue un usuario válido.              |   Se cumple: Permite continuar con normalidad. No se cumple: Notifica que el usuario es inválido mediante una excepción.   | Luis Francisco López |
| T-0011 | Verificar que un usuario pueda seguir a un seller, comprobando la existencia de ambos y que no sean la misma persona. | Se cumple: Permite continuar con normalidad. No se cumple: Notifica el problema sobre los usuarios mediante una excepción. | Luis Francisco López |