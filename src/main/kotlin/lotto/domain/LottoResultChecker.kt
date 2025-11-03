package lotto.domain

import lotto.Lotto

class LottoResultChecker(private val lottos: List<Lotto>, private val winningNumbers: List<Int>, val bonusNumber: Int) {
    fun checkResult(): List<WinningGrades> {
        val result = mutableListOf<WinningGrades>()

        for (lotto in lottos) {
            val compareResult = lotto.checkWinning(winningNumbers)
            result.add(judgeGrades(compareResult, bonusNumber, lotto))
        }

        return result
    }

    private fun judgeGrades(matchNumbers: MatchNumbers, bonusNumber: Int, lotto: Lotto) =
        when (matchNumbers) {
            MatchNumbers.MATCH_SIX -> WinningGrades.FIRST_GRADE
            MatchNumbers.MATCH_FIVE -> checkBonusNumber(lotto, bonusNumber)
            MatchNumbers.MATCH_FOUR -> WinningGrades.FOURTH_GRADE
            MatchNumbers.MATCH_THREE -> WinningGrades.FIVE_GRADE
            MatchNumbers.DIDNT_PRICE -> WinningGrades.DIDNT_GRADE
        }

    fun checkBonusNumber(lotto: Lotto, bonusNumber: Int): WinningGrades {
        if(lotto.containBonusNumber(bonusNumber)) return WinningGrades.SECOND_GRADE
        return WinningGrades.THIRD_GRADE
    }
}