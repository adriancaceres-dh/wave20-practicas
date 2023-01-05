Social Meli -- Desarrollado por Equipo 4
Joaquin Pereyra, Martin Gonzalez, Tammara Trivelli, Emiliano Asprea, Ivan Majewski, Gabriela Stocco, Rodrigo Cabrera // Scrum Master Andres Bolognesi

Desarrollo de una API REST para mejorar la experiencia entre compradores y vendedores.
Los compradores podran seguir a sus vendedores favoritos y enterarse de sus posteos de nuevos productos.

Teccnologias Utilizadas: Java 11, Spring Framework(Web, DevTools, Lombok) y Github.

Decidimos trabajar de forma grupal y desarrollamos los primeros 9 requisitos en equipo, recibiendo recomendaciones y feedback constante.
Deciciones funcionales: 
- Req 1:
-- Un usuario no se puede seguir a sí mismo.
-- Un vendedor puede seguir a un vendedor.
-- Un vendedor puede seguir a un comprador.
-- Un comprador puede seguir a un comprador.
-- Retorna el dto del usuario al que siguió con estado 200.

- Req 2:
-- Es un count a la lista de followers del vendedor.

- Req 3:
-- En caso de que no tenga seguidores devuelve una lista vacía.

- Req 4:
-- En caso de no tener seguidos devuelve una lista vacía.

- Req 5:
-- Un vendedor tiene una lista de publicaciones.
-- Un vendedor puede no tener publicaciones.
-- Una publicación si o si tiene un producto únicamente.
-- Categoría es una entidad aparte.
-- Una publicación tiene una categoría, precio, si tiene promo y el descuento correspondiente.
-- Un usuario puede tener varias publicaciones idénticas siempre y cuando el id de la misma sea diferente.
-- En caso de que un producto no exista o el id sea incorrecto devuelve un 400

- Req 7:
-- No se puede dejar de seguirte a ti mismo.
-- No se puede dejar de seguir a un usuario que no existes

- Req 8 & Req 9:
-- Para ordenar se utilizara un request param en la ruta donde especificará el el orden de ordenamiento



Endpoints: Responsable Emiliano Asprea

US 001: 
POST
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


Diagrama UML sprint 1
<img width="866" alt="Captura de pantalla 2022-12-29 a la(s) 15 45 44" src="https://user-images.githubusercontent.com/119961027/209996229-832d4c74-948f-40f8-ba4b-442d76f39a92.png">

Agradecimientos para el equipo de Digital House y los coordinadores del Bootcamp Backend JAVA
