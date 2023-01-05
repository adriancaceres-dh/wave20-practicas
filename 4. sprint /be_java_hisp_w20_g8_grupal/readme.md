# Sprint1- wave20- SocialMeli

Mercado Libre sigue creciendo y tiene como objetivo empezar a implementar una serie de herramientas, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

# Rama principal
Se utilizó como repositorio principal la rama de de John Edward Garcia Saavedra **EdwardGs1702**
## proyecto realizado por:
- John Edward Garcia Saavedra **github: EdwardGs1702** 
- Juan Camilo Arango Valle **github: jcamiloarangov**
- Julian Atehortua Zapata **github: juatehortua**
- Dimas Hernandez Mendoza **github: dimashernandez14**
- Adrian Isaac Gomez **github: IsaacGmz**
- Luis Francisco López **github: luis-lopezgomez**
- Diego Alejandro Malagon Ruiz **github: DiegoAlejandroMalagon**


# Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado mediante **Spring initializr** con la siguiente configuracion:
- Java version: 11
- Maven
- Spring Boot: 2.7.7
- Packaging: Jar

Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.

# Consideraciones generales
- Se utilizó como repositorio principal la rama de John Edward Garcia Saavedra.

- Se utilizaron Sets como estructura principal con el fin de asegurar que los ids sean unicos, se controla mediante el uso de errores.

- Se llegó a un consenso grupal en el cual se decidió que si bien un post tiene un id único, diferentes post pueden tener el mismo producto con el mismo Id de producto.

- No se cuenta con repositorios estaticos, estos son creados con codigo "quemado" o hardcoded code como datos iniciales.

- Los datos ingresados por `@pathVariables` siempre llegarán con el tipado solicitado por lo que no se tendrá en cuenta errores de este tipo en el controlador.

- Al no contar con un repositorio de datos estatico se crearon datos de prueba dentro de los repositorios del proyecto, por lo que los ids del 1-4 fueron asignados a usuarios, mientras que los ids del 5-10 fueron asignados a vendedores.
- Los sellers solo pueden tener seguidores más no pueden seguir otros sellers.


# Rutas de la aplicacion
| User Story  | Method   | Route   | Description |   By     |
| :---        |    :----:|    :---: |     :---:    |    ---: |
| SU0001 | POST  | /users/{userId}/follow/{userIdToFollow}  |Poder realizar la acción de “Follow” (seguir) a un determinado vendedor|Juan Camilo Arango Valle  |
| SU0002      | GET     | /users/{userId}/followers/count  |Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor|Julian Atehortua Zapata  |
| SU0003  | GET  | /users/{userId}/followers/list  |Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)|Diego Alejandro Malagon Ruiz  |
| SU0004  | GET  | /users/{userId}/followed/list  |Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)|Adrian Isaac Gomez|
| SU0005  | POST  | /products/post  |Dar de alta una publicación|Luis Francisco Lopez|
| SU0006  | GET  | /products/followed/{userId}/list | Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas|John Edward Garcia Saavedra|
| SU0007 | POST  | /users/{userId}/unfollow/{userIdToUnfollow} | Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor|Dimas Hernandez Mendoza|
| SU0008 | GET  | /users/{UserID}/followers/list?order=name_asc  /users/{UserID}/followed/list?order=name_desc | Ordenamiento alfabético ascendente y descendente|Grupal|
| SU0009 | GET  | /products/followed/{userId}/list?order=date_asc /products/followed/{userId}/list?order=date_desc| Ordenamiento por fecha ascendente y descendente|Grupal|

# Consideraciones especificas
- SU0002 se crearon datos de prueba en los cuales el seller con id 5 es seguido por el user con id 1, el seller con id 6 es seguido por el user con id 1, el seller 7 es seguido por el user 3, el seller 8 no tiene seguidores, el seller 9 es seguido por los usuarios con id 1, 2 y 3 y el seller 10 es seguido por el usuario 2