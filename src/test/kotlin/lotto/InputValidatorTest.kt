package lotto

import lotto.view.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import java.util.stream.Stream

class InputValidatorTest {
    // 구입 금액 값 테스트
    @ParameterizedTest
    @CsvSource(value = ["e", "test", "523e", "@#"])
    fun `구입 금액 값이 정수로 주어지지 않으면 IllegalArgumentException을 발생시킨다`(testMoney: String) {
        // when
        val InputValidator = InputValidator()

        // then
        assertThrows<IllegalArgumentException> { InputValidator.validatePurchaseMoney(testMoney) }
    }

    @ParameterizedTest
    @CsvSource(value = ["12341", "13580", "10500", "1454690", "104", "100", "10", "18500", "0", "-1", "-1000"])
    fun `구입 금액 값이 1,000 단위로 주어지지 않으면 IllegalArgumentException을 발생시킨다`(testMoney: String) {
        // when
        val InputValidator = InputValidator()

        // then
        assertThrows<IllegalArgumentException> { InputValidator.validatePurchaseMoney(testMoney) }
    }

    @ParameterizedTest
    @CsvSource(value = ["10000", "13000", "10000000", "30228000", "89000", "943000", "1000", "8000"])
    fun `구입 금액 값이 정상적으로 들어오면 예외를 발생시키지 않는다`(testMoney: String) {
        // when
        val InputValidator = InputValidator()

        // then
        assertDoesNotThrow { InputValidator.validatePurchaseMoney(testMoney) }
    }

    @Test
    fun `구입 금액 값이 빈칸 또는 공백이면 IllegalArgumentException을 발생시킨다`() {
        // given
        val testMoney = " "
        val testMoney2 = ""

        // when
        val InputValidator = InputValidator()

        // then
        assertThrows<IllegalArgumentException> { InputValidator.validatePurchaseMoney(testMoney) }
        assertThrows<IllegalArgumentException> { InputValidator.validatePurchaseMoney(testMoney2) }
    }

    // 로또 정답 번호 값 테스트


    @ParameterizedTest
    @MethodSource("generateWrongNumberLottoNumbers")
    fun `로또 정답 번호들이 1과 45 사이의 수를 벗어나면 IllegalArgumentException을 발생시킨다`(incorrectNumbers: List<String>) {
        assertThrows<IllegalArgumentException> { InputValidator().validateWinningNumbers(incorrectNumbers) }
    }

    @ParameterizedTest
    @MethodSource("generateWrongFormatLottoNumbers")
    fun `로또 정답 번호가 정수가 아니라면 IllegalArgumentException을 발생시킨다`(incorrectNumbers: List<String>) {
        assertThrows<IllegalArgumentException> { InputValidator().validateWinningNumbers(incorrectNumbers) }
    }

    @ParameterizedTest
    @MethodSource("generateWrongNumberLottoNumbers")
    fun `로또 정답 번호가 6개가 아니라면 IllegalArgumentException을 발생시킨다`(wrongNumbers: List<String>) {
        // then
        assertThrows<IllegalArgumentException> { InputValidator().validateWinningNumbers(wrongNumbers) }
    }


    @ParameterizedTest
    @MethodSource("generateCorrectLottoNumbers")
    fun `로또 정답 번호가 1과 45 사이의 수 6개라면 예외를 발생시키지 않는다`(correctLottoNumbers: List<String>) {
        // then
        assertDoesNotThrow { InputValidator().validateWinningNumbers(correctLottoNumbers) }
    }

    @ParameterizedTest
    @MethodSource("generateWrongFormatLottoNumbers")
    fun `로또 정답 번호가 6개라면 예외를 발생시키지 않는다`(incorrectLottoNumbers: List<String>) {
        assertThrows<IllegalArgumentException> { InputValidator().validateWinningNumbers(incorrectLottoNumbers) }
    }

    // 보너스 번호 테스트
    @ParameterizedTest
    @CsvSource(value = ["a", "c,v", "4-58+", "qwerty"])
    fun `보너스 번호가 정수가 아니라면 IllegalArgumentException을 발생시킨다`(incorrectBonusNumber: String) {
        assertThrows<IllegalArgumentException> { InputValidator().validateBonusNumber(incorrectBonusNumber) }
    }

    @ParameterizedTest
    @CsvSource(value = ["0", "-1", "-99", "46", "47", "50", "500"])
    fun `보너스 번호가 1과 45 사이의 정수가 아니라면 IllegalArgumentException을 발생시킨다`(incorrectBonusNumber: String) {
        assertThrows<IllegalArgumentException> { InputValidator().validateBonusNumber(incorrectBonusNumber) }
    }

    @ParameterizedTest
    @CsvSource(value = ["1", "22", "3", "44", "45", "6"])
    fun `보너스 번호가 1과 45 사이의 정수라면 예외를 발생시키지 않는다`(incorrectBonusNumber: String) {
        assertDoesNotThrow { InputValidator().validateBonusNumber(incorrectBonusNumber) }

    }

    companion object {
        @JvmStatic
        fun generateCorrectLottoNumbers(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf("1", "4", "14", "15", "23", "45"),
                ),
                Arguments.of(
                    listOf("1", "4", "14", "15", "23", "45"),
                )
            )

        @JvmStatic
        fun generateWrongFormatLottoNumbers(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    emptyList<Int>(),
                ),
                Arguments.of(
                    listOf("a, b", "cd", "ef"),
                ),
                Arguments.of(
                    listOf(" ", ""),
                )
            )

        @JvmStatic
        fun generateWrongNumberLottoNumbers(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf("0", "10", "30", "40", "45", "46"),
                ),
                Arguments.of(
                    listOf("-1", "0", "-88", "100", "76", "151"),
                ),
                Arguments.of(
                    listOf("1", "2", "3", "4", "5", "6", "7"),
                )
            )
    }
}