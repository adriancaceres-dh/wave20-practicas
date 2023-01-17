
# Sprint 2 Social MELI.

### Miembros del equipo.

- **Scrum Master** Johanna Tabella.
- Juan Pablo Ramos Ruiz.

## Descripción.

SocialMeli, la nueva implementación de MercadoLibre que fue realizada por el equipo de desarrollo “Bootcamp” se ha convertido en ¡Todo un éxito!. Dado esto y a que MeLi tiene unos estándares de calidad muy altos con respecto a los productos de software que utiliza, estableció una serie de validaciones que considera que sean necesarias tener en cuenta a la hora de incorporar datos como así también diferentes test unitarios que aseguren el correcto funcionamiento de cada una de las funcionalidades que incluye. Para llevar a cabo estas implementaciones, se deberá tomar como base el proyecto desarrollado de forma grupal en el Sprint Nº 1. A partir de él, se llevarán a cabo cada una de las validaciones y tests unitarios correspondientes.


### Tecnologias usadas.
- Java 11
- JDK 11
- SpringBoot 2.7.7
- Postman
- Maven

### Convenciones.

- Variables en camelCase.
- Código en inglés

### Dependencias.

- Lombok.
- Spring Boot DevTools.
- Spring Web.
- Faker (para generar los Json)
- Model Mapper

### Decisiones de Equipo.

- Un usuario no puede seguirse a si mismo.
- Solo se puede seguir a vendedores.
- Cada post genera un nuevo producto con id único.
- Hay una relación 1-1 de post y producto.
- No se puede tener productos con mismo id
- Se acordó para el próximo sprint implementar el modelo de _Categoria_, utilizando por el momento solo sus Ids.
- Consideramos que un usuario es vendedor si tiene al menos una publicación.
- Al lanzarse excepciones, se mostrará su descripción, código de error y timestamp.

## Test de integración

<table>
<tbody>
<tr style="height: 33px;">
<td style="height: 33px;">&nbsp;</td>
<td style="height: 33px;">
<p><strong>Situaciones de entrada</strong></p>
</td>
<td style="height: 33px;">
<p><strong>Comportamiento Esperado</strong></p>
</td>
</tr>
<tr style="height: 143px;">
<td style="height: 143px;">
<p><strong>Test Integración</strong></p>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Listar usuarios seguidos de un usuario válido </span><strong>(US-0003)</strong></p>
</td>
<td style="height: 143px;">
<p><strong>Se cumple:</strong></p>
<p><span style="font-weight: 400;">
<li>Status Code: 200</li>
<li>Body: Listado de vendedores seguidos por el usuario</li>
</span></p>
<br/>
<p><strong>No se cumple:</strong></p>
<li>Status Code: 404</li>
<li>Body: Detalles del error con un mensaje, código de estado y timestamp</li>
<p><span style="font-weight: 400;">
</span></p>
</td>
</tr>
<tr style="height: 143px;">
<td style="height: 143px;">
<p><strong>Test Bonus</strong></p>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Realizar una publicación válida </span><strong>(US-0005)</strong></p>
</td>
<td style="height: 143px;">
<p><strong>Se cumple:</strong></p>
<p><span style="font-weight: 400;">
<li>Status Code: 201</li>
<li>Body: Datos de la publicación creada.</li>
</span></p>
<br/>
<p><strong>No se cumple:</strong></p>
<li>Status Code: 400</li>
<li>Body: Detalles del error con un mensaje, código de estado, timestamp y campos que ocasionaron el error, de haberlos</li>
<p><span style="font-weight: 400;">
</span></p>
</td>
</tr>
</tbody>
</table>
