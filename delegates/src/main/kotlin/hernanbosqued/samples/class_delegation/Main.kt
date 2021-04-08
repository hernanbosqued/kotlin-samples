package hernanbosqued.samples.class_delegation

interface Base {
    val message: String
    fun printMessage()
    fun printHello()
}

class BaseImpl : Base {
    override val message = "delegate message"
    override fun printMessage() = println(message)
    override fun printHello() = println("Hello from delegate")
    fun anotherFun() = "this method cannot be overridden in the derived class because it isn't in the interface"
}

class Derived(private val delegate: Base) : Base by delegate {
    override val message = "derived message"
    override fun printHello() = println("Hello From derived")
    fun printHelloFromDelegate() = println(delegate.printHello())
    //fun anotherFun() = delegate.anotherFun()  we must to indicate delegate:BaseImpl in order to get access to anotherFun
}

fun main() {
    val b = BaseImpl()
    Derived(b).printMessage()
    Derived(b).printHello()
    Derived(b).printHelloFromDelegate()
    println(Derived(b).message)
}