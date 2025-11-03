package lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 테스트가 통과하도록 프로덕션 코드 구현
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `정답과 비교해서 다 맞으면 MATCH_SIX 를 반환한다`() {
        // given
        val answerLotto = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        Assertions.assertTrue(lotto.checkWinning(answerLotto) == MatchNumbers.MATCH_SIX)
    }

    @Test
    fun `정답과 비교해서 하나가 다르다면 MATCH_FIVE 를 반환한다`() {
        // given
        val answerLotto = listOf(1, 2, 3, 4, 5, 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        Assertions.assertTrue(lotto.checkWinning(answerLotto) == MatchNumbers.MATCH_FIVE)
    }

    @Test
    fun `정답과 비교해서 두 개가 다르다면 MATCH_FOUR 를 반환한다`() {
        // given
        val answerLotto = listOf(1, 2, 3, 4, 8, 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        Assertions.assertTrue(lotto.checkWinning(answerLotto) == MatchNumbers.MATCH_FOUR)
    }

    @Test
    fun `정답과 비교해서 세 개가 다르다면 MATCH_THREE 를 반환한다`() {
        // given
        val answerLotto = listOf(1, 2, 3, 9, 8, 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        Assertions.assertTrue(lotto.checkWinning(answerLotto) == MatchNumbers.MATCH_THREE)
    }

    @Test
    fun `정답과 비교해서 세 개 초과해 다르다면 DIDNT_PRICE 를 반환한다`() {
        // given
        val answerLotto = listOf(1, 2, 11, 9, 8, 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when & then
        Assertions.assertTrue(lotto.checkWinning(answerLotto) == MatchNumbers.DIDNT_PRICE)
    }

    @Test
    fun `보너스 번호가 포함되어 있다면 True 를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusLotto = 5

        Assertions.assertTrue(lotto.containBonusNumber(bonusLotto))
    }

    @Test
    fun `보너스 번호가 포함되어 있지 않다면 True 를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusLotto = 7

        Assertions.assertTrue(!lotto.containBonusNumber(bonusLotto))
    }


    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}