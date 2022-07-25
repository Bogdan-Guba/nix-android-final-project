package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Response
import com.nix.summer.final_project.data.repositories.ActionRepository

class ShowResourcesInteractor(private val repository: ActionRepository) {
    operator fun invoke(): Response {
        return Response(repository.coffeeMachineRemaining())
    }
}