plugins {
    application
}

application {
    mainClassName = "hernanbosqued.samples.coroutines.CoroutinesKt"
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("junit:junit:4.12")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}