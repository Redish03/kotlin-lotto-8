package lotto

import lotto.view.InputValidator
import lotto.view.InputView

class LottoController(private val inputView: InputView) {
    private val inputValidator = InputValidator()
    fun inputFromUser() {
        val purchaseMoney = inputView.inputPurchaseMoney()
        inputValidator.validatePurchaseMoney(purchaseMoney)
        val winningNumbers = inputView.inputWinNumber()
        // TODO: 문자열 파싱
        inputValidator.validateWinningNumbers(listOf()) // TODO: winningNumber 전달
        val bonusNumber = inputView.inputBonusNumber()
        inputValidator.validateBonusNumber(bonusNumber)
    }
}