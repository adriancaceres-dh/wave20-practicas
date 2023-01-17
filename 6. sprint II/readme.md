
# Parte Individual

Test de integracion.

-> US-0002: 
* Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor


## Descripcion de el test

para este caso se testeo la funcionalidad de el endpoint de la US02 : 
- "/{userId}/followers/count"

- Se testea "caso feliz". Se ingresa un userId y se espera que retorne un json con el id correspondiente y una respuesta 200 Ok.
- Se testea caso en que se ingresa un id no valido, esperando como respuesta un error 404 bad request.
