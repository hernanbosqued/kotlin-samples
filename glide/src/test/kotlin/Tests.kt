import hernanbosqued.samples.Project
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class Tests {

    private lateinit var project: Project
    private val pages = listOf(
        "It, was a dark and stormy night",
        "it was a dark time"
    )


    @Before
    fun before() {
        println("BEFORE")
        project = Project()
        project.compileLookup(pages)
    }

    @After
    fun after() {
        println("AFTER")
    }

    @Test
    fun test1() {
        val value = project.lookupWord("dark")
        Assert.assertEquals(value.size, 2)
    }
}