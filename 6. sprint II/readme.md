# Social Meli-II
# Sprint II 

## Desarrollo individual

Luego de lograr implementar tests unitarios con todos los miembros del equip implementé tests de integración de manera individual hasta alcanzar el porcentaje de cobertura del 75%.


## Responsable: 
Gabriela Stocco

## Scrum Master: 
Andres Bolognesi


# Tests de Integración 
## Controlador de las publicaciones

* add -> Se prueba agregar una nueva publicación

* addException -> Se lanza excepción al intentar agregar una publicación vacía

* last2WeeksPublications -> Se prueba buscar las publicaciones de las últimas dos semanas de un usuario

* last2WeeksPublicationsException -> Se lanza excepción al buscar las publicaciones de un usuario inexistente

## Controlador de los usuarios

* follow -> Se prueba que un usuario pueda seguir a un vendedor

* followException -> Se lanza excepción cuando un usuario inválido intenta seguir a un seller inválido

* followersCount -> Se prueba contabilizar los seguidores de un usuario

* followersCountException -> Se lanza excepción cuando se intenta 
contabilizar los seguidores de un usuario con id no válido

* followersCountNullException -> Se lanza excepción cuando se pasa un id vacío e intentar contabilizar sus seguidores

* followers -> Se prueba listar los seguidores de un usuario

* followersException -> Se lanza excepción cuando se intenta listar los seguidores de un usuario no válido

* followed -> Se prueba listar los vendedores seguidos por un usuario

* unfollow -> Se prueba dejas de seguir a un usuario

* unfollowException -> Se lanza excepción cuando se intenta dejar de seguir a un usuario que no forma parte de la lista


# [Diagrama](https://user-images.githubusercontent.com/119961027/209996229-832d4c74-948f-40f8-ba4b-442d76f39a92.png)


# Agradecimientos 
Al equipo de Digital House y los coordinadores del Bootcamp Backend JAVA, al profe Martín por sus clases y a los compañeros del Grupo-4.
