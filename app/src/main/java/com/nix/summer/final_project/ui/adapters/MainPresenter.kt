package com.nix.summer.final_project.ui.adapters

import com.nix.summer.final_project.core.entities.Coffee
import com.nix.summer.final_project.core.entities.Order
import com.nix.summer.final_project.core.entities.Payment
import com.nix.summer.final_project.core.entities.Resources
import com.nix.summer.final_project.core.interactors.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainPresenter(private val mBuy: BuyCoffeeInteractor,
                    private val mFill: FillResourcesInteractor,
                    private val mInfo: ShowResourcesInteractor,
                    private val mTake: TakeMoneyInteractor,
                    private val mSet: SetResourcesInteractor,
                    private val exchangeCurrencyInteractor: ExchangeCurrencyInteractor,
                    private val loadPaymentInteractor: LoadPaymentInteractor) : Contract.Presenter, CoroutineScope {

    private var view: Contract.View ?= null

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Default

    override fun attach(view: Contract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    fun start() {
        mSet(Resources())
        view?.paymentLoad()
        remaining()
    }

    fun buy(order: Order, coffee: Coffee, money: String) {
        exchangePayment(Payment(coffee.currency, coffee.money, money))
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

    private fun exchangePayment(payment: Payment) {
        launch {
            val response = exchangeCurrencyInteractor(payment)
            withContext(Dispatchers.Main) {
                view?.showData(response)
            }
        }
    }

    fun loadPayment() {
        launch {
            val response = loadPaymentInteractor()
            withContext(Dispatchers.Main) {
                view?.showData(response)
            }
        }
    }
}