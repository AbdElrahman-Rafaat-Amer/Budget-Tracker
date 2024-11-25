package com.abdelrahman.raafat.budget.tracker.ui.dashboard.item

data class BudgetExpense(
    var price: Double,
    var totalPrice: Double,
    var shouldAnimate: Boolean = calculateShouldAnimate(price, totalPrice),
    var angleValue: Float = calculateAngleValue(price, totalPrice)
) {
    companion object {
        /**
         * Calculates whether animation should occur based on price and totalPrice.
         */
        private fun calculateShouldAnimate(price: Double, totalPrice: Double): Boolean {
            return price > 0 && totalPrice > 0
        }

        /**
         * Calculates the angle value based on price and totalPrice.
         * Ensures the result is between 0 and 180 degrees.
         */
        private fun calculateAngleValue(price: Double, totalPrice: Double): Float {
            val percentage = price / totalPrice * 180
            val angle = percentage.toFloat().coerceIn(0f, 180f)
            return angle
        }
    }
}

