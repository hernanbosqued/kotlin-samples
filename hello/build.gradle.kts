// gradle command-line run: gradle run --args=hernan
// jar command-line run: java -jar hello-1.0.0.jar hernan

plugins {
    application
}

dependencies {
    api(project(":library"))
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hernanbosqued.samples.hello.HelloKt"
    }
}
