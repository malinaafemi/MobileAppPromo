package com.example.mobileapppromo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mobileapppromo.ui.nav.SetupNavHost
import com.example.mobileapppromo.ui.theme.ConsumeApiJetpackComposeNavigationTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ConsumeApiJetpackComposeNavigationTutorialTheme {

                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {

                    val navController = rememberNavController()
                    SetupNavHost(navController = navController, promoViewModel = viewModel())

                }

            }

        }

    }

}

