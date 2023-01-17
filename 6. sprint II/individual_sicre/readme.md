
# SocialMeli

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano. 

En SocialMeli en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.
## Authors

#### Scrum Master
- Ignacio Feito

#### Developers 
- [@FlorSicre](https://www.github.com/octokatherine)

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

### Convenciones grupales
- Agregamos la validación @NotBlank al user_nama en el DTO de user para que no se pueda pasar un string en blanco.

- Agregamos las validaciones de las longitud que solo estaban especificadas en la tabla de resumen de datos de entrada pero no en validaciones en campos.

## API Reference
#### Test de integracion 

```
  GET /users/{userId}/followers/count
```

| Parameter |  Description                |
| :-------- | :------------------------- |
| Verifico la devolucion de un UserFollowerCountDTO |  ** Test de integración US-0002 |

#### Get item

```
  GET /users/{userId}/followers/count
```

| Parameter | Description                       |
| :-------- | :-------------------------------- |
| Verifico el funcionamiento de excepción NotFoundException | ** Test de integración US -0002|

#### Descrición de la US-0002

Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor




 



                                         

