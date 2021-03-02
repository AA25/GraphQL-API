# Example Ktor API (Gradle, Kotlin, GraphQL Project)

## Using Gradle
```
# To run tests for a project, Gradle will not run tests for area's that have not had any changes.
./gradlew test

# To build an application bundle, after compiling and running test.
./gradlew build

# Remove previous build cache files, useful to force recompilation and test.
./gradlew clean

# Run the basic application
./gradlew run

# Detects changes made to the class path being watched (in the application.conf file) and rebuilds the project
# Use while project is already running
./gradlew -t installDist
```

## Resources
https://ktor.io/quickstart/guides/api.html
https://expediagroup.github.io/graphql-kotlin/docs/server/graphql-server
https://kotest.io/docs/quickstart
