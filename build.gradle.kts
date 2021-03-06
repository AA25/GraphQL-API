import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val logbackVersion: String by project
val ktorVersion: String by project
val kotlinVersion: String by project
val loggingWrapperVersion: String by project
val graphqlKotlinVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.4.30"
}

//group = "com.example"
//version = "0.0.1-SNAPSHOT"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

// The repositories on the root level are used to fetch the dependencies that your project depends on.
// So all the dependencies you need to compile your project.
repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    // Use the Kotlin JDK 8 standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    // Ktor server layer
    implementation("io.ktor:ktor-server-netty:$ktorVersion")

    // Logging (Logback is the successor to SLF4J)
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    // Wrapper around the slf4j-api for Kotlin classes (Less boilerplate)
    implementation("io.github.microutils:kotlin-logging:$loggingWrapperVersion")

    // Kotest framework and assertion
    testImplementation("io.kotest:kotest-runner-junit5:4.4.1")
    testImplementation("io.kotest:kotest-assertions-core:4.4.1")

    // Mockk for mocking with Kotlin support
    testImplementation("io.mockk:mockk:1.10.6")

    // Schema Generator
    implementation("com.expediagroup:graphql-kotlin-schema-generator:$graphqlKotlinVersion")
    implementation("com.expediagroup:graphql-kotlin-types:$graphqlKotlinVersion")
    implementation("com.expediagroup:graphql-kotlin-server:$graphqlKotlinVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

kotlin.sourceSets["main"].kotlin.srcDirs("src/main")
kotlin.sourceSets["test"].kotlin.srcDirs("src/test")

sourceSets["main"].resources.srcDirs("src/main/resources")
//sourceSets["test"].resources.srcDirs("testresources")
