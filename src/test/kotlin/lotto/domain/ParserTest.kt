package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ParserTest {
    @Test
    fun `주어진 문자열을 ,를 기준으로 파싱한다`() {
        // given
        val inputString = "4,5,6,7,8,9"
        val answers = listOf<String>("4", "5", "6", "7", "8", "9")
        // when & then
        assertEquals(answers, Parser().parse(inputString))
    }
}