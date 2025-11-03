package lotto

import lotto.domain.Lotto
import lotto.domain.LottoResultChecker
import lotto.domain.WinningGrades
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultCheckerTest {
    @Test
    fun `보너스 번호가 다르다면 3등 객체를 반환한다`() {
        val lotto = Lotto(listOf<Int>(1, 2, 3, 4, 5, 6))
        val testWinningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonusNumber = 7

        assertEquals(
            WinningGrades.THIRD_GRADE,
            LottoResultChecker(listOf(lotto), testWinningNumbers, 7).checkBonusNumber(lotto, bonusNumber)
        )
    }

    @Test
    fun `보너스 번호가 같다면 2등 객체를 반환한다`() {
        val lotto = Lotto(listOf<Int>(1, 2, 3, 4, 5, 10))
        val testWinningNumbers = listOf(1, 2, 3, 4, 5, 7)
        val bonusNumber = 10

        assertEquals(
            WinningGrades.SECOND_GRADE,
            LottoResultChecker(listOf(lotto), testWinningNumbers, 7).checkBonusNumber(lotto, bonusNumber)
        )
    }
}