
# SocialMeli

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.

En SocialMeli en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

Este proyecto fue realizado tanto de manera grupal como individual. En este caso se presenta el trabajo realizado de manera individual.

## Authors

#### Scrum Master
- Ignacio Feito

#### Developers

- [@efruizz](https://www.github.com/efruizz)
- [@francoalva](https://www.github.com/francoalva)
- [@itornati](https://www.github.com/itornati)
- [@IvanGonWM](https://www.github.com/IvanGonWM)
- [@lbalestrazzi](https://www.github.com/lbalestrazzi)
- [@FlorSicre](https://www.github.com/octokatherine)
- [@MatiasSegoviaML](https://www.github.com/MatiasSegoviaML)
- [@cindyortegapalma](https://www.github.com/cindyortegapalma)

#### Developer

- [@MatiasSegoviaML](https://www.github.com/MatiasSegoviaML)

## Tecnologias Utilizadas

- [Java](https://www.java.com/)
- [SpringBoot](https://spring.io/projects/spring-boot)



## Modelo
- [SocialMeli](https://lucid.app/lucidchart/2259acad-fa27-4b7d-b338-1a7d836a3e1c/edit?viewport_loc=-11%2C-43%2C1579%2C841%2C0_0&invitationId=inv_e65c2102-36f5-4d29-9cd9-9c2ca21f4fa0)
## Alcance

- Este release incluye todas las funcionalidades entregadas en la parte grupal del Sprint 1 + sus respectivos tests y validaciones especificados a lo largo de este documento.

## Decisiones de Equipo

### Refactor
- Agregamos un nuevo DTO para UserFollowedDTO. Anteriormente se utilizaba únicamente UserFollowers.

- Se reorganizó la estructura del proyecto dividiendo las carpetas de los DTO en request y response.

- Se cambio la porción del código relacionada con el ordenamiento en PostService y UserService. En ambos casos las funciones que tenían ordenamiento por fecha (post) y por nombre(User) se revisa, de no ser null que sea nombre o fecha desc o asc, de lo contrario tira una excepción.

- Cambiamos la reponsabilidad de buscar las publicaciones al repositorio y no al servicio. Se pide el id del usuario y desde el repository se devuelven las publicaciones de ese usuario en especifico.


## API Reference
SocialMeli contaba anteriormente con las siguientes User Stories y requerimientos técnicos:
&nbsp;
#### US-0001:
Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
#### US-0002:
Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
#### US-0003:
Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
#### US-0004:
Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
#### US-0005:
Dar de alta una nueva publicación.
#### US-0006:
Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
#### US-0007:
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
#### US-0008:
Ordenamiento alfabético ascendente y descendente.
#### US-0009:
Ordenamiento por fecha ascendente y descendente.

### Resumen de Datos de entrada (todas las US):

| Datos/Parámetros  | Tipo      | Longitud | Descripción                                                                     |
|-------------------|-----------|----------|---------------------------------------------------------------------------------|
| user_id           | Integer   |          | Número que identifica al usuario actual                                         |
| user_id_to_follow | Integer   |          | Número que identifica al usuario a seguir                                       |
| user_name         | String    | 15       | Nombre de usuario asociado a la user_id                                         |
| followers_count   | Integer   |          | Cantidad de seguidores                                                          |
| id_post           | Integer   |          | Número identificatorio de cada una de las publicaciones                         |
| date              | LocalDate |          | Fecha de la publicación en formato dd-MM-yyyy                                   |
| product_id        | Integer   |          | Número identificatorio de cada uno de los productos asociados a una publicación |
| product_name      | String    | 40       | Cadena de caracteres que representa el nombre de un producto                    |
| type              | String    | 15       | Cadena de caracteres que representa el tipo de un producto                      |


### Obligatoriedad de Datos de entrada (todas las US):

| Dato/Parámetro | ¿Obligatorio? | Validación                                                                                                                         | Mensaje de error                                                                                                               |
|----------------|---------------|------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| user_id        | Si            | Que el campo no esté vacío. Mayor 0                                                                                                | El id no puede estar vacío. El id debe ser mayor a cero                                                                        |
| id_post        | SI            | Que el campo no esté vacío. Mayor 0                                                                                                | El id_post no puede estar vacío.El id_post debe ser mayor a cero                                                               |
| date           | SI            | Que el campo no esté vacío.                                                                                                        | La fecha no puede estar vacía.                                                                                                 |
| product_id     | SI            | Que el campo no esté vacío.Mayor 0                                                                                                 | La id no puede estar vacía. El id debe ser mayor a cero                                                                        |
| product_name   | SI            | Que el campo no esté vacío. Longitud máxima de 40 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios. | El campo no puede estar vacío. La longitud no puede superar los 40 caracteres. El campo no puede poseer caracteres especiales. |
| type           | SI            | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| brand          | SI            | Que el campo no esté vacío. Longitud máxima de 25 caracteres. Que no posea caracteres especiales (%, &, $, etc)                    | La longitud no puede superar los 25 caracteres. El campo no puede estar vacío. El campo no puede poseer caracteres especiales. |
| color          | SI            | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%, &, $, etc)                    | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales. |
| notes          | NO            | Longitud máxima de 80 caracteres. Que no posea caracteres especiales (%, &, $, etc), permite espacios.                             | La longitud no puede superar los 80 caracteres. El campo no puede poseer caracteres especiales.                                |
| category       | SI            | Que el campo no esté vacío.                                                                                                        | El campo no puede estar vacío.                                                                                                 |
| price          | SI            | Que el campo no esté vacío. El precio máximo puede ser 10.000.000.                                                                 | El campo no puede estar vacío. El precio máximo por producto es de 10.000.000                                                  |

### Test de integracion:
|        | Situaciones de entrada                                                                                                                                               | Se cumple                                                                                                                                          | No se cumple                                      | Asignado        |
|--------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|-----------------|
| T-0001 | Se verificar poder realizar la acción de “Follow” (seguir) a un determinado vendedor. (US-0001)                                                                                                                  | Permite continuar con normalidad.                                                                                                                  |                -                                  | Matias Federico Segovia |
| T-0003 | Se verificar obtener un listado de todos los usuarios que siguen a un determinado vendedor. (US-0003)                                                                                                         | Permite continuar con normalidad.                                                                                                                  |                            -                      | Matias Federico Segovia |
