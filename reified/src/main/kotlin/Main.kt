package hernanbosqued.samples

import com.google.gson.Gson

data class Person(val age: Int, val name: String)

inline fun <reified T> fromJson(json: String): T {
    return Gson().fromJson(json, T::class.java)
}

fun main(args: Array<String>) {
    val json = """{"age":42,"name":"Hernan Bosqued"}"""

    val (age, name) = fromJson<Person>(json)
    val resultStr = """Person name: $name Person age: $age"""

    println(resultStr)
}
