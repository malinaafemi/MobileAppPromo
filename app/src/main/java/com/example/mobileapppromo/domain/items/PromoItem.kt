package com.example.mobileapppromo.domain.items

import com.example.mobileapppromo.data.remote.models.Img
import com.example.mobileapppromo.data.remote.models.PromoModel

data class PromoItem(

    val id: Int,
    val nama: String,
    val img: Img,
    val desc: String
    
)

fun PromoModel.toPromoItem() = PromoItem(id, nama, img, desc)
