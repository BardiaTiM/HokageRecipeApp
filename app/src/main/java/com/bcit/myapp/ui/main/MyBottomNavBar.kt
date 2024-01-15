package com.bcit.myapp.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MyBottomNavBar(navController: NavController) {

    val navItems = listOf(
        NavItem(Icons.Rounded.Home, Screen.HOME.route),
        NavItem(Icons.Rounded.Info, Screen.DISPLAY.route),
        NavItem(Icons.Rounded.List, Screen.LIST.route)
    )

    NavigationBar(
        containerColor = Color(0xFF876BB9)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route)
                },
                icon = {
                    Icon(it.icon, contentDescription = null)
                })
        }
    }
}