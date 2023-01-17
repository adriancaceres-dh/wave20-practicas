# Sprint 2 - wave20 - Tests SocialMeli- Test Integracion
SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## Objetivo
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

## Parte individual
este readme esta enfocado a los test de integracion de la parte individual, en esta parte se realizaron los test del endpoint `/products/post` el cual crea un nuevo producto, así como su excepción y el endpoint `/{userId}/followed/list `el cual obtiene todo los seguidores de un usuario, de igual forma se testeo su exception.
Se logró un coverage del 77%

## Validaciones en campos (Todas las US)
| nombre del test | descripcion |    endpoint         ||
|:---------------|:-------------:|:----------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------:|
| testCreateNewPost        |   Este test de integracion prueba la creacion de un nuevo post mediante el endpoint y un cuerpo de la peticion valido    |  /products/post  | 
| testCreateNewPostException        |   Este test de integracion prueba las validaciones asignadas mediante anotaciones al DTO del post, forzando una excepción   |  /products/post  | 
| testGetFollowed        |   Este test de integracion prueba la obtencion de un usuario especifico y la lista de vendedores a los cuales este sigue     |  /users/{userId}/followed/list  | 
| testGetFollowedExceptionWrongId   |   Este test de integracion prueba el error obtenido cuando el usuario no existe, se comprueba el mensaje de error obtenido   |  /users/{userId}/followed/list  | 
| testCreateNewPostException        |   Este test de integracion prueba las validaciones asignadas mediante anotaciones al endpoint, forzando una excepción   |  /users/{userId}/followed/list | 