package com.nix.summer.final_project.data.mappers

import com.nix.summer.final_project.core.entities.Payment
import com.nix.summer.final_project.data.database.DatabasePayment

class PaymentToDatabasePaymentMapper {
    fun toData(payment: Payment): DatabasePayment = with(payment) {
        DatabasePayment(
            currency = currency,
            amount = amount
        )
    }
}
