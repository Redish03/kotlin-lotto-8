package lotto

import lotto.domain.numbergenerator.RandomNumberGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoController(InputView, OutputView(), RandomNumberGenerator()).run()
}
