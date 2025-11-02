package lotto.view

class InputValidator {
    fun validatePurchaseMoney(purchaseMoney: String) {
        require(purchaseMoney.isNotBlank()) { "[ERROR] 빈칸을 입력할 수 없습니다." }
        require(purchaseMoney.toIntOrNull() != null) { "[ERROR] 정수를 입력하셔야 합니다." }
        require(checkFallApartWithLottoPrice(purchaseMoney.toInt())) { "[ERROR] 1000원 단위로 입력하셔야 합니다." }
        require(purchaseMoney.toInt() > 0) { "[ERROR] 양수를 입력하셔야 합니다." }
    }

    fun validateWinningNumbers(winningNumbers: List<String>) {
        require(winningNumbers.isNotEmpty()) { "[ERROR] 숫자를 입력하셔야 합니다." }
        for (winningNumber in winningNumbers) {
            require(winningNumber.toIntOrNull() != null) { "[ERROR] 빈칸을 입력할 수 없습니다." }
            require(winningNumber.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "[ERROR] 1~45 사이의 정수를 입력하셔야 합니다." }
        }
        require(winningNumbers.size <= MAX_LOTTO_NUMBER_COUNT) { "[ERROR] 당첨 번호는 6개여야 합니다." }
    }

    fun validateBonusNumber(bonusNumber: String) {
        require(bonusNumber.isNotBlank()) { "[ERROR] 빈칸을 입력할 수 없습니다." }
        require(bonusNumber.toIntOrNull() != null) { "[ERROR] 정수를 입력하셔야 합니다." }
        require(bonusNumber.toInt() in MIN_LOTTO_NUMBER .. MAX_LOTTO_NUMBER) { "[ERROR] 1~45 사이의 정수를 입력하셔야 합니다." }
    }

    private fun checkFallApartWithLottoPrice(money: Int): Boolean = money % ONE_LOTTO_MONEY == 0

    companion object {
        private const val ONE_LOTTO_MONEY = 1000
        private const val MAX_LOTTO_NUMBER = 45
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER_COUNT = 6
    }
}