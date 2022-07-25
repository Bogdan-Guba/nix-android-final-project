package com.nix.summer.final_project.data.mappers

import com.nix.summer.final_project.core.entities.Payment
import com.nix.summer.final_project.data.database.DatabasePayment


class DatabasePaymentToPaymentMapper {

    fun toDomain(databasePayment: DatabasePayment): Payment = with(databasePayment) {
        Payment(
            currency = currency,
            amount = amount
        )
    }
}
