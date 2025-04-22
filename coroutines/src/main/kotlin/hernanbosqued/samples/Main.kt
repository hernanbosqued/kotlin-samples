package hernanbosqued.samples

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    unconfirmed()
    // dispatcher()
    // WithTimeout().run()
    // Launch().hello()
    // /Async().addAsync()
    //    doWorld()
    //    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld() =
    coroutineScope { // this: CoroutineScope
        launch {
            delay(2000L)
            println("World 2")
        }
        launch {
            delay(1000L)
            println("World 1")
        }
        println("Hello")
    }
