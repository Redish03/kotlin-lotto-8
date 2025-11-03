package lotto.view

class OutputView {
    fun printPurchaseMoneyGuide() {
        println("구입금액을 입력해 주세요.")
    }

    fun printPurchasedLottoCounts(lottoCounts: Int) {
        println()
        println("${lottoCounts}개를 구매했습니다.")
    }

    fun printPurchasedLottoNumbers(numbers: List<Int>) {
        println("[" + numbers.joinToString(", ") + "]")
    }

    fun printInputWinningNumbersGuide() {
        println()
        println("당첨 번호를 입력해 주세요.")
    }

    fun printInputBonusNumbersGuide() {
        println()
        println("보너스 번호를 입력해 주세요.")
    }

    fun printWinningStatistics(winningStatistics: List<Int>) {
        println()
        println("당첨 통계\n---")
        println("3개 일치 (5,000원) - ${winningStatistics[4]}개")
        println("4개 일치 (50,000원) - ${winningStatistics[3]}개")
        println("5개 일치 (1,500,000원) - ${winningStatistics[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningStatistics[1]}개")
        println("6개 일치 (2,000,000,000원) - ${winningStatistics[0]}개")
    }

    fun printRevenueRate(revenueRate: Double) {
        println("총 수익률은 ${revenueRate}%입니다.")
    }
}