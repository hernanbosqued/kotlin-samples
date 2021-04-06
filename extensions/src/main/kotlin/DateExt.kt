package hernanbosqued.samples

import java.text.SimpleDateFormat
import java.util.Date

fun Date.format(pattern: String): String = SimpleDateFormat(pattern).format(this).format(this)