# Learning React
Este proyecto es para tener un learning de **React**. Para ello, vamos a disponibilizar un entorno de desarrollo para React.

## Entorno de desarrollo

Se ha preparado un entorno desplegable para que no tengas que instalar nada en tu ordenador y que sea solo levantar / eliminar contenedor.

El entorno para empezar a programar React se conforma de:

* Contenedor Docker con todo lo necesario para empezar con React:
  * node
  * npm

* Docker-Compose con el puerto 3000 expuesto que es donde se desplegará nuestra aplicación web. Además, apunta a la carpeta `app` dónde se aloja nuestro proyecto React.
* La carpeta `app` que es dónde se encuentra y desde donde desarrollaremos codigo javascript con React.

## Prerrequisitos

Hace falta tener instalado docker para poder desplegar la imagen. 

**Dockerfile**

Puedes generarte en local desde cero tu imagen docker desde el Dockerfile en `./docker/alpine/Dockerfile`. Para ello, ejecuta el siguiente comando:

```bash
docker build .
```
**Docker Compose**

O bien, puedes desplegar el docker compose desde la imagen docker en nuestro DockerHub.

```bash
docker compose up -d
```

## Guía Rápida

Una vez desplegado la imágen docker, debemos de desplegar el entorno de desarrollo web y exponerlo en nuestro navegador. Para ello primero entramos en nuestro contenedor:

```bash
docker exec -it nvm bash
```

y una vez dentro, que estaremos directamente en la carpeta `app` dónde se encuentra nuestro código, ejecutamos lo siguiente:

```bash
npm start
```

Automáticamente, ya tendremos disponible nuestro entorno de desarrollo web en [`http://localhost:3000`](ttp://localhost:3000)

## Referencias

Para este learning nos hemos apoyado en los siguientes recursos:

* **Full Stack Open** - [Profundización en el desarrollo web moderno](https://fullstackopen.com/es/)
* [Youtube] **Midudev** - [Aprendiendo Javascript y React desde cero - Bootcamp FullStack](https://youtu.be/YLvT1ELnaX4)
* [Youtube] **Midudev** - [Curso React.js ⚛️ desde cero - Crea una aplicación paso a paso](https://www.youtube.com/playlist?list=PLV8x_i1fqBw0B008sQn79YxCjkHJU84pC)
