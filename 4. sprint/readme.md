# Sprint1- wave20- SocialMeli

Sprint 1 del bootcamp de la wave 20 de Java se requiere crear un servidor backend mediante el framework Spring de java que cumpla con los requisitos funcionales solicitados por los analistas.

## proyecto realizado por:
- Juan Camilo Arango Valle **github: jcamiloarangov**
- Luis Francisco López **github:**
- Julian Atehortua Zapata **github:**
- Diego Alejandro Malagon Ruiz **github:**
- John Edward Garcia Saavedra **github:**
- Adrian Isaac Gomez **github:**
- Dimas Hernandez Mendoza **github:**

# Requisitos para el correcto funcionamiento del proyecto
Este proyecto fue realizado mediante **Spring initializr** con la siguiente configuracion:
- Java version: 11
- Maven
- Spring Boot: 2.7.7
- Packaging: Jar

Para el correcto uso de este proyecto es necesario contar con la version 11 del jdk.

# Consideraciones generales
- Se utilizó como repositorio principal la rama de John Edward Garcia Saavedra.

- Se utilizaron Sets como estructura principal con el fin de asegurar que los ids sean unicos, se controla mediante el uso de errores.

- Se llegó a un consenso grupal en el cual se decidió que si bien un post tiene un id único, diferentes post pueden tener el mismo producto con el mismo Id de producto.(Revisar)

- No se cuenta con repositorios estaticos, estos son creados con codigo "quemado" o hardcoded code como datos iniciales.

- Los datos ingresados por `@pathVariables` siempre llegarán con el tipado solicitado por lo que no se tendrá en cuenta errores de este tipo en el controlador