package com.nix.summer.final_project.data.repositories

import com.nix.summer.final_project.core.entities.Payment

interface PaymentRepository {

    suspend fun makeNetworkExchange(payment: Payment): Payment

}