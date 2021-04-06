package hernanbosqued.samples

inline fun List<Int>.myForeach(block: (Int) -> Unit) {
    for (i in this) {
        block.invoke(i)
    }
}

fun contains20(list: List<Int>): Boolean {
    list.myForeach {
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