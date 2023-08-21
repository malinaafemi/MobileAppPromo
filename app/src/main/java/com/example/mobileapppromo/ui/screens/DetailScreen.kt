package com.example.mobileapppromo.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mobileapppromo.ui.vm.PromoViewModel

@Composable
fun DetailScreen(id: String, promoViewModel: PromoViewModel, navController: NavController) {

    promoViewModel.getPromoById(id.toInt())
    Log.d("DetailScreen", "Fetching promo with ID: $id")
    val promo = promoViewModel.promo.observeAsState().value
    Log.d("DetailScreen", "data: $promo")

    
    LazyColumn {

        item {
            
            Column {

                TopAppBar(

                    navigationIcon = {
                        
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }

                    },

                    title = {

                        Text(text = promo?.nama ?: "", fontWeight = FontWeight.Bold)

                    }

                )

                val imageUrl = promo?.img?.formats?.medium?.url ?: ""
                Image(painter = rememberImagePainter(data = imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )

                Text(text = promo?.desc?: "", modifier = Modifier.padding(10.dp))
                
            }
            
        }

    }

}