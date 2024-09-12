package com.example.myhazro.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun HazroApp() {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "category_screen") {
                composable("category_screen") {
                    CategoryScreen(navController)

                }
                composable(
                    route = "recommendation_screen/{title}",
                    arguments = listOf(navArgument("title") {type = NavType.IntType})
                ) { backStackEntry ->
                    val title = backStackEntry.arguments?.getInt("title")
                    if (title != null) {
                        RecommendationScreen(navController, title)
                    }
                }
                composable(
                    route = "place_detail_screen/{title}",
                    arguments = listOf(navArgument("title") {type = NavType.IntType})
                ) { backStackEntry ->
                    val title = backStackEntry.arguments?.getInt("title")
                    if (title != null) {
                        PlaceDetailScreen(navController, title)
                    }
                }
            }
        }

@Preview(showSystemUi = true)
@Composable
fun HazroPreview() {
    MyHazroTheme(dynamicColor = false, darkTheme = true) {
        HazroApp()
    }
}
