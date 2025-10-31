package lotto

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputValidatorTest {
    // 구입 금액 값 테스트
    @ParameterizedTest
    @CsvSource(value = [])
    fun `구입 금액 값이 정수로 주어지지 않으면 IllegalArgumentException을 발생시킨다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `구입 금액 값이 정상적으로 들어오면 예외를 발생시키지 않는다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `구입 금액 값이 1,000 단위로 주어지지 않으면 IllegalArgumentException을 발생시킨다`() {

    }

    // 로또 정답 번호 값 테스트
    @ParameterizedTest
    @CsvSource(value = [])
    fun `로또 정답 번호들이 1과 45 사이의 수를 벗어나면 IllegalArgumentException을 발생시킨다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `로또 정답 번호가 정수가 아니라면 IllegalArgumentException을 발생시킨다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `로또 정답 번호가 6개가 아니라면 IllegalArgumentException을 발생시킨다`() {

    }


    @ParameterizedTest
    @CsvSource(value = [])
    fun `로또 정답 번호가 1과 45 사이의 수를 벗어나지 않는다면 예외를 발생시키지 않는다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `로또 정답 번호가 6개라면 예외를 발생시키지 않는다`() {

    }

    // 보너스 번호 테스트
    @ParameterizedTest
    @CsvSource(value = [])
    fun `보너스 번호가 정수가 아니라면 IllegalArgumentException을 발생시킨다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `보너스 번호가 1과 45 사이의 정수가 아니라면 IllegalArgumentException을 발생시킨다`() {

    }

    @ParameterizedTest
    @CsvSource(value = [])
    fun `보너스 번호가 1과 45 사이의 정수라면 예외를 발생시키지 않는다`() {

    }
}