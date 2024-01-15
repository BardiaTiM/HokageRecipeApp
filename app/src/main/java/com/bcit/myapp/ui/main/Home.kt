package com.bcit.myapp.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bcit.myapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.internal.wait

@Composable
fun Home(navController: NavController, mealState: MealState) {
    var searchText by remember { mutableStateOf("") }

    Box(modifier = Modifier.background(Color(0xFF1B2639)).fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hokage Recipe",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFDDD6D6)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .clip(shape = CircleShape)
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 450.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            // Search Box
            SearchBox(searchText = searchText, onSearchTextChanged = { newText ->
                searchText = newText
            })

            Button(
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFD26700),
                ),
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        mealState.getMealByName(searchText)
                        //Suspend here until the food is gathered from API
                        withContext(Dispatchers.Main) {
                            navController.navigate(Screen.DISPLAY.route)
                        }
                    }
                }) {
                Text("Search")
            }

        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(searchText: String, onSearchTextChanged: (String) -> Unit) {
    Column {
        // Search Box
        TextField(
            value = searchText,
            onValueChange = { newText ->
                onSearchTextChanged(newText) // Call the callback function with the new text
            },
            placeholder = {
                Text(text = "Search a meal...")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

