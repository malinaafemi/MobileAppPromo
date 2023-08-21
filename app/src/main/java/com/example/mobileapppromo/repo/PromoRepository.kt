package com.example.mobileapppromo.repo

import android.util.Log
import com.example.mobileapppromo.data.remote.PromoService
import com.example.mobileapppromo.data.remote.models.PromoModel
import com.example.mobileapppromo.domain.items.PromoItem
import com.example.mobileapppromo.domain.items.SpecificPromoItem
import com.example.mobileapppromo.domain.items.toPromoItem
import com.example.mobileapppromo.domain.items.toSpecificPromoItem
import javax.inject.Inject

class PromoRepository @Inject constructor(private val promoService: PromoService) {

    suspend fun getPromos(): List<PromoItem> {

        return promoService.getPromos().map {
            it.toPromoItem()
        }

    }

    suspend fun getPromoById(id: Int): SpecificPromoItem {
        Log.d("PromoRepository", "Id: $id")
        val response = promoService.getPromoById(id)
        Log.d("PromoRepository", "Response: $response")
        return promoService.getPromoById(id).toSpecificPromoItem()

    }
}