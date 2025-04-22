package hernanbosqued.samples

interface MyList<out T> {
    fun getValue(index: Int): T

    fun contains(element: @UnsafeVariance T): Boolean
}

class Comparator<in T> {
    fun compare(
        first: T,
        second: T,
    ): Boolean {
        return first == second
    }
}

sealed class Animal {
    sealed class Gato : Animal() {
        object Siames : Gato()

        object Persa : Gato()
    }

    object Perro : Animal()
}

fun main(args: Array<String>) {
    val animalComparator = Comparator<Animal>()
    println(animalComparator.compare(Animal.Gato.Persa, Animal.Perro))

    val gatoComparator: Comparator<Animal.Gato> = animalComparator
    println(gatoComparator.compare(Animal.Gato.Siames, Animal.Gato.Siames))
}
