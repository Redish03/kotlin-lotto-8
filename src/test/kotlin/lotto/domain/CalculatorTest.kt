package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `산 금액에 맞춰 로또의 개수를 반환한다`() {
        val test = 15000
        val answer = 15

        assertEquals(answer, Calculator().calculatePurchasedLotto(test))
    }

    @Test
    fun `로또 결과에 따라 수익률을 반환한다`() {
        val purchaseMoney = 8000
        val lottoResult = listOf(WinningGrades.FIVE_GRADE, WinningGrades.DIDNT_GRADE, WinningGrades.DIDNT_GRADE)
        val revenueRate = 62.5

        assertEquals(revenueRate, Calculator().calculateRevenueRate(purchaseMoney, lottoResult))
    }
}