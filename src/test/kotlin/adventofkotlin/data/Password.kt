package adventofkotlin.data

data class Password(
    val min: Int,
    val max: Int,
    val char: Char,
    val password: String,
)
