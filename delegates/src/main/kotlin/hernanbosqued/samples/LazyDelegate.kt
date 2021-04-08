package hernanbosqued.samples

import kotlin.reflect.KProperty

class LazyDelegate<T : Any> constructor(val init: () -> T) {
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