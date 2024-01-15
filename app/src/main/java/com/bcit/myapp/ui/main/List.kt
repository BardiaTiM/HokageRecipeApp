package com.bcit.myapp.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.bcit.myapp.data.Meal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun List(navController: NavController, mealState: MealState) {
    Box(modifier = Modifier.background(Color(0xFF1B2639)).fillMaxSize()) {
        LaunchedEffect(key1 = true) {
            mealState.getAllMeals()
        }

        val meals = mealState.meals.value

        if (meals.isNotEmpty()) {
            LazyColumn {
                items(meals) { meal ->
                    MealItem(meal = meal) {
                        CoroutineScope(Dispatchers.IO).launch {
                            mealState.getMealByName(meal.strMeal)
                            withContext(Dispatchers.Main) {
                                navController.navigate(Screen.DISPLAY.route)
                            }
                        }
                    }
                }
            }
        } else {
            Text("Loading meals...")
        }
    }
}

@Composable
fun MealItem(meal: Meal, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = meal.strMeal)
        }
    }
}
