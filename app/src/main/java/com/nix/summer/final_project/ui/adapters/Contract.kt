package com.nix.summer.final_project.ui.adapters

import com.nix.summer.final_project.core.entities.Response

class Contract {

    interface View {

        fun buy()

        fun fill()

        fun take()

        fun paymentLoad()

        fun showInfoRes(info: String)

        fun showInfo(info: String)

        fun showData(response: Response)
    }

    interface Presenter {

        fun attach(view: View)

        fun detach()

    }
}