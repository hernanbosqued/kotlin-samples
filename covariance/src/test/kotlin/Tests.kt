import hernanbosqued.samples.Animal
import hernanbosqued.samples.Comparator
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class Tests {
    @Before
    fun before() {
        println("BEFORE")
    }

    @After
    fun after() {
        println("AFTER")
    }

    @Test
    fun `contravariant 1`() {
        val sut = Comparator<Animal>()
        assertFalse(sut.compare(Animal.Gato.Persa, Animal.Perro))
    }

    @Test
    fun `contravariant 2`() {
        val sut: Comparator<Animal.Gato> = Comparator<Animal>()
        assertTrue(sut.compare(Animal.Gato.Siames, Animal.Gato.Siames))
    }
}
