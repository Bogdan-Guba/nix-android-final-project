package com.nix.summer.final_project.data.network

import retrofit2.http.GET
import retrofit2.http.Path


interface ExchangeServiceAPI {

    @GET("pair/{exchange}")
    suspend fun exchangeCurrency(@Path("exchange") exchangeInfo: String): NetworkPayment
}
