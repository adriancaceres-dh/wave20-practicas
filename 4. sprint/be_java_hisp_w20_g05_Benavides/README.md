# Bootcamp Sprints: Grupo 5

## Miembros del proyecto

- Gonzalo Barreiro
- Luciano Benavides
- Iván Cano
- Nicolás Chiesa
- José Drozd
- Andrea Ruiz
- Santiago Valdez

## Breve Descripción

El objetivo de este sprint es aplicar los contenidos dados hasta el momento durante el BOOTCAMP MeLi (Git, Java y Spring), con la finalidad de poder implementar una API REST que permita a vendedores y compradores interactuar en un espacio similar a una red social, en el escenario que se plantea a continuación.

## Escenario planteado

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.

La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.

### Sprint 1

Se plantea creación de una API Rest que permita:

1. Poder realizar la acción de “Follow” (seguir) a un determinado usuario
2. Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
3. Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
4. Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
5. Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
6. Dar de alta una nueva publicación.
7. Obtener un listado de las publicaciones realizadas en las últimas dos semanas, por los vendedores que un usuario sigue (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
8. (Individual) Agregar un producto con descuento
9. (individual) Retornar la cantidad de productos con descuento de un determinado usuario.
10. (Individual) Retornar los posteos de un usuario con descuentos.
## Metodología de trabajo

El trabajo consistió de 2 estapas claramente diferentes:
- una etapa grupal, en la que se acordó el diseño y se implementó el scaffolding del proyecto.
- una división de tareas por US, que cada miembro del equipo implementó de manera individual, aunque siempre recurriendo a la ayuda de otros miembros.

### Tecnologías utilizadas

Para llevar adelante esta metodología de trabajo, se recurrió a la herramienta de control de versiones Git, y la plataforma en la nube GitHub, lo cual nos permitió trabajar cada uno en las partes asignadas, pudiendo compaginar todo en un solo proyecto, y a su vez afianzar conocimientos en el uso de esta herramienta tan extendida en el mundo del desarrollo.

Para el proyecto se recurrió al lenguaje de programación Java, y el framework Spring, integrando todos los conocimientos vistos a lo largo del Bootcamp en estas tecnologías, así como en el paradigma de programación orientada a objetos, sus principios y patrones de desarrollo.

Para las pruebas de los Endpoints se utilizo *Postman*, una herramienta que permite comprobar el correcto funcionamiento de las API implementadas.

### Diseño

El diseño del proyecto está basado en la arquitectura multicapa vista durante el Bootcamp: capa de controlador, capa de servicios, capa de repositorios, modelado de objetos y DTO de los mismos. Este diseõ no solo pone en práctica los conceptos vistos a lo largo de la capacitación; también hace uso de la arquitectura MVC de Spring, aprovechando el contenedor IOC y la inyección de dependencias a través de anotaciones.

El modelo diseñado incluye 3 objetos: Usuario, Publicación y Producto. Inicialmente se consideró la posibilidad de diseñar una abstracción de usuario que generalizara a los objetos Vendedor y Comprador. Sin embargo, nos decantamos por un modelo similar al que utiliza MELI en la actualidad, en el que cualquier usuario puede ser vendedor y comprador, por lo que, al no hacer distinciones entre estos, no fue necesaria las clases específicas.

La siguiente figura muestra el diagrama UML:

![UML Diagram](be_java_hisp_w20_g05-UML.png)

### Implementación

Una vez acordado el modelo, se implementó el scaffolding del proyecto, el cual incluyó los paquetes y las clases base. Se crearon los paquetes *controller*, *service*, *repository*, *model*, *dto* y *exception*.

Se crearon clases de Usuario y Servicio para las capas de controlador, servicio y repositorio, así como las clases de Usuario, Publicación y Producto. A medida que se fueron implementando las API solicitadas se fueron creando los DTO necesarios para su correcto funcionamiento.

### Pruebas

Cada miembro del equipo fue responsable por la implementación de una US, y por las pruebas de funcionamiento necesarias, para lo cual se valió de la herramienta *Postman*. La colección de pruebas realizadas se muestra en el [siguiente archivo.](postman_collection.json)

### Agradecimientos

En primer lugar, los miembros argentinos del grupo agradecen a Lionel Messi por traer la copa.

En segunda instancia, agradecer a nuestro Scrum Master, Adrián Cáceres, así como a Johanna Tabella y el resto del equipo de Digital House por su disposición y paciencia a lo largo del Bootcamp.