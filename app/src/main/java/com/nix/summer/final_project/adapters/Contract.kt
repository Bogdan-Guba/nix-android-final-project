package com.nix.summer.final_project.adapters

class Contract {

    interface View {

        var presenter: MainPresenter

        fun buy()

        fun fill()

        fun take()

        fun showInfoRes(info: String)

        fun showInfo(info: String)

    }

    interface Presenter {

        fun attach(view: View)

        fun detach()

    }
}