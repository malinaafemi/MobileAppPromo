package com.example.mobileapppromo.domain.items

import com.example.mobileapppromo.data.remote.models.Img
import com.example.mobileapppromo.data.remote.models.SpecificPromoModel

data class SpecificPromoItem(

    val id: Int,
    val nama: String,
    val img: Img,
    val desc: String

)

fun SpecificPromoModel.toSpecificPromoItem() = SpecificPromoItem(id, nama, img, desc)
