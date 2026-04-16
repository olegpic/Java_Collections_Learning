# AGENTS.md

## Project snapshot
- Single-module Gradle project named `Java_Collections_Learning` (`settings.gradle`).
- Uses Spring Boot `4.0.5`, dependency management `1.1.7`, and a Java 17 toolchain (`build.gradle`).
- Current application code is only `src/main/java/com/alehyem/java_collections_learning/JavaCollectionsLearningApplication.java`.
- Current test coverage is only `src/test/java/com/alehyem/java_collections_learning/JavaCollectionsLearningApplicationTests.java`.
- There are no service/controller/repository packages yet; treat the repo as a clean Spring Boot scaffold for collection-focused examples.

## Architecture and placement rules
- Keep new Java code under `com.alehyem.java_collections_learning`; the root `@SpringBootApplication` enables component scanning from that package downward.
- Mirror package structure in tests under `src/test/java/com/alehyem/java_collections_learning`.
- Runtime configuration currently lives only in `src/main/resources/application.properties`, which sets `spring.application.name=Java_Collections_Learning`.
- Prefer small, topic-based packages for learning content (for example `list`, `set`, `map`, `queue`) instead of introducing deep layered architecture before it is needed.
- If you add Spring-managed classes outside the base package, you must also add explicit scan/import configuration; nothing in the current scaffold does that for you.

## Dependencies and integration boundaries
- The only runtime dependency today is `org.springframework.boot:spring-boot-starter`; do not assume MVC, JPA, database, or actuator support exists.
- The only test dependency is `spring-boot-starter-test` plus the JUnit Platform launcher.
- Adding REST endpoints, persistence, or serialization will require explicit dependency changes in `build.gradle`.
- Packaging is handled through the Spring Boot plugin; `bootJar` and `bootBuildImage` tasks are available.

## Verified developer workflows
- Run commands from the repository root on Windows:
```powershell
.\gradlew.bat test
.\gradlew.bat bootRun
.\gradlew.bat build
.\gradlew.bat bootJar
```
- `test` currently passes on the scaffold.
- `bootRun` is the expected local launch path for the app.
- To start suspended for debugger attach on port 5005:
```powershell
.\gradlew.bat bootRun --debug-jvm
```

## Working style for changes
- Keep examples minimal and runnable; this codebase currently favors plain Java classes plus the Spring Boot entrypoint over heavy framework structure.
- When adding a new collection example, add the production class under `src/main/java/...` and a matching focused JUnit 5 test under `src/test/java/...`; keep the existing `contextLoads` smoke test unless the application shape fundamentally changes.
- Avoid renaming the root package or application class unless you also update tests and any package-scoped component scanning assumptions.

