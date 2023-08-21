package com.example.mobileapppromo.data.remote

import android.util.Log
import com.example.mobileapppromo.data.remote.models.PromoModel
import com.example.mobileapppromo.data.remote.models.SpecificPromoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PromoService @Inject constructor(private val promoApi: PromoApi){

    suspend fun getPromos(): List<PromoModel> {

        return withContext(Dispatchers.IO) {
            val promos = promoApi.getPromos()
            promos.body() ?: emptyList()
        }

    }

    suspend fun getPromoById(id: Int): SpecificPromoModel {
        return withContext(Dispatchers.IO) {
            Log.d("PromoService", "Fetching promo with ID: $id")

            val promoResponse = promoApi.getPromoById(id)
            val promoResponseBody = promoResponse.body()

            if (promoResponse.isSuccessful) {
                Log.d("PromoService", "Promo Response Code: ${promoResponse.code()}")
                Log.d("PromoService", "Promo Response Body: $promoResponseBody")

                promoResponseBody ?: throw Exception("Promo response body is null")

            } else {
                val errorBody = promoResponse.errorBody()?.string()
                Log.e("PromoService", "Promo Error Response Code: ${promoResponse.code()}")
                Log.e("PromoService", "Promo Error Response Body: $errorBody")
                throw Exception("Promo request failed with code ${promoResponse.code()}")
            }
        }
    }

}