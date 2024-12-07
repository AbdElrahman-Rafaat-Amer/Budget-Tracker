package com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction

import com.abdelrahman.raafat.budget.tracker.R
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.TransactionType.EXPENSE
import com.abdelrahman.raafat.budget.tracker.ui.dashboard.transaction.TransactionType.INCOME

enum class PaymentMethod(
    val titleResId: Int,
    val type: TransactionType,
) {
    // Income-Related Methods
    SALARY(R.string.salary, INCOME),
    BUSINESS_PROFIT(R.string.business_profit, INCOME),
    INVESTMENT_PROFIT(R.string.investment_profit, INCOME),
    LOAN_RECEIVED(R.string.loan_received, INCOME),
    GIFT_RECEIVED(R.string.gift_received, INCOME),
    RENTAL_INCOME(R.string.rental_income, INCOME),
    OTHER_INCOME(R.string.other_income, INCOME),
    BANK_TRANSFER_INCOME(R.string.bank_transfer, INCOME),

    // Expense-Related Methods
    CREDIT_CARD(R.string.credit_card, EXPENSE),
    DEBIT_CARD(R.string.debit_card, EXPENSE),
    UPI(R.string.upi, EXPENSE), // (Unified Payments Interface) (e.g., Google Pay, PhonePe, Paytm in India)
    MOBILE_WALLET(R.string.mobile_wallet, EXPENSE),
    CRYPTOCURRENCY(R.string.cryptocurrency, EXPENSE),
    CASH(R.string.cash, EXPENSE),
    CHEQUE(R.string.cheque, EXPENSE),
    BANK_TRANSFER(R.string.bank_transfer, EXPENSE),
    INSTALLMENTS(R.string.installments, EXPENSE),
    LOAN_PAYMENT(R.string.loan_payment, EXPENSE),
    OTHER_EXPENSE(R.string.other_expense, EXPENSE),
}
