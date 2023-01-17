# Sprint 2 - wave20 - Tests SocialMeli
SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

## Objetivo
El objetivo de este desafío es aplicar los contenidos dados hasta el momento durante el BOOTCAMP (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requerimientos y documentación técnica.

## Rama principal
Se utilizó como repositorio principal la rama de John Edward Garcia Saavedra **EdwardGs1702**.

## Test de integracion realizados
### coverage alcanzado: 79%
| Código |                            Situaciones de entrada                             |                                                           Comportamiento esperado                                                           |                  Ruta                   |
|:-------|:-----------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------:|
| IT-01  |    Verificar que un usuario peda seguir a un vendedor si los dos existen.     |                                        Permite continuar con normalidad devolviendo un estado de Ok.                                        | /users/users/{userId}/follow/{userIdToFollow} |
| IT-02  |      Verificar que un usuario inexistente no pueda seguir a un vendedor.      |                                                      Se debe devolver un Bad Request.                                                       | /users/users/{userId}/follow/{userIdToFollow} |
| IT-03  |                 Obtener cuantos seguidores tiene un vendedor.                 |                                       Devolver un status OK, el id, nombre y followers del vendedor.                                        |     users/{userId}/followers/count      |
| IT-04  |  Validar que no se pueda devolver los seguidores de un vendedor inexistente.  |                                        Devolver un bad request por la excepcion Not found exception.                                        |     users/{userId}/followers/count      |
| IT-05  |        Validar que se pueda publicar un post cuando este es correcto.         |                                         Devolver un status Ok y mensaje de Post added successfully.                                         |             /products/post              |
| IT-06  | Revisar que no se pueda hacer un post cuando se tienen caracteres especiales. | No debe permitir el post y deve enviar un MethodArgumentNotValidException y un mensaje de que el campo no debe poseer caracteres especiales |             /products/post              |