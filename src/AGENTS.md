# AGENTS.md

## Scope
This is a Minecraft NeoForge Java mod project.

## Read scope
Prefer reading only:
- src/main/java
- src/main/resources
- build.gradle
- settings.gradle
- gradle.properties

Avoid reading or scanning:
- build/
- run/
- .gradle/
- .gradle-user/
- .tools/
- logs/
- out/
- crash-reports/

## Commands
Do not run Gradle commands unless explicitly requested.
When running Gradle, prefer:
- .\gradlew.bat --version
- .\gradlew.bat build
- .\gradlew.bat runClient