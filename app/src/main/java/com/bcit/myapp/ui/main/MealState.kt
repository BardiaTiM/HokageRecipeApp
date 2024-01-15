package com.bcit.myapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.bcit.myapp.data.Meal
import com.bcit.myapp.data.MealRepository


class MealState(private val mealRepository: MealRepository) {
    var meal: MutableState<Meal?> = mutableStateOf(null)
    var meals: MutableState<List<Meal>> = mutableStateOf(emptyList())

    suspend fun getMealByName(mealName: String) {
        meal.value = mealRepository.getMeal(mealName)
    }

    suspend fun getAllMeals() {
        meals.value = mealRepository.getMealList()
    }

}
