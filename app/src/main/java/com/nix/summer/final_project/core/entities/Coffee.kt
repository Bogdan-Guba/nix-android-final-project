package com.nix.summer.final_project.core.entities

enum class Coffee(val water: Int, val coffeeBeans: Int, val milk: Int, val money: Float, val currency: String) {
    ESPRESSO(250, 16, 0, 4f, "USD"),
    LATTE(350, 20, 75, 7f,"USD"),
    CAPPUCCINO(200, 12, 100, 6f,"USD");
}