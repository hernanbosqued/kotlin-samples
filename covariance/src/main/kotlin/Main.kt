package hernanbosqued.samples

interface MyList<out T> {
    fun getValue(index: Int): T
    fun contains(element: @UnsafeVariance T): Boolean
}

class Consumer<in T> {
    fun set(value: T): String {
        return value.toString()
    }
}

fun getConsumer(): Consumer<Any>{
    return Consumer<Double>() as Consumer<Any>
}

class MyMutableList<T> : MyList<T> {

    private val list = ArrayList<T>()

    fun add(value: T) {
        list.add(value)
    }

    override fun contains(element: T): Boolean {
        return list.contains(element)
    }

    override fun getValue(index: Int): T {
        return list[index]
    }
}

fun copy(from: Array<out Number>, to: Array<in Number>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun printArray(array: Array<*>) {
    array.forEach { println(it) }
}

fun main(args: Array<String>) {
    val a = Consumer<Number>()
    val b: Consumer<Double> = a
    a.set(2.0)
    b.set(2.0)

    val consumer = getConsumer()
    consumer.set("atlanta")

    val collection = MyMutableList<String>()
    collection.add("Atlanta")
    collection.add("Capo")

    val anyCollection: MyList<Any> = collection

    println(anyCollection.contains(1))
    println(anyCollection.contains("Atlanta"))

    println(anyCollection.getValue(0))
    println(anyCollection.getValue(1))


//    val list = ArrayList<Producer<Any>>()
//    list.add(Producer("Atlanta"))
//    list.add(Producer(1))
//    println((list[0].get() as String).plus(" capo"))
//    println((list[1].get() as Int) + 1)

    val list2 = ArrayList<Consumer<Double>>()
    list2.add(Consumer<Number>())
    list2.add(Consumer<Any>())
    println(list2[0].set(1.0))
    println(list2[1].set(1.0))
//
//    val ints: Array<Int> = arrayOf(1, 2, 3)
//    val doubles: Array<Double> = arrayOf(1.0, 2.0, 3.0)
//    val numbers: Array<Number> = arrayOf(0, 0, 0)
//    val anyArray: Array<Any?> = arrayOfNulls(3)
//
//    for (i in numbers.indices)
//        numbers[i] = doubles[i]
//
//    copy(ints, numbers)
//    println(numbers[0].toString())
//
//    copy(doubles, numbers)
//    println(numbers[0].toString())
//
//    copy(arrayOf(1.1f, 2f, 3.4f), anyArray)
//    println(anyArray[0].toString())
//
//    val array = arrayOf(1, 2, 3.4f)
//    printArray(array)
}
