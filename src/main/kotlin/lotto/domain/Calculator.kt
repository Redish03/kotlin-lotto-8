package lotto.domain

import kotlin.math.round

class Calculator {
    fun calculatePurchasedLotto(purchasedMoney: Int) = purchasedMoney.div(ONE_LOTTO_MONEY)
    fun calculateRevenueRate(purchasedMoney: Int, lottoResults: List<WinningGrades>): Double {
        var revenue = 0.0
        for (lottoResult in lottoResults) {
            revenue += when (lottoResult) {
                WinningGrades.FIRST_GRADE -> FIRST_GRADE_MONEY
                WinningGrades.SECOND_GRADE -> SECOND_GRADE_MONEY
                WinningGrades.THIRD_GRADE -> THIRD_GRADE_MONEY
                WinningGrades.FOURTH_GRADE -> FOURTH_GRADE_MONEY
                WinningGrades.FIVE_GRADE -> FIFTH_GRADE_MONEY
                WinningGrades.DIDNT_GRADE -> DIDNT_GRADED_MONEY
            }
        }
        val rate = revenue * CONVERT_PERCENTAGE_HUNDRED / purchasedMoney
        return round(rate * MAKE_SINGLE_DIGIT_DECIMAL) / MAKE_SINGLE_DIGIT_DECIMAL
    }

    companion object {
        private const val ONE_LOTTO_MONEY = 1000
        private const val FIRST_GRADE_MONEY = 2000000000
        private const val SECOND_GRADE_MONEY = 30000000
        private const val THIRD_GRADE_MONEY = 1500000
        private const val FOURTH_GRADE_MONEY = 50000
        private const val FIFTH_GRADE_MONEY = 5000
        private const val DIDNT_GRADED_MONEY = 0
        private const val CONVERT_PERCENTAGE_HUNDRED = 100
        private const val MAKE_SINGLE_DIGIT_DECIMAL = 10
    }
}