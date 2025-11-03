package lotto

import lotto.domain.Parser
import lotto.view.InputValidator
import lotto.view.InputView
import lotto.view.InputView.inputBonusNumber

class LottoController(private val inputView: InputView) {
    private val inputValidator = InputValidator()

    fun run() {
        val purchaseMoney = inputPurchasedMoney()
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
    }

    private fun inputPurchasedMoney(): Int {
        val purchasedMoney = inputView.inputPurchaseMoney()
        inputValidator.validatePurchaseMoney(purchasedMoney)
        return purchasedMoney.toInt()
    }

    private fun inputWinningNumbers(): List<Int> {
        val winningNumbers = inputView.inputWinNumber()
        val parsedWinningNumbers = Parser().parse(winningNumbers)
        inputValidator.validateWinningNumbers(parsedWinningNumbers)
        return parsedWinningNumbers.map { winningNumber -> winningNumber.toInt() }
    }

    private fun inputBonusNumber(): Int {
        val bonusNumber = inputView.inputBonusNumber()
        inputValidator.validateBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }
}