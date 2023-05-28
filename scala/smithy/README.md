# Generando un API Server con Http4s y Smithy4s

En este learning mostramos como generar un API Server de Http4s usando la especificación de **[Smithy](https://smithy.io/1.0/index.html)** y la libreria **[Smithy4s](https://github.com/disneystreaming/smithy4s)**. Gracias a esta propuesta, no sólo estamos evitando crear boilerplate en la definición de las request y las response, sino en la definición de los servicios. Ganamos la generación de código desde la propia especificacion de Smithy, el cual es agnostico al lenguge y además, obtenemos un endpoint de **OpenAPI** de gratis.

## Prerrequisitos

Tener instalado / configurado lo siguiente:
* Java 11+
* Scala 2.13
* Sbt 1.8

## Guía rápida

### Levantar el servidor

Para levantar el servidor ejecuta lo siguiente:

```shell
sbt run
```
### Probando Endpoints

**OpenAPI Swagger**. `http://localhost:8080/docs`

Los endpoints expuestos en este learning son:

* Obtener todos los usuarios. `GET` `http://localhost:8080/users`
* Obtener el usuario con id. `GET` `http://localhost:8080/users/{id}`
* Crear usuario. `GET` `http://localhost:8080/users/{id}`
* Editar usuario con id. `GET` `http://localhost:8080/users/{id}`
* Eliminar usuario con id. `GET` `http://localhost:8080/users/{id}`

Para probar un endpoint ejecuta lo siguiente:

#### cUrl
```shell
curl -X 'GET' 'http://localhost:8080/users' -H 'accept: application/json'
```

#### http
```shell
http get localhost:8080/users
```

## Referencia

* [Doc] Smithy. https://smithy.io/1.0/index.html
* [Doc] Smithy4s. https://disneystreaming.github.io/smithy4s/
* [Youtube] Jakub Kozłowski. https://www.youtube.com/@kubukoz_/videos
  * [Smithy - the API definition language](https://www.youtube.com/watch?v=nNUnSbyyxGI)
  * [How to write an API specification in Smithy](https://www.youtube.com/watch?v=pYANOnjx5Ic)
  * [Smithy4s - project setup and HTTP routes](https://www.youtube.com/watch?v=2SJ84YHqz7U)
  * [HTTP clients for free with Smithy4s](https://www.youtube.com/watch?v=bzjl6VOZZVw)