package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.data.repositories.ActionRepository

class SetResourcesInteractor(private val repository: ActionRepository) {
    operator fun invoke(resources: Resources) {
        repository.setData(resources)
    }
}