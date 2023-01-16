# Social Meli

## Sprint II
## Scrum Master: 
Andres Bolognesi
## Participantes: 
Joaquin Pereyra, Martin Gonzalez, Tammara Trivelli, Emiliano Asprea, Ivan Majewski, Gabriela Stocco, Rodrigo Cabrera

## Tecnologías Utilizadas: 
Java 11, Maven, Spring Framework(Web, DevTools, Lombok), JUnit5, Mockito y Github.

## Descripción de la API
Desarrollo de una API REST para mejorar la experiencia entre compradores y vendedores.
Los compradores podran seguir a sus vendedores favoritos y enterarse de sus posteos de nuevos productos.

## Implementacion de Test Unitarios y Test de Integracion.

### Test Unitarios desarrollados grupalmente, dividiendo tareas entre los miembros del equipo: 
*     US 001: followOkTest - Verificar que el usuario a seguir exista.                            Joaquin Pereyra
*     US 002: unfollowOkTest - Verificar que el usuario a dejar de seguir exista.                 Ivan Majewski
*     US 003: followersOrderOkTest - Verificar que el orden exista.                               Gabriela Stocco
*     US 004: followedOrderOkTest - Verificar el ordenamiento ascendente por nombre.              Tammara Trivelli
*     US 005: getPublicationsInvalidOrderTest - Parametro de orden de fecha incorrecto            Emiliano Asprea
*     US 006: getPublicationsOrder(Asc/Desc)OKTest - Verificar que las publicaciones de las ultimas 2 semanas esten ordenadas. Rodrigo Cabrera
*     US 007: followersCountOkTest - Verificar la cantidad de seguidores.                                                      Desarrollo grupal
*     US 008: getLastTwoWeeksPublicationsOKTest - Verificar que las publicaciones sean de las últimas dos semanas.             Desarrollo grupal


### [Endpoints](https://github.com/adriancaceres-dh/wave20-practicas/files/10354848/3.b.W20.-.Esp.de.Req.tecnicos.funcionales.-.Sprint.N.1.-.Spring.docx.pdf): Responsable Emiliano Asprea

US 001: POST
- /users/{userId}/follow/{userIdToFollow}

US 002: GET
- /users/{userId}/followers/count

US 003: GET
- /users/{userId}/followers/list

US 004: GET
- /users/{userId}/followed/list

US 005: POST
- /products/post

US 006: GET
- /products/followed/{userId}/list

US 007: POST
- /users/{userId}/unfollow/{userIdToUnfollow}

USS 08: GET
- /users/{UserID}/followers/list?order=name_asc
- /users/{UserID}/followers/list?order=name_desc
- /users/{UserID}/followed/list?order=name_asc
- /users/{UserID}/followed/list?order=name_desc

USS 009: GET
- /products/followed/{userId}/list?order=date_asc
- /products/followed/{userId}/list?order=date_desc

USS 0010: POST
- /products/promo-post

USS 0011: GET
- /products/promo-post/count?user_id={userId}

US 0012: GET
- /products/promo-post/list?user_id={userId}

USS BONUS: GET
- /products/list

Diagrama UML sprint 1
<img width="866" alt="Captura de pantalla 2022-12-29 a la(s) 15 45 44" src="https://user-images.githubusercontent.com/119961027/209996229-832d4c74-948f-40f8-ba4b-442d76f39a92.png">

Agradecimientos para el equipo de Digital House y los coordinadores del Bootcamp Backend JAVA.
