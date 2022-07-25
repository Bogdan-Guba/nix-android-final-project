package com.nix.summer.final_project.core.entities

enum class Coffee(val water: Int, val coffeeBeans: Int, val milk: Int, val money: Int) {
    ESPRESSO(250, 16, 0, 4),
    LATTE(350, 20, 75, 7),
    CAPPUCCINO(200, 12, 100, 6);
}