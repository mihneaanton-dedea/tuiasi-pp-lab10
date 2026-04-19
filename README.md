# Lab 10 — Kotlin Corutine (kotlinx.coroutines)

Laborator de programare în Kotlin cu accent pe programarea asincronă folosind corutine.

## Structura proiectului

```
lab10/
├── src/
│   ├── main/kotlin/ro/tuiasi/pp/lab10/
│   │   ├── chain/        # Tema 1: Chain of Responsibility cu corutine
│   │   ├── factory/      # Tema 1: Abstract Factory pentru handler-e
│   │   ├── pipeline/     # Tema 2: Pipeline ADT cu canale
│   │   └── factorial/    # Tema 3: Factorial paralel
│   └── test/kotlin/ro/tuiasi/pp/lab10/
│       ├── ChainTest.kt
│       ├── PipelineTest.kt
│       └── FactorialTest.kt
├── .github/workflows/classroom.yml
├── pom.xml
├── ASSIGNMENT.md
└── README.md
```

## Concepte cheie

- `launch` — corutină fire-and-forget
- `async`/`await` — corutină cu rezultat
- `delay()` — suspendare non-blocantă
- `Channel<T>` — comunicare între corutine (producer-consumer)
- `runBlocking` — pod între cod sincron și corutine

## Cum rulezi

```bash
mvn -B test
```

## Cerințe sistem

- JDK 21 (Temurin recomandat)
- Maven 3.8+

## Citește mai mult

Vezi [ASSIGNMENT.md](ASSIGNMENT.md) pentru cerințele complete ale temelor.
