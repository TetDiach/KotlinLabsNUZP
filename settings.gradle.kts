rootProject.name = "KTests"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

listOf("caffe", "common", "juicefactory").forEach {
    include(it)
    project(":$it").projectDir=file("./modules/$it/")
}

include("helloworld")