plugins {
    application
}

application {
    mainClassName = "hernanbosqued.samples.MainKt"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }

    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}