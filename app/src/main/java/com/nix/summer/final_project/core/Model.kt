package com.nix.summer.final_project.core

import com.nix.summer.final_project.core.entities.Coffee
import com.nix.summer.final_project.core.entities.Order
import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.core.entities.Response

class Model {

    private val res = Resources.ChangeRes()

    fun setData() {
        val resources = Resources()
        res.water = resources.water
        res.coffeeBeans = resources.coffeeBeans
        res.milk = resources.milk
        res.cups = resources.cups
        res.money = resources.money
    }

    fun coffeeMachineRemaining (): String {
        return "${res.water} of water\n" +
                "${res.milk} of milk\n" +
                "${res.coffeeBeans} of coffee beans\n" +
                "${res.cups} of disposable cups\n" +
                "${res.money} of money"
    }

    fun buy(order: Order): Response {
        var response = Response("")
        if (order.choice == "1" || order.choice == "2" || order.choice == "3" || order.choice == "back") {
            when (order.choice) {
                "1" -> {
                    response = makeCoffee(Coffee.ESPRESSO)
                }
                "2" -> {
                    response = makeCoffee(Coffee.LATTE)
                }
                "3" -> {
                    response = makeCoffee(Coffee.CAPPUCCINO)
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

    private fun makeCoffee(coffeeType: Coffee): Response {
        if (coffeeType.water > res.water) {
            return Response("Sorry, not enough water!")
        } else if (coffeeType.milk > res.milk) {
            return Response("Sorry, not enough milk!")
        } else if (coffeeType.coffeeBeans > res.coffeeBeans) {
            return Response("Sorry, not enough coffee beans!")
        } else if (res.cups < 1) {
            return Response("Sorry, not enough disposable cups!")
        }  else {
            res.cups -= 1
            res.water -= coffeeType.water
            res.coffeeBeans -= coffeeType.coffeeBeans
            res.milk -= coffeeType.milk
            res.money += coffeeType.money
            return Response("I have enough resources, making you a coffee!")
        }
    }

    fun fill(resources: Resources.ChangeRes): Response {
        res.water += resources.water
        res.milk += resources.milk
        res.coffeeBeans += resources.coffeeBeans
        res.cups += resources.cups
        return Response("Resources replenished.")
    }

    fun take(): Response {
        val response = Response("I gave you ${res.money}")
        res.money = 0
        return response
    }
}