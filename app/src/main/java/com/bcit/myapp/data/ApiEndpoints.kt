package com.bcit.myapp.data

enum class ApiEndpoints(private val endpoint: String) {
    BASE_URL("https://www.themealdb.com/api/json/v1/1/search.php?s="),
    MEAL("");

    fun withMealName(mealName: String): String {
        return when (this) {
            MEAL -> "${BASE_URL.endpoint}$mealName"
            else -> this.endpoint
        }
    }

    fun withMealList(): String {
        return when (this) {
            MEAL -> BASE_URL.endpoint
            else -> this.endpoint
        }
    }
}



