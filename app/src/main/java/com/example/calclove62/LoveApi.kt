package com.example.calclove62

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getCompatibility(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "5bf2209a58mshe67b15e140d77bep1f4a07jsn1ba46da9a7a8",
        @Header("X-RapidAPI-Host") host: String= "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}