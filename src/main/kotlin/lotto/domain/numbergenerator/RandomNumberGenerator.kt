package lotto.domain.numbergenerator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(): List<Int> =
        Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, PICK_NUMBERS_COUNT)

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val PICK_NUMBERS_COUNT = 6
    }
}