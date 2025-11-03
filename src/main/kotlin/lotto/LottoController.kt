package lotto

import lotto.domain.Calculator
import lotto.domain.LottoResultChecker
import lotto.domain.Parser
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

    fun run() {
        val purchaseMoney = inputPurchasedMoney()
        val lottoCount = Calculator().calculatePurchasedLotto(purchaseMoney)
        generateLotto(lottoCount)
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        LottoResultChecker(lottos, winningNumbers, bonusNumber).checkResult()
    }

    private fun generateLotto(lottoCount: Int) {
        outputView.printPurchasedLottoCounts(lottoCount)
        repeat(lottoCount) {
            val generatedNumber = numberGenerator.generateNumber().sorted()
            outputView.printPurchasedLottoNumbers(generatedNumber)
            lottos.add(Lotto(generatedNumber))
        }
    }

    private fun inputPurchasedMoney(): Int {
        outputView.printPurchaseMoneyGuide()
        val purchasedMoney = inputView.inputPurchaseMoney()
        inputValidator.validatePurchaseMoney(purchasedMoney)
        return purchasedMoney.toInt()
    }

    private fun inputWinningNumbers(): List<Int> {
        outputView.printInputWinningNumbersGuide()
        val winningNumbers = inputView.inputWinNumber()
        val parsedWinningNumbers = Parser().parse(winningNumbers)
        inputValidator.validateWinningNumbers(parsedWinningNumbers)
        return parsedWinningNumbers.map { winningNumber -> winningNumber.toInt() }
    }

    private fun inputBonusNumber(): Int {
        outputView.printInputBonusNumbersGuide()
        val bonusNumber = inputView.inputBonusNumber()
        inputValidator.validateBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }
}