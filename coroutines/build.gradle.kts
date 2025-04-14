plugins {
    application
}

application {
    mainClass.set("hernanbosqued.samples.MainKt")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("junit:junit:4.12")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hernanbosqued.samples.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        if(file.isFile){
            from(zipTree(file.absoluteFile))
        }
    }
}