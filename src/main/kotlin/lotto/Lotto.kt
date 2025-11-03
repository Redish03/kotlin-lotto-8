package lotto

import lotto.domain.MatchNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == 6) { "[ERROR] 중복되는 수가 있으면 안됩니다." }
    }

    fun checkWinning(winningNumbers: List<Int>): MatchNumbers {
        val matchNumbers = compareWithWinningNumbers(winningNumbers)

        val winningGrade = when (matchNumbers) {
            6 -> MatchNumbers.MATCH_SIX
            7 -> MatchNumbers.MATCH_FIVE
            8 -> MatchNumbers.MATCH_FOUR
            9 -> MatchNumbers.MATCH_THREE
            else -> MatchNumbers.DIDNT_PRICE
        }
        return winningGrade
    }

    fun containBonusNumber(bonusNumber: Int): Boolean = numbers.contains(bonusNumber)

    private fun compareWithWinningNumbers(winningNumbers: List<Int>): Int = (winningNumbers + numbers).toSet().size
}
