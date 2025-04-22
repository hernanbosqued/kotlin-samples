package hernanbosqued.samples

data class Operator constructor(val value: String) {
    operator fun plus(other: Operator): Operator {
        return Operator("$value mas ${other.value}")
    }
}
