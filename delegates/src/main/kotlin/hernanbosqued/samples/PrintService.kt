package hernanbosqued.samples

interface PrintService {
    val message: String
    val message2: String
    fun printMessage()
    fun printHello()
}

class PrintServiceImpl : PrintService {
    override val message = "delegate message"
    override val message2 = "delegate message 2"
    override fun printMessage() = println(message)
    override fun printHello() = println("Hello from delegate")
    fun anotherFun() = "this method cannot be overridden in the derived class because it isn't in the interface"
}

class EnhancedPrintServiceImpl(private val delegate: PrintService) : PrintService by delegate {
    override val message = "derived message"
    override fun printHello() = println("Hello From derived")
    fun printHelloFromDelegate() = println(delegate.printHello())
    //fun anotherFun() = delegate.anotherFun()  we must to indicate delegate:BaseImpl in order to get access to anotherFun
}