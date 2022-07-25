package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.core.entities.Response
import com.nix.summer.final_project.data.repositories.ActionRepository

class FillResourcesInteractor(private val repository: ActionRepository) {
    operator fun invoke(resources: Resources): Response {
        return Response(repository.fill(resources).notify)
    }
}