# Proyecto Java Spring Boot

![Logo de Spring](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSz7UaM26lbsPblqcbS0E8HD9stqpaNw-UFsDq6dOJP-101C4VSlhp_4XCPrJGubnbl4EE&usqp=CAU)


Este es un proyecto de ejemplo desarrollado en Java Spring Boot, utilizando Java 21 y Spring Boot 3.0.2.

## Levantar el Proyecto con Maven

Para levantar el proyecto utilizando Maven, sigue estos pasos:

1. Clona el repositorio desde GitHub:

    ```bash
    git clone https://github.com/tu-usuario/proyecto-java-spring-boot.git

    ```
2. Navega hasta el directorio del proyecto:

    ```bash
    cd proyecto-java-spring-boot   

3. Instalar dependencias del proyecto:

    ```bash
    mvn clean install
    ```

4. Ejecuta el siguiente comando Maven para compilar y ejecutar la aplicación:

    ```bash
    mvn spring-boot:run
    ```

La aplicación se ejecutará en `http://localhost:8080`.

## Base de Datos en Memoria H2

Este proyecto utiliza una base de datos en memoria H2. Puedes acceder a la consola de H2 con las siguientes credenciales:

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- Usuario: nisum
- Contraseña: nisum

Las tablas se crean al levantar el proyecto mediante las entidades mapeadas con JPA.
No se generan datos de prueba.

## Swagger con OpenAPI

La documentación de la API está generada con Swagger y OpenAPI. Puedes acceder a la documentación en la siguiente URL:

- URL: [http://localhost:8080/api-docs/swagger](http://localhost:8080/api-docs/swagger)

## Pruebas Unitarias con Mockito

Este proyecto incluye pruebas unitarias utilizando Mockito para la simulación de dependencias. Las pruebas están ubicadas en el directorio `src/test/java`.

