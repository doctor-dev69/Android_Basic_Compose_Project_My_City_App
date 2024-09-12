package com.example.myhazro.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AttockCity() {
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
fun AttockCityPreview() {
    MyHazroTheme(dynamicColor = false, darkTheme = true) {
        AttockCity()
    }
}
