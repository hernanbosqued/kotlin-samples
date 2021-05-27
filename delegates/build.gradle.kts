//gradle command-line run:
//gradle run --args="hernan atlanta"

//jar command-line run:
//java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

application {
    mainClassName = "hernanbosqued.samples.MainKt"
}

dependencies {
    api(project(":library"))
    testImplementation("junit:junit:4.12")
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