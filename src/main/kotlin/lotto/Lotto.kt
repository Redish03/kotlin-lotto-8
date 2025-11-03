package lotto

import lotto.domain.WinningGrade

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 중복되는 수가 있으면 안됩니다." }
    }

    fun checkWinning(winningNumbers: List<Int>): WinningGrade {
        val matchNumbers = compareWithWinningNumbers(winningNumbers)

        val winningGrade = when(matchNumbers) {
            6 -> WinningGrade.MATCH_SIX
            7 -> WinningGrade.MATCH_FIVE
            8 -> WinningGrade.MATCH_FOUR
            9 -> WinningGrade.MATCH_THREE
            else -> WinningGrade.DIDNT_PRICE
        }
        return winningGrade
    }

    private fun compareWithWinningNumbers(winningNumbers: List<Int>): Int = (winningNumbers + numbers).toSet().size
}
