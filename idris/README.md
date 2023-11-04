# Getting Started
Para evitar tener que instalar binarios en nuestra pc, preferimos usar containers que nos proveen un entorno de desarrollo con idris2.

Para ello, seguiremos: https://github.com/joshuanianji/idris-2-docker#devcontainer-demo-wordle-in-idris

# Idris2 REPL

Una vez levantado nuestro entorno de desarrollo, podemos ecribir en una terminal lo siguiente:

```bash
idris2
```
Con esto, arrancariamos el prompt para trabajar con idris.
### Check syntax
Podemos checkear la sintaxys de algun archivo en particular con lo siguiente:

```bash
idris2 -c /path/path2/file.idr
```

o desde el propio REPL
```idris2
:c /path/path2/file.idr
```

### Compile

Con esto compilamos el archivo en un ejecutable

```bash
idris2 /path/path2/file.idr -o output_file
```


# Documentation
* [Idris2 lang](https://www.idris-lang.org/)
* [Idris2/doc](https://idris2.readthedocs.io/en/latest/index.html)
* [Idris2 devcontainer](https://github.com/joshuanianji/idris-2-docker#devcontainer-demo-wordle-in-idris)