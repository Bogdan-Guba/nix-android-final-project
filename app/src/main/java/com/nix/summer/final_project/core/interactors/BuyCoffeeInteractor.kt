package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Coffee
import com.nix.summer.final_project.core.entities.Order
import com.nix.summer.final_project.core.entities.Response
import com.nix.summer.final_project.data.repositories.ActionRepository

class BuyCoffeeInteractor(private val repository: ActionRepository) {
    operator fun invoke(order: Order): Response {
        var response = Response("")
        if (order.choice == "1" || order.choice == "2" || order.choice == "3" || order.choice == "back") {
            when (order.choice) {
                "1" -> {
                    response = repository.makeCoffee(Coffee.ESPRESSO)
                }
                "2" -> {
                    response = repository.makeCoffee(Coffee.LATTE)
                }
                "3" -> {
                    response = repository.makeCoffee(Coffee.CAPPUCCINO)
                }
                "back" -> {
                    return response
                }
            }
        } else {
            response = Response("Invalid option.")
        }
        return response
    }
}