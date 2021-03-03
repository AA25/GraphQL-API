# Example Ktor API (Gradle, Kotlin, GraphQL Project)

## Usage
Vist `localhost:8088/playground` to query the graphQL API.
At the moment it only supports
```
query {
  hello
}
```
Another option is to curl a POST request to `localhost:8088/graphql` with the following
body
```
curl -X POST 'http://0.0.0.0:8088/graphql' \
-H 'Content-Type: application/json' \
--data-raw '{"query":"query {hello}\n","variables":{}}'
```

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
