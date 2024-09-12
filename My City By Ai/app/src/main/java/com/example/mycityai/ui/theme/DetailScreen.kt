package com.example.mycityai.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycityai.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
//    item: Item,
    recommendation: Recommendation,
    navController: NavController
) {
    Column {
        TopAppBar(
            title = { Text(recommendation.name) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
        Image(painter = painterResource(id = recommendation.image), contentDescription = recommendation.name)
        Text(recommendation.details)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailPrev() {
    DetailScreen(
        recommendation = Recommendation("new", R.drawable.recommendation_3, "not"),
        navController = rememberNavController()
    )
}