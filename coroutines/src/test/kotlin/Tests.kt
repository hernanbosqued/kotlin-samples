import hernanbosqued.samples.Async
import org.junit.Assert
import org.junit.Test

class Tests {
    @Test
    fun test1() {
        val result = Async().addAsync()
        Assert.assertEquals(30, result)
    }
}
