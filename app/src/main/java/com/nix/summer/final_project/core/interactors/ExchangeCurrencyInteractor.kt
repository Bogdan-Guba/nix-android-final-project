package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Payment
import com.nix.summer.final_project.core.entities.Response
import com.nix.summer.final_project.data.repositories.PaymentRepository

class ExchangeCurrencyInteractor(private val repository: PaymentRepository) {

    suspend operator fun invoke(payment: Payment): Response {
        val exchangedPayment = if (payment.currency != payment.currencyDefault) {
            repository.makeNetworkExchange(payment)
        } else {
            payment
        }
        return with(exchangedPayment) {
            Response(
                notify = "You payed $amount $currency"
            )
        }
    }
}

