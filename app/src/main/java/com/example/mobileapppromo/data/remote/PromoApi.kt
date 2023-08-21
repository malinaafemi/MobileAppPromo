package com.example.mobileapppromo.data.remote

import com.example.mobileapppromo.data.remote.models.SpecificPromoModel
import com.example.mobileapppromo.util.Constants.Companion.PROMOS_ENDPOINT
import com.example.mobileapppromo.util.Constants.Companion.PROMO_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.mobileapppromo.data.remote.models.PromoModel as PromoModel

interface PromoApi {

    @GET(PROMOS_ENDPOINT)
    suspend fun getPromos(): Response<List<PromoModel>>

    @GET(PROMO_ID_ENDPOINT)
    suspend fun getPromoById(@Query(value = "id") id: Int) : Response<SpecificPromoModel>
}