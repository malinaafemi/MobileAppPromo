package com.example.mobileapppromo.ui.screens



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mobileapppromo.domain.items.PromoItem
import com.example.mobileapppromo.ui.nav.Screens
import com.example.mobileapppromo.ui.vm.PromoViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(promoViewModel: PromoViewModel, navController: NavController) {

    val promos = promoViewModel.promos.observeAsState(listOf()).value
    val isLoading = promoViewModel.isLoading.observeAsState(false).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Special Promo",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                }
            )
        }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(promos) { promo ->
                PromoCard(promo = promo, navController = navController)
            }
        }

        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = Color(android.graphics.Color.parseColor("#e36414"))
            )
        }
    }
}

@Composable
fun PromoCard(promo: PromoItem, navController: NavController) {
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, start = 14.dp, end = 14.dp)
            .clickable {
                navController.navigate(Screens.Detail.route + "/${promo.id}")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (promo == null) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Image(
                    painter = rememberImagePainter(data = promo.img.formats.medium.url),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(125.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    Text(text = promo.nama, fontWeight = FontWeight.Bold, style = TextStyle(fontSize = 17.sp))
                    Text(text = promo.desc, maxLines = 2, overflow = TextOverflow.Ellipsis, style = TextStyle(fontSize = 14.sp))
                }
            }

        }
    }
}






