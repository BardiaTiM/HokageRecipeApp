package com.bcit.myapp.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bcit.myapp.data.MealRepository
import io.ktor.client.HttpClient

data class NavItem(val icon: ImageVector, val route: String)

enum class Screen(val route: String) {
    HOME("home"),
    DISPLAY("display"),
    LIST("list"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(){
    val navController = rememberNavController()
    val mealState = remember { MealState(MealRepository(HttpClient())) }

    Scaffold (
        bottomBar = {
            MyBottomNavBar(navController = navController)
        }
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = Screen.HOME.route,
            builder = {
                composable(Screen.HOME.route) {
                    Home(navController, mealState)
                }
                composable(Screen.DISPLAY.route) {
                    Display(mealState.meal.value)
                }
                composable(Screen.LIST.route) {
                    List(navController, mealState)
                }
            })
    }

}