package com.bcit.myapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bcit.myapp.data.Meal
import kotlin.reflect.full.memberProperties

@Composable
fun Display(meal: Meal?) {
    Box(modifier = Modifier
        .background(Color(0xFF1B2639))
        .fillMaxSize()) {
        if (meal != null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                // Meal Name
                item {
                    Text(
                        text = meal.strMeal,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp, top = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }

                item {
                    // Meal Image
                    AsyncImage(
                        model = meal.strMealThumb,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }

                // Ingredients and Measurements
                item {
                    Text(
                        text = "Ingredients and Measurements:",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(top = 16.dp),
                    )
                }

                val ingredientsAndMeasurements = getIngredientsAndMeasurements(meal)
                items(ingredientsAndMeasurements) { (ingredient, measurement) ->
                    Text(
                        text = "- $measurement $ingredient",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                // Instructions
                item {
                    Text(
                        text = "Instructions:",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(top = 16.dp),
                    )
                }

                item {
                    Text(
                        text = meal.strInstructions,
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(start = 16.dp),
                    )
                }
            }
        } else {
            // Show loading or blank state
            Text(
                text = "Loading meal details...",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

fun getIngredientsAndMeasurements(meal: Meal): List<Pair<String, String>> {
    val pairs = mutableListOf<Pair<String, String>>()

    if (meal.strIngredient1.isNotEmpty() && meal.strMeasure1.isNotEmpty()) pairs.add(meal.strIngredient1 to meal.strMeasure1)
    if (meal.strIngredient2.isNotEmpty() && meal.strMeasure2.isNotEmpty()) pairs.add(meal.strIngredient2 to meal.strMeasure2)
    if (meal.strIngredient3.isNotEmpty() && meal.strMeasure3.isNotEmpty()) pairs.add(meal.strIngredient3 to meal.strMeasure3)
    if (meal.strIngredient4.isNotEmpty() && meal.strMeasure4.isNotEmpty()) pairs.add(meal.strIngredient4 to meal.strMeasure4)
    if (meal.strIngredient5.isNotEmpty() && meal.strMeasure5.isNotEmpty()) pairs.add(meal.strIngredient5 to meal.strMeasure5)
    if (meal.strIngredient6.isNotEmpty() && meal.strMeasure6.isNotEmpty()) pairs.add(meal.strIngredient6 to meal.strMeasure6)
    if (meal.strIngredient7.isNotEmpty() && meal.strMeasure7.isNotEmpty()) pairs.add(meal.strIngredient7 to meal.strMeasure7)
    if (meal.strIngredient8.isNotEmpty() && meal.strMeasure8.isNotEmpty()) pairs.add(meal.strIngredient8 to meal.strMeasure8)
    if (meal.strIngredient9.isNotEmpty() && meal.strMeasure9.isNotEmpty()) pairs.add(meal.strIngredient9 to meal.strMeasure9)
    if (meal.strIngredient10.isNotEmpty() && meal.strMeasure10.isNotEmpty()) pairs.add(meal.strIngredient10 to meal.strMeasure10)
    if (meal.strIngredient11.isNotEmpty() && meal.strMeasure11.isNotEmpty()) pairs.add(meal.strIngredient11 to meal.strMeasure11)
    if (meal.strIngredient12.isNotEmpty() && meal.strMeasure12.isNotEmpty()) pairs.add(meal.strIngredient12 to meal.strMeasure12)
    if (meal.strIngredient13.isNotEmpty() && meal.strMeasure13.isNotEmpty()) pairs.add(meal.strIngredient13 to meal.strMeasure13)
    if (meal.strIngredient14.isNotEmpty() && meal.strMeasure14.isNotEmpty()) pairs.add(meal.strIngredient14 to meal.strMeasure14)
    if (meal.strIngredient15.isNotEmpty() && meal.strMeasure15.isNotEmpty()) pairs.add(meal.strIngredient15 to meal.strMeasure15)
    if (meal.strIngredient16.isNotEmpty() && meal.strMeasure16.isNotEmpty()) pairs.add(meal.strIngredient16 to meal.strMeasure16)
    if (meal.strIngredient17.isNotEmpty() && meal.strMeasure17.isNotEmpty()) pairs.add(meal.strIngredient17 to meal.strMeasure17)
    if (meal.strIngredient18.isNotEmpty() && meal.strMeasure18.isNotEmpty()) pairs.add(meal.strIngredient18 to meal.strMeasure18)
    if (meal.strIngredient19.isNotEmpty() && meal.strMeasure19.isNotEmpty()) pairs.add(meal.strIngredient19 to meal.strMeasure19)
    if (meal.strIngredient20.isNotEmpty() && meal.strMeasure20.isNotEmpty()) pairs.add(meal.strIngredient20 to meal.strMeasure20)


    return pairs
}
