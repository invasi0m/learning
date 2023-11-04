# Learning Astro
Este proyecto es para tener un learning de **Astro**. Para ello, vamos a disponibilizar un entorno de desarrollo para Astro con varias opciones:

* Usando [pnpm](./pnpm) (más estable)
* Usando [bun](./bun) (es nuevo pero más rápido y eficiente)

## Entorno de desarrollo

Se ha preparado un entorno desplegable para que no tengas que instalar nada en tu ordenador y que sea solo levantar / eliminar contenedor.

El entorno para empezar a programar Astro se conforma de:

* Contenedor Docker con todo lo necesario para empezar con Astro:
  * node
  * pnpm / bun

* Docker-Compose con el puerto `4321` expuesto que es donde se desplegará nuestra aplicación web. Además, apunta a la carpeta `app` dónde se aloja nuestro proyecto Astro.
* La carpeta `app` que es dónde se encuentra y desde donde desarrollaremos codigo javascript con Astro.

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
docker exec -it astro-alpine bash
```

y una vez dentro, que estaremos directamente en la carpeta `app` dónde se encuentra nuestro código, ejecutamos lo siguiente:

```bash
pnpm start
```

Automáticamente, ya tendremos disponible nuestro entorno de desarrollo web en [`http://localhost:4321`](ttp://localhost:4321)

## Referencias

Para este learning nos hemos apoyado en los siguientes recursos:

* [Youtube] **Midudev** - [Curso de Astro 3 Desde Cero 🚀](https://youtu.be/RB5tR_nqUEw?si=xZi3cqEcQG7OUoOL)
