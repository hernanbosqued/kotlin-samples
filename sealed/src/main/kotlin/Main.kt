package hernanbosqued.samples

sealed class Response {
    object OK : Response()

    class Success(val result: String) : Response()

    class Failure(val message: String) : Response()
}

fun main() {
    val resultStr =
        when (val response = getResponse()) {
            is Response.Success -> {
                response.result
            }
            is Response.Failure -> {
                response.message
            }
            Response.OK -> {
                "OK"
            }
        }

    println("The random response is $resultStr")
}

fun getResponse() = listOf(Response.Success("Succeeded"), Response.Failure("Failed"), Response.OK).random()
