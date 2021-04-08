import hernanbosqued.samples.property_delegation.MyLazy
import hernanbosqued.samples.property_delegation.UpperCaseDelegate
import org.junit.After
import org.junit.Assert
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
    fun test1() {
        val lazy: String by MyLazy { "lazy" }

        Assert.assertEquals("lazy", lazy)
    }

    @Test
    fun test2() {
        //read only
        val uppercase: String by UpperCaseDelegate { "uppercase" }
        Assert.assertEquals("UPPERCASE", uppercase)

        //read-write
        var empty: String by UpperCaseDelegate()
        Assert.assertEquals("", empty)
        empty = "not empty"
        Assert.assertEquals("NOT EMPTY", empty)
    }
}