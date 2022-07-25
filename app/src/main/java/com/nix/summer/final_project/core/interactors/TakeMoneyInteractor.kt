package com.nix.summer.final_project.core.interactors

import com.nix.summer.final_project.core.entities.Response
import com.nix.summer.final_project.data.repositories.ActionRepository

class TakeMoneyInteractor(private var repository: ActionRepository) {
    operator fun invoke(): Response {
        return repository.take()
    }
}