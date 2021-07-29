package hernanbosqued.samples

/*
    Implement compile_lookup, lookup_word so that:
    * compile_lookup takes an array of "pages" from a book and create an
      index for each word,
    * once the index has been constructed, lookup_word will return the
      list of (page, position) for that word in the book.

    In pseudocode:

    compile_lookup([
      'It was a dark and stormy night',
      'it was a dark time'
    ])
    lookup_word('dark') => [(0,3), (1,3)]
    lookup_word('it') => [(0,0), (1,0)]
    lookup_word('stormy') => [(0,5)]
*/

class Project {
    private val result = mutableMapOf<String, MutableList<Pair<Int, Int>>>()

    fun compileLookup(pages: List<String>) {

        pages.forEachIndexed { pageIndex, page ->
            val words = page.filter { it != ',' }.split(" ")

            words.forEachIndexed { wordIndex, word ->
                result[word.toLowerCase()]?.add(Pair(pageIndex, wordIndex)) ?: run {
                    result[word.toLowerCase()] = mutableListOf(Pair(pageIndex, wordIndex))
                }
            }
        }
    }

    fun lookupWord(parameter: String): List<Pair<Int, Int>> {
        return result[parameter.toLowerCase()] ?: emptyList()
    }
}

fun main(args: Array<String>) {
    val pages = listOf(
        "It, was a dark and stormy night",
        "it was a dark time"
    )

    val project = Project()
    project.compileLookup(pages)

    project.lookupWord("dark").also {
        println(it)
    }
    project.lookupWord("it").also {
        println(it)
    }
    project.lookupWord("stormy").also {
        println(it)
    }
}