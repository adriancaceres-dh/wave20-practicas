# **Sprint 2 - Wave20 - Tests SocialMeli - Test Integracion**
- SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## **Parte Individual Realizada Por**
- Dimas Hernández Mendoza.

## **Objetivo**
- El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

## **Parte individual**
- Este readme esta enfocado a los test de integracion de la parte individual, en esta parte se realizaron los test del endpoint `/{userId}/unfollow/{userIdToUnfollow}` el cual deja de seguir a un vendedor.
Se logró un coverage del **63%.**

## **Bonus**
- Se implementó 3 test de integracion adicional debido a que el porcentaje del coverage no cumplia con lo propuesto en la documentación del proyecto.

- **Agregar un nuevo seguidor**

- **Listar todos los vendedores seguidos por un usuario**

- **Crear un nuevo seguidor**

**Nota:** Luego de realizar los 3 test de integracion **Bonus** se logró obtener un coverage con el **81%** de cobertura en el número de líneas probadas en el proyecto.


## **Validaciones en campos (Todas las US)**
| Nombre del test | Descripcion |    Endpoint         ||
|:---------------|:-------------:|:----------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------------------------------------:|
| T-0001 -> Add new follower integration test.       |   Este test de integracion prueba la  acción de agregar un nuevo seguidor mediante el endpoint y un id válido. | /users/users/{userId}/follow/{userIdToFollow} | 
| T-0002 -> Unfollow a user integration test.       |   Este test de integracion prueba la acción de dejar de seguir a un determinado usuario mediante el endpoint y un id válido.     |  /users/{userId}/unfollow/{userIdToUnfollow} | 
| T-0003 -> List of all vendors followed by a given user integration test.      |   Este tes de integración prueba la acción de obtener un usuario especifico y la lista de vendedores a los cuales este sigue.    |  /users/{userId}/followed/list  | 
| T-0004 -> Create post integration test  |   Este test de integracion prueba la acción de crear un nuevo post mediante el endpoint y el cuerpo de la petición válido   |  /products/post  | 


## **Nota Aclaratoria Test Integración**
- Se realizó un sólo commit el cúal contenia todos los test de integración realizados.
- Los test realizados son los denominados **Camino Feliz.**
- No se realizó test para las excepciones.
