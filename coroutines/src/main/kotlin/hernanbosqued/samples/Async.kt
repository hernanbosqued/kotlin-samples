package hernanbosqued.samples

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class Async{
    fun addAsync(): Int {
        var result = 0

        runBlocking {
            val one = async { taskOne() }
            val two = async { taskTwo() }

            result = one.await() + two.await() // 10 + 20

            println(result)
        }
        return result
    }

    private suspend fun taskOne(): Int {
        delay(100L)
        return 10
    }

    private suspend fun taskTwo(): Int {
        delay(400L)
        return 20
    }
}