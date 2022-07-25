package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Response
import com.nix.summer.final_project.data.repositories.PaymentRepository

class LoadPaymentInteractor(private val repository: PaymentRepository) {

    operator fun invoke(): Response {
        val payment = repository.loadPayment()
        return Response(notify = "Last time pay: ${payment?.amount ?: "None"} " +
                (payment?.currency ?: "Never paid before")
        )
    }
}
