package com.example.mycityai.ui.theme

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycityai.R

enum class MyCityScreen(@StringRes val title: Int) {
    Start(R.string.app_name),
    ItemsScreen(R.string.items_screen),
    Details(R.string.detail_screen)
}

@Composable
fun MyCityApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Start.name
    )

    val viewModel: MainViewModel = viewModel()
    
    NavHost(navController = navController, startDestination = MyCityScreen.Start.name) {
        composable(route = MyCityScreen.Start.name) {
            HomeScreen(
                viewModel = viewModel,
//                navController = navController,
                onClicked = {navController.navigate(MyCityScreen.ItemsScreen.name)}
            )
        }

        composable(route = MyCityScreen.ItemsScreen.name) {
            ItemScreen(
                viewModel = viewModel,
                item = Item(
                title = "Tea Shops",
                image = R.drawable.tea_shops,
                recommendations = listOf(
                    Recommendation(
                        name = "a",
                        image = R.drawable.recommendation_1,
                        details = "king"
                    )
                )
            ),
                navController = navController,
                onClicked = {
                    navController.navigate(MyCityScreen.Details.name)
                }
            )
        }
    }
}