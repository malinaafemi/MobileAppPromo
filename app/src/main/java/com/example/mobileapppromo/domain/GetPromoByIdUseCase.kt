package com.example.mobileapppromo.domain

import android.util.Log
import com.example.mobileapppromo.domain.items.SpecificPromoItem
import com.example.mobileapppromo.repo.PromoRepository
import javax.inject.Inject

class GetPromoByIdUseCase @Inject constructor(private val promoRepository: PromoRepository) {

    suspend operator fun invoke(id: Int): SpecificPromoItem {
        val promoItem = promoRepository.getPromoById(id)
        Log.d("GetPromoByIdUseCase", "Promo Item Retrieved: $promoItem")
        return promoRepository.getPromoById(id)

    }
}