# 0-HelloEDA

Primera práctica de la asignatura. El objetivo no es tanto el código en sí (que es trivial) como aprender el flujo de trabajo que vamos a usar durante todo el curso: un proyecto Maven, tests con JUnit, y entrega mediante Git/GitHub.

## Qué tenéis que hacer

Leed el proyecto entero antes de tocar nada. En concreto, mirad la clase de test en `src/test/java`. El test os dice, sin ambigüedad, qué se espera del código: qué método se llama, qué recibe y qué debe devolver. No os vamos a explicar aquí qué poner en el `return` de `HelloEDA()`, eso es justo lo que tenéis que averiguar leyendo el test. Si el test compara el resultado con un texto concreto, esa es vuestra pista.

La clase en la que debéis trabajas está en `src/main/java`. Ahora mismo el método lanza una excepción (`UnsupportedOperationException`) en lugar de devolver algo: eso es intencionado, es la forma de decir "esto está sin implementar todavía". Vuestro trabajo es sustituir esa línea por la implementación correcta.

Cuando el test pase en local, hacéis commit y push. GitHub Actions ejecutará automáticamente los tests sobre vuestro código en el servidor y calculará la nota en función de cuántos tests pasen. No hace falta que hagáis nada especial para activarlo: basta con el `push`.

> Importante: solo debéis hacer push cuando el test pase en local.

## Por qué un programa sin `main`

Este proyecto no tiene una clase con un método `main` que se ejecute "a mano". En su lugar, la unidad de trabajo es una clase con métodos, y la forma de comprobar que esos métodos funcionan es un **test automático**, no ejecutar el programa y mirar la consola.

Esto tiene sentido porque:

- Un test comprueba el resultado exacto de forma automática y repetible; mirar la salida por consola es lento y propenso a errores humanos ("¿esto que ha salido está bien o no?").
- El mismo test se puede volver a ejecutar cada vez que cambiéis el código, para aseguraros de que no habéis roto nada.
- Es la forma en la que se corregirán las prácticas: no leyendo vuestro código línea a línea, sino ejecutando los tests y viendo cuántos pasan (eso ya nos tocará en los exámenes).

A partir de ahora, en (casi) todas las prácticas trabajaréis así: se os da una clase con métodos sin implementar (o mal implementados) y unos tests que definen el comportamiento esperado. Vuestro trabajo es hacer que los tests pasen.

## JUnit: cómo se ejecutan los tests

Los tests están escritos con [JUnit 5](https://junit.org/junit5/). Cada método de test está marcado con la anotación `@Test`, y comprueba una condición con métodos como `assertEquals(esperado, obtenido)`, que hace fallar el test si `esperado` y `obtenido` no son iguales.

Para ejecutar los tests:

- **Desde el IDE** (IntelliJ, VSCode, etc.): clic derecho sobre la clase de test (o sobre el proyecto) → "Run Tests". El propio IDE detecta JUnit gracias a la dependencia declarada en el `pom.xml`.
- **Desde la terminal**, con Maven:

  ```bash
  mvn test
  ```

  Esto compila el proyecto y ejecuta todos los tests de `src/test/java`. Si queréis ejecutar solo una clase de test concreta:

  ```bash
  mvn test -Dtest=HelloTest
  ```

Un test en verde (pasa) significa que vuestro código se comporta como se esperaba. Un test en rojo (falla) os dirá qué esperaba y qué ha obtenido de verdad — leed ese mensaje, normalmente basta para saber qué falta por corregir.

## Git: qué es y qué vais a usar

Git es el sistema de control de versiones que llevamos usando en la asignatura. Guarda el historial de cambios de vuestro código como una secuencia de "fotos" (commits), lo que permite volver atrás si algo se rompe y, sobre todo, nos permite a nosotros ver y evaluar vuestro trabajo en GitHub.

Los comandos básicos que necesitaréis para esta práctica:

```bash
git status                 # ver qué archivos habéis modificado
git add src/main/java/Hello.java   # añadir el/los archivo(s) modificado(s) a la próxima "foto"
git commit -m "Implementa HelloEDA"  # crear el commit con un mensaje descriptivo
git push                   # subir vuestros commits al repositorio remoto (GitHub)
```

### Commits

Un commit es un punto de guardado con un mensaje que describe qué habéis cambiado y por qué. Buenas prácticas básicas:

- Un commit por cambio lógico razonable (no todo en uno solo al final, ni un commit por cada letra que escribís).
- Mensajes breves pero descriptivos: `"Implementa HelloEDA"` es mejor que `"cambios"` o `"asdf"`.
- Comprobad que los tests pasan en local *antes* de hacer commit, para no subir código roto.

### Push

`git push` envía vuestros commits locales al repositorio remoto en GitHub. Es el paso que realmente "entrega" vuestro trabajo: hasta que no hacéis `push`, vuestros cambios solo existen en vuestro ordenador.

## Corrección automática (GitHub Actions)

Cada vez que hacéis `push`, se dispara automáticamente un workflow de **GitHub Actions** configurado en el repositorio. Este workflow:

1. Descarga vuestro código.
2. Lo compila.
3. Ejecuta todos los tests del proyecto.
4. Calcula una puntuación en función de cuántos tests pasen.

Podéis ver el resultado en la pestaña **Actions** de vuestro repositorio en GitHub. Si un test falla ahí pero pasaba en vuestro ordenador (o viceversa), revisad primero que habéis hecho `push` de todos los archivos necesarios y que no depende de nada específico de vuestra máquina.

No hace falta que entendáis todavía cómo funciona ese workflow por dentro: basta con saber que existe, que se ejecuta solo, y que la nota depende de los tests en verde — así que vuestro objetivo real es sencillo: hacer que pasen todos los tests del proyecto.
