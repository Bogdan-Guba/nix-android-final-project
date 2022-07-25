package com.nix.summer.final_project.core.entities

data class Payment (
    val currencyDefault: String = "USD",
    val amount: Float,
    val currency: String
)
