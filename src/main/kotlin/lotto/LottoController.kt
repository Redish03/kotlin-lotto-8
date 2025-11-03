package lotto

import lotto.domain.Parser
import lotto.view.InputValidator
import lotto.view.InputView

class LottoController(private val inputView: InputView) {
    private val inputValidator = InputValidator()
    fun inputFromUser() {
        val purchaseMoney = inputView.inputPurchaseMoney()
        inputValidator.validatePurchaseMoney(purchaseMoney)
        val winningNumbers = inputView.inputWinNumber()
        val parsedWinningNumbers = Parser().parse(winningNumbers)
        inputValidator.validateWinningNumbers(parsedWinningNumbers)
        val bonusNumber = inputView.inputBonusNumber()
        inputValidator.validateBonusNumber(bonusNumber)
    }
}