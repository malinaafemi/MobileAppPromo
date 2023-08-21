package com.example.mobileapppromo.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobileapppromo.ui.screens.DetailScreen
import com.example.mobileapppromo.ui.screens.HomeScreen
import com.example.mobileapppromo.ui.vm.PromoViewModel
import com.example.mobileapppromo.util.Constants.Companion.KEY_PROMO_ID
import com.example.mobileapppromo.util.Constants.Screens.DETAIL_SCREEN
import com.example.mobileapppromo.util.Constants.Screens.HOME_SCREEN

sealed class Screens (val route: String) {

    object Home: Screens(route = HOME_SCREEN)
    object Detail: Screens(route = DETAIL_SCREEN)

}


@Composable
fun SetupNavHost(navController: NavHostController, promoViewModel: PromoViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(promoViewModel = promoViewModel, navController = navController)
        }

        composable(route = Screens.Detail.route + "/{$KEY_PROMO_ID}") { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KEY_PROMO_ID) ?: "1", promoViewModel = promoViewModel, navController = navController)

        }

    }

}