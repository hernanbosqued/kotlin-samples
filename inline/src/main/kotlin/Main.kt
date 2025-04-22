package hernanbosqued.samples

inline fun List<Int>.myForEach(block: (Int) -> Unit) {
    for (i in this) {
        block(i)
    }
}

inline fun <reified T> List<T>.myReifiedForEach(block: (T) -> Unit) {
    for (i in this) {
        block(i)
    }
}

fun contains20(list: List<Int>): Boolean {
    list.myForEach {
        println(it.toString())
        if (it == 20) {
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    val list = (1..100).toList()
    val result = contains20(list)
    println(result)
}
