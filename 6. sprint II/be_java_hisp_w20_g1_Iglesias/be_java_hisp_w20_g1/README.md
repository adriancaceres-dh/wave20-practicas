
# Sprint 2 Social MELI.

### Miembros del equipo.

- **Scrum Master** Johanna Tabella.
- Agustin Iglesias.
- Esteban Jose Demarchi.
- Facundo Andres Ruiz.
- Francisco Nicolas Berthet Cosentino.
- Juan Pablo Ramos Ruiz.
- Karen Hoffman.
- Lautaro Walsh.
- Armando Burdiles.

## Descripción.

Mercado Libre sigue creciendo y para el año que viene  tiene como objetivo empezar a implementar una serie de herramientas que permitan a los compradores y vendedores tener una experiencia totalmente innovadora, en donde el lazo que los una sea mucho más cercano.
La fecha de lanzamiento se aproxima, por lo cual es necesaria la presentación de una versión Beta de lo que va a ser conocido como “SocialMeli”, en donde los compradores van a poder seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos posteen.


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

## Validaciones

Se agregaron las siguientes validaciones a los Dto de request

<table>
<tbody>
<tr>
<td>
<p><strong>Dato/Par&aacute;metro</strong></p>
</td>
<td>
<p><strong>&iquest;Obligatorio?</strong></p>
</td>
<td>
<p><strong>Validaci&oacute;n</strong></p>
</td>
<td>
<p><strong>Mensaje de error</strong></p>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">user_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">Si</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Mayor 0</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El&nbsp; id no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El id debe ser mayor a cero</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">id_post</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Mayor 0</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El id_post no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El id_post debe ser mayor a cero</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">date</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">La fecha no puede estar vac&iacute;a.</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">product_id</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Mayor 0</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">La id no puede estar vac&iacute;a.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El id debe ser mayor a cero</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">product_name</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Longitud m&aacute;xima de 40 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que no posea caracteres especiales (%, &amp;, $, etc), permite espacios.</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">La longitud no puede superar los 40 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede poseer caracteres especiales.</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">type</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Longitud m&aacute;xima de 15 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que no posea caracteres especiales (%, &amp;, $, etc)&nbsp;</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">La longitud no puede superar los 15 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede poseer caracteres especiales.</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">brand</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Longitud m&aacute;xima de 25 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que no posea caracteres especiales (%, &amp;, $, etc)&nbsp;</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">La longitud no puede superar los 25 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede poseer caracteres especiales.</span></li>
</ul>
<br /><br /><br /></td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">color</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Longitud m&aacute;xima de 15 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que no posea caracteres especiales (%, &amp;, $, etc)</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">La longitud no puede superar los 15 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede poseer caracteres especiales.</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">notes</span></p>
</td>
<td>
<p><span style="font-weight: 400;">NO</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Longitud m&aacute;xima de 80 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que no posea caracteres especiales (%, &amp;, $, etc), permite espacios.</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">La longitud no puede superar los 80 caracteres.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede poseer caracteres especiales.</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">category</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o.</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede estar vac&iacute;o.</span></li>
</ul>
</td>
</tr>
<tr>
<td>
<p><span style="font-weight: 400;">price</span></p>
</td>
<td>
<p><span style="font-weight: 400;">SI</span></p>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">Que el campo no est&eacute; vac&iacute;o</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El precio m&aacute;ximo puede ser 10.000.000.</span></li>
</ul>
</td>
<td>
<ul>
<li style="font-weight: 400;"><span style="font-weight: 400;">El campo no puede estar vac&iacute;o.</span></li>
<li style="font-weight: 400;"><span style="font-weight: 400;">El precio m&aacute;ximo por producto es de 10.000.000</span></li>
</ul>
</td>
</tr>
</tbody>
</table>

Hemos definido mostrar todas las validaciones errones cuando se lanza _MethodArgumentNotValidException_

Por ejemplo

```json
{
  "message": "Campos inválidos o faltantes",
  "status": 400,
  "timestamp": "2023-01-16T09:30:21.563110",
  "invalid_validations": [{
    "field": "userId",
    "rejected_value": "0",
    "reason": "El id debe ser mayor a 0"
  },
    {
      "field": "product.color",
      "rejected_value": "Red & Black",
      "reason": "El campo no puede poseer caracteres especiales."
    },
    {
      "field": "price",
      "rejected_value": "1.500123123213231E15",
      "reason": "El precio máximo por producto es de 10.000.000"
    }
  ]
}
```

## Test unitarios

