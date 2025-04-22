package hernanbosqued.samples

import java.util.Date

fun main(args: Array<String>) {
    println(16.binary) // 10000
    println(16.octal) // 20
    println(16.hexadecimal) // 10

    val date = Date()
    val formattedDate = date.format("dd-MM-yyyy")
    println("Hoy es $formattedDate")
}
