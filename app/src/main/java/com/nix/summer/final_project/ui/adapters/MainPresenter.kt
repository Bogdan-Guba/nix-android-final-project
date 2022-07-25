package com.nix.summer.final_project.ui.adapters

import com.nix.summer.final_project.core.entities.Order
import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.core.interactors.*


class MainPresenter(private val mBuy: BuyCoffeeInteractor,
                    private val mFill: FillResourcesInteractor,
                    private val mInfo: ShowResourcesInteractor,
                    private val mTake: TakeMoneyInteractor,
                    private val mSet: SetResourcesInteractor) : Contract.Presenter {

    private var view: Contract.View ?= null

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    fun start() {
        mSet(Resources())
        remaining()
    }

    fun buy(order: Order) {
        view?.showInfo(mBuy(order).notify)
        remaining()
    }

    fun fill(resources: Resources) {
        view?.showInfo(mFill(resources).notify)
        remaining()
    }

    fun take() {
        view?.showInfo(mTake().notify)
        remaining()
    }

    private fun remaining() {
        view?.showInfoRes(mInfo().notify)
    }
}