package com.nix.summer.final_project.data.repositories

import com.nix.summer.final_project.core.entities.Coffee
import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.core.entities.Response

class FakeActionRepositoryImplementation: ActionRepository {

    object CoffeeMachine {
        var water = 0
        var milk = 0
        var coffeeBeans = 0
        var cups = 0
        var money = 0f
    }

    override fun setData(resources: Resources) {
        CoffeeMachine.water = resources.water
        CoffeeMachine.milk = resources.milk
        CoffeeMachine.coffeeBeans = resources.coffeeBeans
        CoffeeMachine.cups = resources.cups
        CoffeeMachine.money = resources.money
    }

    override fun coffeeMachineRemaining (): String {
        return "${CoffeeMachine.water} of water\n" +
                "${CoffeeMachine.milk} of milk\n" +
                "${CoffeeMachine.coffeeBeans} of coffee beans\n" +
                "${CoffeeMachine.cups} of disposable cups\n" +
                "${CoffeeMachine.money} of money"
    }

    override fun makeCoffee(coffeeType: Coffee): Response {
        if (coffeeType.water > CoffeeMachine.water) {
            return Response("Sorry, not enough water!")
        } else if (coffeeType.milk > CoffeeMachine.milk) {
            return Response("Sorry, not enough milk!")
        } else if (coffeeType.coffeeBeans > CoffeeMachine.coffeeBeans) {
            return Response("Sorry, not enough coffee beans!")
        } else if (CoffeeMachine.cups < 1) {
            return Response("Sorry, not enough disposable cups!")
        }  else {
            CoffeeMachine.cups -= 1
            CoffeeMachine.water -= coffeeType.water
            CoffeeMachine.coffeeBeans -= coffeeType.coffeeBeans
            CoffeeMachine.milk -= coffeeType.milk
            CoffeeMachine.money += coffeeType.money
            return Response("I have enough resources, making you a coffee!")
        }
    }

    override fun fill(resources: Resources): Response {
        CoffeeMachine.water += resources.water
        CoffeeMachine.milk += resources.milk
        CoffeeMachine.coffeeBeans += resources.coffeeBeans
        CoffeeMachine.cups += resources.cups
        return Response("Resources replenished.")
    }

    override fun take(): Response {
        val response = Response("I gave you ${CoffeeMachine.money} USD")

        CoffeeMachine.money = 0f
        return response
    }
}