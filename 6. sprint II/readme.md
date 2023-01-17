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

## Implementacion de validaciones en los campos de entrada.
- user_id
- id_post
- date
- product_id
- product_name
- type
- brand
- color
- notes
- category
- price

## Implementacion de Test Unitarios y Test de Integracion.

![image](https://user-images.githubusercontent.com/119961027/212745767-a4f0262b-dd4a-4727-9ba2-0812e9181a9f.png)

![image](https://user-images.githubusercontent.com/119961027/212745667-03a8d6b8-6aba-40b6-b459-3d647dd493f5.png)

### Test Unitarios desarrollados grupalmente, dividiendo tareas entre los miembros del equipo: 
*     US 001: followOkTest - Verificar que el usuario a seguir exista.                            Joaquin Pereyra
*     US 002: unfollowOkTest - Verificar que el usuario a dejar de seguir exista.                 Ivan Majewski
*     US 003: followersOrder(Asc/Desc)OkTest - Verificar que el orden exista.                     Gabriela Stocco
*     US 004: followedOrder(Asc/Desc)OkTest - Verificar el ordenamiento ascendente por nombre.    Tammara Trivelli
*     US 005: getPublicationsInvalidOrderTest - Parametro de orden de fecha incorrecto            Emiliano Asprea
*     US 006: getPublicationsOrder(Asc/Desc)OKTest - Verificar que las publicaciones de las ultimas 2 semanas esten ordenadas. Rodrigo Cabrera
*     US 007: followersCountOkTest - Verificar la cantidad de seguidores.                         Desarrollo grupal
*     US 008: getLastTwoWeeksPublicationsOKTest - Verificar que las publicaciones sean de las últimas dos semanas.  Desarrollo grupal

### Test de Integracion desarrollados individualmente.
*     US 009: followOkTest - Verificar que un usuario pueda seguir a otro                         Individual
*     US 010: followersCountOkTes - Verificar que la cantidad de seguidores sea la correcta       Individual
*     US 011: addOkTest - Verificar el correcto funcionamiento de agregar una publicacion         Individual
*     US 012: addPromoOkTest - Verificar el correcto agregado de una publicacion en promocion     Individual

### Coverage del proyecto 79%
![image](https://user-images.githubusercontent.com/119961027/212961572-6896d755-e083-430c-b307-3c5b0d709b2b.png)


Agradecimientos para el equipo de Digital House y los coordinadores del Bootcamp Backend JAVA.
