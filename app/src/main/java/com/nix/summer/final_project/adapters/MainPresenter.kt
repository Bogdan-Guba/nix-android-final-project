package com.nix.summer.final_project.adapters

import com.nix.summer.final_project.core.Model
import com.nix.summer.final_project.core.entities.Order
import com.nix.summer.final_project.core.entities.Resources


class MainPresenter(private val model: Model) : Contract.Presenter {

    private var view: Contract.View ?= null

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    fun start() {
        setData()
        remaining()
    }

    private fun setData() {
        model.setData()
    }

    fun buy(order: Order) {
        view?.showInfo(model.buy(order).notify)
        remaining()
    }

    fun fill(resources: Resources.ChangeRes) {
        view?.showInfo(model.fill(resources).notify)
        remaining()
    }

    fun take() {
        view?.showInfo(model.take().notify)
        remaining()
    }

    private fun remaining() {
        view?.showInfoRes(model.coffeeMachineRemaining())
    }
}