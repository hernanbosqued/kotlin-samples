package hernanbosqued.samples

fun riskyOperation(): Nothing = throw RuntimeException("Atlanta")

fun main(args: Array<String>) {
    val result =
        runCatching { riskyOperation() }
            .onSuccess { println("anda joya") }
            .onFailure { println("fallo: ${it.message}") }

    println(result)
}
