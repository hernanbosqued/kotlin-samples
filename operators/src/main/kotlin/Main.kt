package hernanbosqued.samples

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("ERROR: you must to provide 2 arguments")
        return
    }

    val operator1 = Operator(args[0])
    val operator2 = Operator(args[1])

    val sum = operator1 + operator2

    println(sum.value)
}