import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.mockito:mockito-inline:3.11.0")
    testImplementation("org.mockito:mockito-junit-jupiter:3.11.0")
    testImplementation("org.mockito:mockito-core:3.11.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}
