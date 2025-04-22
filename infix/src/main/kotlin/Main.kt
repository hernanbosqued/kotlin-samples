package hernanbosqued.samples

data class Color(val name: String)

class Person(val name: String, var assignedColor: Color? = null) {
    infix fun assignColor(color: Color) {
        assignedColor = color
    }
}

fun main() {
    val color = Color("Red")
    val person = Person("Hernan")

    person assignColor color

    println("'${person.name}' has color '${person.assignedColor?.name}' assigned")
}
