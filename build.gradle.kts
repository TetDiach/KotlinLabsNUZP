import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    id("com.github.gmazzo.buildconfig") version "3.1.0"
    application
}

subprojects {
    apply(plugin = "com.github.gmazzo.buildconfig")
}

val labNumber = 2

allprojects {
    buildConfig {
        buildConfigField("int", "LAB_NUMBER", "${labNumber}")
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")
    google()
}

dependencies {
    if (labNumber > 1) {
        implementation(project(":helloworld"))
    }
    implementation("com.diacht.ktest:library:1.0.1")
    testImplementation(kotlin("test"))
}

sourceSets {
    if (labNumber < 2) {
        named("main") {
            java.srcDir("./helloworld/src/main/kotlin/")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
