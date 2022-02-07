//gradle command-line run:
//gradle run --args="hernan atlanta"

//jar command-line run:
//java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

application {
    mainClassName = "hernanbosqued.samples.processing.MainKt"
}

dependencies {
    api(project(":library"))
    implementation("org.processing:core:3.3.6")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }

    configurations["compileClasspath"].forEach { file: File ->
        if(file.isFile){
            from(zipTree(file.absoluteFile))
        }
    }
}