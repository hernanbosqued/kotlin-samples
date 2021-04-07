package hernanbosqued.samples

class TextMaker {
    private var list: ArrayList<String> = ArrayList()
    var append: ((String) -> String)? = null

    fun addHernan() {
        list.add("Hernan")
    }

    fun addAtlanta() {
        list.add("Atlanta")
    }

    override fun toString(): String {
        var response = ""
        list.forEach {
            response += append?.invoke(it)
        }
        return response
    }
}

fun makeString(lambda: TextMaker.() -> Unit): String {
    val maker = TextMaker()
    maker.append = { value ->
        "Value appended: $value\n"
    }

    lambda(maker)
    return maker.toString()
}

fun main(args: Array<String>) {

    val result = makeString {
        addAtlanta()
        addHernan()
        addAtlanta()
        addHernan()
    }

    println(result)
}