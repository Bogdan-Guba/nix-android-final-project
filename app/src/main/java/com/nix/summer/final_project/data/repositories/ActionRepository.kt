package com.nix.summer.final_project.data.repositories

import com.nix.summer.final_project.core.entities.Coffee
import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.core.entities.Response

interface  ActionRepository {

    fun setData(resources: Resources)

    fun coffeeMachineRemaining (): String

    fun makeCoffee(coffeeType: Coffee): Response

    fun fill(resources: Resources): Response

    fun take(): Response
}