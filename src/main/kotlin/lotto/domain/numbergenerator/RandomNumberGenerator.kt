package lotto.domain.numbergenerator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(): List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)
}