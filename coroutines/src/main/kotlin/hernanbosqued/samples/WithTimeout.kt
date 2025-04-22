package hernanbosqued.samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class WithTimeout {
    fun run() {
        try {
            runBlocking {
                withTimeout(1000L) {
                    task()
                    println("task done")
                }
            }
        } catch (err: Exception) {
            println(err.message)
        }
    }

    private suspend fun task(): Int {
        delay(1001L)
        return 10
    }
}
