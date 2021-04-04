package hernanbosqued.samples.hello

import hernanbosqued.samples.library.MyClass

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please provide a name as a command-line argument")
        return
    }
    println("Hello, ${args[0]}!")
    println( MyClass().toString())
}