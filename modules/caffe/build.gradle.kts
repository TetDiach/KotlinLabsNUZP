plugins {
    kotlin("jvm") version Versions.kotlin
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":common"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(Versions.jvmLevel)
}
