package hernanbosqued.samples

import hernanbosqued.samples.library.empty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class UpperCaseDelegate constructor(private val init: (() -> String)? = null) : ReadWriteProperty<Any?, String> {
    var isAssigned = false
    private lateinit var value: String

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        if (!isAssigned) {
            setValue(thisRef, property, value = init?.invoke()?:String.empty())
            isAssigned = true
        }
        return value
    }

    override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value.toUpperCase()
    }
}