package lotto.domain

class Parser {
    fun parse(input: String): List<String> = input.split(PARSE_DELIMITER)

    companion object {
        private const val PARSE_DELIMITER = ","
    }
}