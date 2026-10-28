package com.airy.linestudio.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airy.linestudio.presentation.config.ConfigScreen
import com.airy.linestudio.presentation.config.ConfigViewModel
import com.airy.linestudio.presentation.display.DisplayScreen
import com.airy.linestudio.presentation.display.DisplayViewModel
import com.airy.linestudio.presentation.home.HomeScreen
import com.airy.linestudio.presentation.home.HomeViewModel
import com.airy.linestudio.ui.theme.LineStudioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LineStudioTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = AppRoute.Home.name
                    ){
                        composable(route = AppRoute.Home.name){
                            val vm: HomeViewModel = hiltViewModel(it)
                            HomeScreen(vm) { navController.navigate(AppRoute.Display.name) }
                        }
                        composable(route = AppRoute.Display.name){
                            val vm: DisplayViewModel = hiltViewModel(it)
                            DisplayScreen(vm)
                        }
                        composable(route = AppRoute.Config.name){
                            val vm: ConfigViewModel = hiltViewModel(it)
                            ConfigScreen(vm)
                        }
                    }
                }
            }
        }
    }
}