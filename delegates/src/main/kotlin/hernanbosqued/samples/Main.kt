package hernanbosqued.samples

fun main() {
    var value: String by LazyDelegate {
        "lazy assignation"
    }

    println("getter result: ${value}")
    value = "Atlanta"
    println("getter result: ${value}")

    val b = PrintServiceImpl()
    EnhancedPrintServiceImpl(b).printMessage()
    EnhancedPrintServiceImpl(b).printHello()
    EnhancedPrintServiceImpl(b).printHelloFromDelegate()
    println(EnhancedPrintServiceImpl(b).message)
}