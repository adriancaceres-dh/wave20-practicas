# Sprint 2 - wave20 - Tests SocialMeli
SocialMeli se ha convertido en todo un éxito. Mercado Libre estableció una serie de validaciones necesarias a tener en cuenta, como así también diferentes test unitarios y de integración que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye.

# Rama principal
Se utilizó como repositorio principal la rama de John Edward Garcia Saavedra **EdwardGs1702**.

## Proyecto realizado por:
- John Edward Garcia Saavedra **github: EdwardGs1702**
- Juan Camilo Arango Valle **github: jcamiloarangov**
- Julian Atehortua Zapata **github: juatehortua**
- Dimas Hernandez Mendoza **github: dimashernandez14**
- Adrian Isaac Gomez **github: IsaacGmz**
- Luis Francisco López **github: luis-lopezgomez**
- Diego Alejandro Malagon Ruiz **github: DiegoAlejandroMalagon**


# Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado a partir del proyecto grupal final del primer sprint: **SocialMeli**.
Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.

# Consideraciones generales
- Solamente se permiten caracteres alfanuméricos en los campos de texto del payload, además de espacios en cada uno.
- El test **T-0008** se realizó sobre el repositorio, no sobre el servicio, debido a que el filtro de las últimas dos semanas se hace directamente en el repo.
- Se agregó la anotación **@Validated** en los controladores para poder validar los **@PathVariable**.

## Refactorización
- Se realizó un cambio en el factor de comparación del método **findPostById** en **PostRepositoryImpl**.
  - Ahora se hace una comparación en base a **ChronoUnit.DAYS** y no a **ChronoUnit.WEEKS**.
- Se eliminaron los IF para validar que todos los campos estuvieran presentes en el payload. Se reemplazó esa función mediante las validaciones de cada campo en los DTO.
- Se modificó el constructor de **PostRepositoryImpl** para quitar un argumento innecesario.
- Se renombraron algunas variables.

# Tests Unitarios
| Código |                                                                   Situaciones de entrada                                                                   |                           By |
|:-------|:----------------------------------------------------------------------------------------------------------------------------------------------------------:|-----------------------------:|
| T-0001 |                                                         Verificar que el usuario a seguir exista.                                                          | Diego Alejandro Malagon Ruiz |
| T-0002 |                                                     Verificar que el usuario a dejar de seguir exista.                                                     |      Dimas Hernandez Mendoza |
| T-0003 |                                                  Verificar que el tipo de ordenamiento alfabético exista.                                                  |     Juan Camilo Arango Valle |
| T-0004 |                                          Verificar el correcto ordenamiento ascendente y descendente por nombre.                                           |         Luis Francisco López |
| T-0005 |                                                  Verificar que el tipo de ordenamiento por fecha exista.                                                   |  John Edward Garcia Saavedra |
| T-0006 |                                           Verificar el correcto ordenamiento ascendente y descendente por fecha.                                           |           Adrian Isaac Gomez |
| T-0007 |                                      Verificar que la cantidad de seguidores de un determinado usuario sea correcta.                                       |      Julian Atehortua Zapata |
| T-0008 | Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. |                       Grupal |
