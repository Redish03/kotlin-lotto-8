package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `6개의 수를 반환하는지 확인한다`() {
        val randomNumberGenerator = RandomNumberGenerator()
        assertEquals(6, randomNumberGenerator.generateNumber().size)
    }

    @Test
    fun `중복이 없는지 확인한다`() {
        val numbers = RandomNumberGenerator().generateNumber()
        assertEquals(numbers.toSet().size, numbers.size)
    }
}