package hernanbosqued.samples.property_delegation

import hernanbosqued.samples.library.empty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MyLazy<T : Any> constructor(val init: () -> T) {
    var isValid = false
    private lateinit var value: T

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (!isValid) {
            println("'${property.name}' not initialized, calling init for initialization")
            setValue(thisRef, property, value = init())
            isValid = true
        }
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("'$value' has been assigned to '${property.name}'.")
        this.value = value
    }
}

class UpperCaseDelegate constructor(private val init: (() -> String)? = null) : ReadWriteProperty<Any?, String> {
    var isAsigned = false
    private lateinit var value: String

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        if (!isAsigned) {
            setValue(thisRef, property, value = init?.invoke()?:String.empty())
            isAsigned = true
        }
        return value
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value.toUpperCase()
    }
}

class Example {
    var value: String by MyLazy {
        "lazy assignation"
    }
}

fun main() {
    val e = Example()
    println("getter result: ${e.value}")
    e.value = "Atlanta"
    println("getter result: ${e.value}")
}