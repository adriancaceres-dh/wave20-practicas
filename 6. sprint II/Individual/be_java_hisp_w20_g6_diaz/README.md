# MeliSocial2
## Sprint 2

## Miembros
* Alejandro Torres
* Augusto Díaz
* Daniel Andres Angel Rojas
* Daniela Villamizar
* David Nuñez
* Diana Parra
* Juan Carlos Ortiz
## Consigna del ejercicio

Debido a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones y diferentes test unitarios que deberán ser empleados para asegurar el correcto funcionamiento de las funcionalidades en SocialMeli.
## Tecnologías
* Java 11
* SpringBoot 2.7.7
* Postman
## Decisiones de equipo
1. Las validaciones y correcciones fueron realizadas de manera oportuna antes de iniciar con los test unitarios.
2. Utilizamos el patrón de diseño "Factory" para la simulación de la data a utilizar en los test.
3. Decidimos que los caracteres especiales serán: (%, &, $, etc).  

## Validaciones
| Dato/Parámetro | ¿Obligatorio? | Validación                                                                                                                         | Mensaje de error                                                                                                               |
|:---------------|:--------------|:-----------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------|
| `user_id`      | SI            | Que el campo no esté vacío. Mayor 0.                                                                                               | El id no puede estar vacío. El id debe ser mayor a cero                                                                        |
| `id_post`      | SI            | Que el campo no esté vacío. Mayor 0                                                                                                | El id_post no puede estar vacío. El id_post debe ser mayor a cero                                                              |
| `date`         | SI            | Que el campo no esté vacío.                                                                                                        | La fecha no puede estar vacía.                                                                                                 |
| `product_id`   | SI            | Que el campo no esté vacío. Mayor 0                                                                                                | La id no puede estar vacía. El id debe ser mayor a cero                                                                        |
| `product_name` | SI            | Que el campo no esté vacío. Longitud máxima de 40 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios. | El campo no puede estar vacío. La longitud no puede superar los 40 caracteres. El campo no puede poseer caracteres especiales. |
| `type`         | SI            | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| `brand`        | SI            | Que el campo no esté vacío. Longitud máxima de 25 caracteres. Que no posea caracteres especiales (%, &, $, etc)                    | La longitud no puede superar los 25 caracteres. El campo no puede estar vacío. El campo no puede poseer caracteres especiales. |
| `color`        | SI            | Que el campo no esté vacío.Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)                     | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| `notes`        | NO            | Longitud máxima de 80 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios.                             | La longitud no puede superar los 80 caracteres. El campo no puede poseer caracteres especiales.                                |
| `category`     | SI            | Que el campo no esté vacío.                                                                                                        | El campo no puede estar vacío.                                                                                                 |
| `price`        | SI            | Que el campo no esté vacío El precio máximo puede ser 10.000.000.                                                                  | El campo no puede estar vacío. El precio máximo por producto es de 10.000.000                                                  |

## Test Unitarios

| TEST      | USER STORY | VERIFICACIÓN                                                                                                                                               | SE CUMPLE                                                                                                                                          | NO SE CUMPLE                                      |
|-----------|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|
| `T-0001`  | `US-0001`  | Verificar que el usuario a seguir exista.                                                                                                                  | Permite continuar con normalidad.                                                                                                                  | Notifica la no existencia mediante una excepción. |
| `T-0002 ` | `US-0007`  | Verificar que el usuario a dejar de seguir exista.                                                                                                         | Permite continuar con normalidad.                                                                                                                  | Notifica la no existencia mediante una excepción. |
| `T-0003 ` | `US-0008`  | Verificar que el tipo de ordenamiento alfabético exista.                                                                                                   | Permite continuar con normalidad.                                                                                                                  | Notifica la no existencia mediante una excepción. |       
| `T-0004 ` | `US-0008`  | Verificar el correcto ordenamiento ascendente y descendente por nombre.                                                                                    | Devuelve la lista ordenada según el criterio solicitado                                                                                            | N/A                                               |
| `T-0005 ` | `US-0009`  | Verificar que el tipo de ordenamiento por fecha exista                                                                                                     | Permite continuar con normalidad.                                                                                                                  | Notifica la no existencia mediante una excepción. |
| `T-0006 ` | `US-0009`  | Verificar el correcto ordenamiento ascendente y descendente por fecha.                                                                                     | Verificar el correcto ordenamiento ascendente y descendente por fecha.                                                                             | N/A                                               |
| `T-0007 ` | `US-0002`  | Verificar que la cantidad de seguidores de un determinado usuario sea correcta.                                                                            | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario.                                                          | N/A                                               |
| `T-0008 ` | `US-0006`  | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. | N/A                                               |
***
Todos los requisitos y/o test unitarios fueron desarrollados de manera grupal.
***

## Test de Integración 
| TEST    | USER STORY | VERIFICACIÓN                                                                                                                   |
|---------|------------|--------------------------------------------------------------------------------------------------------------------------------|
| IT-0001 | US-0002    | Status code correcto, content type adecuado y conteo correcto de seguidores.                                                   |
| IT-0002 | US-0003    | Status code correcto, content type adecuado e información sobre seguidores correcta.                                           |
| IT-0003 | US-0004    | Status code correcto, content type adecuado e información precisa sobre seguidos.                                              |
| IT-0004 | US-0005    | Status code correcto, content type adecuado y se confirma que el contenido de la request sea el mismo que el payload preparado |
## Colección de Postman 

Para el testeo de esta api colocamos a [disposición](https://github.com/alejandrotm20/SocialMeli2/blob/main/be_java_hisp_w20_g6/src/main/resources/static/Validaciones%20DTO%C2%B4s.postman_collection.json) una colección de Postman en formato JSON que se puede encontrar en este proyecto, en el path: **src/java/resources/static/User Tests.postman_collection.json**

## Repositorio original
[Enlace al repo original](https://github.com/alejandrotm20/SocialMeli2)
