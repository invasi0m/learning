# Doobie en Scala

En este learning mostraremos como utilizar realizar operaciones de persistencias con varias instancias de bases de datos. Para ello usaremos **Doobie** como framework para la conexión con las bases de datos. Para la conexión con las base de datos se requiere tener el driver jdbc de cada db en el classpath. Por otro lado, para este learning, se provee tres instancias de bases de datos: **PostgreSQL**, **MySQL** y **Apache Ignite**.

## Prerrequisitos

Tener instalado / configurado lo siguiente:
* Java 8+
* Scala 2.13
* Sbt 1.8

## Guía rápida

### Levantar las intancias

Puedes levantar las tres instancias de manera simultanea ejecutando lo siguiente:

```shell
./docker/instance up
```

O bien puedes levantar una instancia en particular

```shell
./docker/instance postgres
```

para más información, puedes consultar la ayuda:

```shell
./docker/instance --help
```

Para eliminar las instancias

```shell
./docker/instance kill
```

### Conectate a una base de datos

Lo primero que necesitas para conectarte a una base de datos en scala usando Doobie es tener en tu classpath la dependencia del driver jdbc. La configuración y la conexión mediante Doobie es muy sencilla, puedes revisar la documentación de Doobie en [Connecting to a Database](https://tpolecat.github.io/doobie/docs/15-Extensions-PostgreSQL.html). Sin embargo, se ha preparado una POC para cada instancia en [`scala/doobie/src/main/scala/io/github/invasion/doobie`](scala/doobie/src/main/scala/io/github/invasion/doobie).

Como se puede observar, la configuración es basica y homogenea para cualquier base de dato:

```scala
    def conn[F[_]: Async]: Aux[F, Unit] =
      Transactor.fromDriverManager[F](
        driver = "<JDBC driver classpath>",
        url = "jdbc:<jdbc connection string>",
        user = "<user>",
        pass = "<pass>"
      )
```

## Referencia

* [Doc] Doobie: https://tpolecat.github.io/doobie/
  * Extension for PostgreSQL: https://tpolecat.github.io/doobie/docs/15-Extensions-PostgreSQL.html
* [Doc] PostgreSQL: https://www.postgresql.org/docs/current/index.html
* [Doc] MySQL: https://dev.mysql.com/doc/
* [Doc] Apache Ignite: https://ignite.apache.org/docs/latest/