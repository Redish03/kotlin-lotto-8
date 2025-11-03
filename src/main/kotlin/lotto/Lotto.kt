package lotto

import lotto.domain.MatchNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == LOTTO_SIZE) { "[ERROR] 중복되는 수가 있으면 안됩니다." }
    }

    fun checkWinning(winningNumbers: List<Int>): MatchNumbers {
        val matchNumbers = compareWithWinningNumbers(winningNumbers)

        val winningGrade = when (matchNumbers) {
            ALL_CORRECT -> MatchNumbers.MATCH_SIX
            FIVE_CORRECT -> MatchNumbers.MATCH_FIVE
            FOUR_CORRECT -> MatchNumbers.MATCH_FOUR
            THREE_CORRECT -> MatchNumbers.MATCH_THREE
            else -> MatchNumbers.DIDNT_PRICE
        }
        return winningGrade
    }

    fun containBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    private fun compareWithWinningNumbers(winningNumbers: List<Int>): Int = (winningNumbers + numbers).toSet().size

    companion object {
        const val LOTTO_SIZE = 6
        const val ALL_CORRECT = 6
        const val FIVE_CORRECT = 7
        const val FOUR_CORRECT = 8
        const val THREE_CORRECT = 9
    }
}
