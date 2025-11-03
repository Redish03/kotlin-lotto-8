package lotto

import lotto.domain.Calculator
import lotto.domain.LottoResultChecker
import lotto.domain.Parser
import lotto.domain.WinningGrades
import lotto.domain.numbergenerator.NumberGenerator
import lotto.view.InputValidator
import lotto.view.InputView
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator
) {
    private val inputValidator = InputValidator()
    private val lottos = mutableListOf<Lotto>()
    private var purchaseMoney: Int = 0
    private var winningNumbers: List<Int> = listOf()
    private var bonusNumber: Int = 0


    fun run() {
        inputPurchasedMoney()
        val purchasedLottos = Calculator().calculatePurchasedLotto(purchaseMoney)
        generateLotto(purchasedLottos)
        inputWinningNumbers()
        inputBonusNumber()
        val result = LottoResultChecker(lottos, winningNumbers, bonusNumber).checkResult()
        printResult(result, Calculator().calculateRevenueRate(purchaseMoney, result))
    }

    private fun inputPurchasedMoney() {
        outputView.printPurchaseMoneyGuide()
        while (true) {
            try {
                val money = inputView.inputPurchaseMoney()
                inputValidator.validatePurchaseMoney(money)
                purchaseMoney = money.toInt()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputWinningNumbers() {
        outputView.printInputWinningNumbersGuide()
        while (true) {
            try {
                val inputWinningNumbers = Parser().parse(inputView.inputWinNumber())
                inputValidator.validateWinningNumbers(inputWinningNumbers)
                winningNumbers = inputWinningNumbers.map { it.toInt() }
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber() {
        outputView.printInputBonusNumbersGuide()
        while (true) {
            try {
                val inputBonusNumber = inputView.inputBonusNumber()
                inputValidator.validateBonusNumber(inputBonusNumber)
                bonusNumber = inputBonusNumber.toInt()
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun convertResult(results: List<WinningGrades>): List<Int> {
        val convertedResult = mutableListOf(0, 0, 0, 0, 0)
        for (result in results) {
            when (result) {
                WinningGrades.FIRST_GRADE -> convertedResult[0]++
                WinningGrades.SECOND_GRADE -> convertedResult[1]++
                WinningGrades.THIRD_GRADE -> convertedResult[2]++
                WinningGrades.FOURTH_GRADE -> convertedResult[3]++
                WinningGrades.FIVE_GRADE -> convertedResult[4]++
                WinningGrades.DIDNT_GRADE -> continue
            }
        }
        return convertedResult
    }

    private fun generateLotto(lottoCount: Int) {
        outputView.printPurchasedLottoCounts(lottoCount)
        repeat(lottoCount) {
            val generatedNumber = numberGenerator.generateNumber().sorted()
            outputView.printPurchasedLottoNumbers(generatedNumber)
            lottos.add(Lotto(generatedNumber))
        }
    }

    private fun printResult(result: List<WinningGrades>, rate: Double) {
        outputView.printWinningStatistics(convertResult(result))
        outputView.printRevenueRate(rate)
    }
}