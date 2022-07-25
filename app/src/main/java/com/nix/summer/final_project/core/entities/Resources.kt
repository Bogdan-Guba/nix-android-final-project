package com.nix.summer.final_project.core.entities

data class Resources(
    val water: Int = 400,
    val milk: Int = 540,
    val coffeeBeans: Int = 120,
    val cups: Int = 9,
    val money: Int = 550) {
    data class ChangeRes(
        var water: Int = 0,
        var milk: Int = 0,
        var coffeeBeans: Int = 0,
        var cups: Int = 0,
        var money: Int= 0
    )
}