<table>
<tbody>
<tr style="height: 33px;">
<td style="height: 33px;">&nbsp;</td>
<td style="height: 33px;">
<p><strong>Responsables</strong></p>
</td>
<td style="height: 33px;">
<p><strong>Situaciones de entrada</strong></p>
</td>
<td style="height: 33px;">
<p><strong>Comportamiento Esperado</strong></p>
</td>
</tr>
<tr style="height: 143px;">
<td style="height: 143px;">
<p><strong>T-0001</strong></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Francisco Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles</span></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Verificar que el usuario a seguir exista. </span><strong>(US-0001)</strong></p>
</td>
<td style="height: 143px;">
<p><strong>Se cumple:</strong></p>
<p><span style="font-weight: 400;">Permite continuar con normalidad.</span></p>
<br />
<p><strong>No se cumple:</strong></p>
<p><span style="font-weight: 400;">Notifica la no existencia mediante una excepci&oacute;n.</span></p>
</td>
</tr>
<tr style="height: 143px;">
<td style="height: 143px;">
<p><strong>T-0002</strong></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Karen Hoffman y Lautaro Walsh</span></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Verificar que el usuario a dejar de seguir exista. </span><strong>(US-0007)</strong></p>
</td>
<td style="height: 143px;">
<p><strong>Se cumple:</strong></p>
<p><span style="font-weight: 400;">Permite continuar con normalidad.</span></p>
<br />
<p><strong>No se cumple:</strong></p>
<p><span style="font-weight: 400;">Notifica la no existencia mediante una excepci&oacute;n.</span></p>
</td>
</tr>
<tr style="height: 143px;">
<td style="height: 143px;">
<p><strong>T-0003</strong></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi</span></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Verificar que el tipo de ordenamiento alfab&eacute;tico exista (US-0008)</span></p>
</td>
<td style="height: 143px;">
<p><strong>Se cumple:</strong></p>
<p><span style="font-weight: 400;">Permite continuar con normalidad.</span></p>
<br />
<p><strong>No se cumple:</strong></p>
<p><span style="font-weight: 400;">Notifica la no existencia mediante una excepci&oacute;n.</span></p>
</td>
</tr>
<tr style="height: 63px;">
<td style="height: 63px;">
<p><strong>T-0004</strong></p>
</td>
<td style="height: 63px;">
<p><span style="font-weight: 400;">Facundo Andres Ruiz, Agustin Iglesias y Esteban Demarchi</span></p>
</td>
<td style="height: 63px;">
<p><span style="font-weight: 400;">Verificar el correcto ordenamiento ascendente&nbsp;</span></p>
<p><span style="font-weight: 400;">y descendente por nombre. </span><strong>(US-0008)</strong></p>
</td>
<td style="height: 63px;">
<p><span style="font-weight: 400;">Devuelve la lista ordenada seg&uacute;n el criterio solicitado</span></p>
</td>
</tr>
<tr style="height: 143px;">
<td style="height: 143px;">
<p><strong>T-0005</strong></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Francisco Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles</span></p>
</td>
<td style="height: 143px;">
<p><span style="font-weight: 400;">Verificar que el tipo de ordenamiento por fecha exista </span><strong>(US-0009)</strong></p>
</td>
<td style="height: 143px;">
<p><strong>Se cumple:</strong></p>
<p><span style="font-weight: 400;">Permite continuar con normalidad.</span></p>
<br />
<p><strong>No se cumple:</strong></p>
<p><span style="font-weight: 400;">Notifica la no existencia mediante una excepci&oacute;n.</span></p>
</td>
</tr>
<tr style="height: 73px;">
<td style="height: 73px;">
<p><strong>T-0006</strong></p>
</td>
<td style="height: 73px;">
<p><span style="font-weight: 400;">Francisco Nicolas Berthet Cosentino, Juan Pablo Ramos Ruiz y Armando Burdiles</span></p>
</td>
<td style="height: 73px;">
<p><span style="font-weight: 400;">Verificar el correcto ordenamiento ascendente y descendente por fecha. </span><strong>(US-0009)</strong></p>
</td>
<td style="height: 73px;">
<p><span style="font-weight: 400;">Verificar el correcto ordenamiento ascendente y descendente por fecha. </span><strong>(US-0009)</strong></p>
</td>
</tr>
<tr style="height: 53.5px;">
<td style="height: 53.5px;">
<p><strong>T-0007</strong></p>
</td>
<td style="height: 53.5px;">
<p><span style="font-weight: 400;">Karen Hoffman y Lautaro Walsh</span></p>
</td>
<td style="height: 53.5px;">
<p><span style="font-weight: 400;">Verificar que la cantidad de seguidores de un determinado usuario sea correcta.</span><strong> (US-0002)</strong></p>
</td>
<td style="height: 53.5px;">
<p><span style="font-weight: 400;">Devuelve el c&aacute;lculo correcto del total de la cantidad de seguidores que posee un usuario.&nbsp;</span></p>
</td>
</tr>
<tr style="height: 73px;">
<td style="height: 73px;">
<p><strong>T-0008</strong></p>
</td>
<td style="height: 73px;">
<p><span style="font-weight: 400;">Karen Hoffman y Lautaro Walsh</span></p>
</td>
<td style="height: 73px;">
<p><span style="font-weight: 400;">Verificar que la consulta de publicaciones realizadas en las &uacute;ltimas dos semanas de un determinado vendedor sean efectivamente de las &uacute;ltimas dos semanas. </span><strong>(US-0006)</strong></p>
</td>
<td style="height: 73px;">
<p><span style="font-weight: 400;">Devuelve &uacute;nicamente los datos de las publicaciones que tengan fecha de publicaci&oacute;n dentro de las &uacute;ltimas dos semanas a partir del d&iacute;a de la fecha.</span></p>
</td>
</tr>
</tbody>
</table>

# Test de integración.

Se llevó a cabo un test de integración de manera individual (realizado por Agustín Iglesias) del servicio de post, concretamente del método addPost. En este se llevan a cabo 3 métodos.

- El setup, en donde se definen 3 posts diferentes (esto por si a futuro se quiere probar otros métodos, por ejemplo, el de ver los últimos posts de  las últimas 2 semanas).
- Un método que añade los posts (camino feliz).
- Y un método que testea todas las validaciones de los posts (sus mensajes).
- Finalmente el @dirtiesContext elimina el contexto, asegurando que nuestro test se descarte.

Además, dado que fue necesario utilizar @beforeAll para el setup, se establece la propiedad @testInstance para que la clase solo se inicialice una sola vez y luego se reúse.