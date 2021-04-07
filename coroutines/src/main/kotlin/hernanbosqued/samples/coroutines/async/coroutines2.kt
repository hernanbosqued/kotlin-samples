package hernanbosqued.samples.coroutines.async

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val one = async { taskOne() }
    val two = async { taskTwo() }

    val result = one.await() + two.await() // 10 + 20

    println(result)
}

suspend fun taskOne(): Int {
    delay(100L)
    return 10
}

suspend fun taskTwo(): Int {
    delay(400L)
    return 20
}

