plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.compose") version "1.3.0"
    application
}

group = "me.tetiana"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")

}

dependencies {
    implementation("com.diacht.ktest:library:1.0.6")
    implementation(compose.desktop.currentOs)
    implementation(project(":juicefactory"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
