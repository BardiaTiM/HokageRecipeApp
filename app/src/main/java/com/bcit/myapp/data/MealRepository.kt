package com.bcit.myapp.data

import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class MealRepository(private val client: HttpClient) {

    suspend fun getMeal(mealName: String): Meal? {
        val url = ApiEndpoints.MEAL.withMealName(mealName)
        val response: String = client.get(url).bodyAsText()
        val gson = Gson()

        // Parse the JSON response to get the meals list
        val mealResponse = gson.fromJson(response, MealResponse::class.java)

        // Return the first meal in the list, or null if the list is empty
        return mealResponse.meals.firstOrNull()
    }

    suspend fun getMealList(): List<Meal> {
        val url = ApiEndpoints.MEAL.withMealList()
        val response: String = client.get(url).bodyAsText()
        val gson = Gson()

        val mealResponse = gson.fromJson(response, MealResponse::class.java)

        return mealResponse.meals
    }

}