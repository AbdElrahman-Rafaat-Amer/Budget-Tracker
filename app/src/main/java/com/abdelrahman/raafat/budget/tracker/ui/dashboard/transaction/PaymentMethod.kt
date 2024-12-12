package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import com.abdelrahman.raafat.budget.tracker.R

enum class PaymentMethod(
    val titleResId: Int,
) {
    // Income-Related Methods
    CASH(R.string.cash),
    CHEQUE(R.string.cheque),
    DIRECT_DEPOSIT(R.string.direct_deposit),
    MOBILE_WALLET(R.string.mobile_wallet),
    CREDIT_CARD(R.string.credit_card),
    DEBIT_CARD(R.string.debit_card),
    UPI(R.string.upi), // (Unified Payments Interface) (e.g., Google Pay, PhonePe, Paytm in India)
    BANK_TRANSFER(R.string.bank_transfer),
    INSTALLMENTS(R.string.installments),
    LOAN_PAYMENT(R.string.loan_payment),
    CRYPTOCURRENCY(R.string.cryptocurrency),
    OTHER(R.string.other),
    UNDEFINED(titleResId = R.string.undefined),
    ;

    companion object {
        fun fromType(name: String): PaymentMethod = PaymentMethod.entries.find { it.name == name } ?: OTHER
    }
}
