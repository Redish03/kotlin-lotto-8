package lotto

import lotto.domain.Parser
import lotto.domain.numbergenerator.NumberGenerator
import lotto.view.InputValidator
import lotto.view.InputView
import lotto.view.InputView.inputBonusNumber

class LottoController(private val inputView: InputView, private val numberGenerator: NumberGenerator) {
    private val inputValidator = InputValidator()
    private val lottos = mutableListOf<Lotto>()

    fun run() {
        val purchaseMoney = inputPurchasedMoney()
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
    }

    private fun generateLotto(lottoCount: Int) {
        repeat(lottoCount) {
            val generatedNumber = numberGenerator.generateNumber()
            // TODO: 생성한 번호 출력
            lottos.add(Lotto(generatedNumber))
        }
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