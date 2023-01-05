# Sprint1- wave20- SocialMeli-Individual

Mercado Libre sigue creciendo y tiene como objetivo empezar a implementar una serie de herramientas, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

## proyecto realizado por: 
- Juan Camilo Arango Valle **github: jcamiloarangov**
    - Branch: arangovalle_juancamilo


# Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado mediante **Spring initializr** con la siguiente configuracion:
- Java version: 11
- Maven
- Spring Boot: 2.7.7
- Packaging: Jar

Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.

# Consideraciones generales
- Este readme esta enfocado en la parte inidvidual del desafio del sprint 1, se utilizo como base el desarrollo grupal, adicionando los casos de uso especificados


# Rutas de la aplicacion
| User Story  | Method   | Route   | Description |   By     |
| :---        |    :----:|    :---: |     :---:    |    ---: |
| SU0010 | POST  | products/promo-post |Llevar a cabo la publicación de un nuevo producto en promoción|Juan Camilo Arango Valle  |
| SU0011 | GET  | /products/promo-post/count?user_id={userId} |Obtener la cantidad de productos en promoción de un determinado vendedor|Juan Camilo Arango Valle  |
| SU0012 | GET  | /products/promo-post/list?user_id={userId} |Obtener un listado de todos los productos en promoción de un determinado vendedor|Juan Camilo Arango Valle  |
| SU0013 | GET  | /users/allUsers |Obtener un listado de todos los usuarios de tipo User en el repositorio|Juan Camilo Arango Valle  |
| SU0014 | POST  | /users/newUser |Agrega un nuevo usuario de tipo User en el repositorio|Juan Camilo Arango Valle  |

