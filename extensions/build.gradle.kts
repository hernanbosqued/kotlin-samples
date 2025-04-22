plugins {
    application
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hernanbosqued.samples.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        if (file.isFile) {
            from(zipTree(file.absoluteFile))
        }
    }
}
