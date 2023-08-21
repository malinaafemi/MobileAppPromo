package com.example.mobileapppromo.domain

import com.example.mobileapppromo.domain.items.PromoItem
import com.example.mobileapppromo.repo.PromoRepository
import javax.inject.Inject

class GetPromosUseCase @Inject constructor(private val promoRepository: PromoRepository) {

    suspend operator fun invoke(): List<PromoItem> {

        return promoRepository.getPromos().shuffled()
    }
}