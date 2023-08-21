package com.example.mobileapppromo.ui.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapppromo.domain.GetPromoByIdUseCase
import com.example.mobileapppromo.domain.GetPromosUseCase
import com.example.mobileapppromo.domain.items.PromoItem
import com.example.mobileapppromo.domain.items.SpecificPromoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor(

    private val getPromosUseCase: GetPromosUseCase,
    private val getPromoByIdUseCase: GetPromoByIdUseCase

    ) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _promos = MutableLiveData<List<PromoItem>>()
    val promos: LiveData<List<PromoItem>> get() = _promos

    private val _promo = MutableLiveData<SpecificPromoItem>()
    val promo: LiveData<SpecificPromoItem> get() = _promo

    init {
        getPromos()
    }

    private fun getPromos() {

        viewModelScope.launch {

            try {
                _isLoading.value = true
                val promos = getPromosUseCase()
                _promos.value = promos

            } catch (_: Exception) {

            } finally {
                _isLoading.value = false
            }

        }

    }

    fun getPromoById(id: Int) {

        viewModelScope.launch {

            try {

                val promo = getPromoByIdUseCase(id)
                _promo.value = promo
                Log.d("PromoViewModel", "Promo loaded: $promo")

            } catch (e: Exception) {
                Log.d("PromoViewModel", "Promo Id: $id")
                Log.e("PromoViewModel", "Error loading promo", e)
            }

        }

    }

}