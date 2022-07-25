package com.nix.summer.final_project

class Controller(private val model: Model) {
    private lateinit var view: MainActivity

    //  The start function is responsible for starting
    fun start() {
        setData()
        remaining()
    }

    //  AttachView - public function to initialize view.
    fun attachView(_view: MainActivity) {
        view = _view
    }

    // Setting default values.
    private fun setData() {
        model.setData()
    }

    // Choosing and buying coffee.
    fun buy(order: Order) {
        view.showInfo(model.buy(order).notify)
        remaining()
    }

    // Filling: Water, milk, cofBeans, cups.
    fun fill(resources: Resources.ChangeRes) {
        view.showInfo(model.fill(resources).notify)
        remaining()
    }

    //  Withdrawal Processor.
    fun take() {
        view.showInfo(model.take().notify)
        remaining()
    }

    //  Information about resources and exhale them to the screen
    private fun remaining() {
        view.showInfoRes(model.coffeeMachineRemaining())
    }
}