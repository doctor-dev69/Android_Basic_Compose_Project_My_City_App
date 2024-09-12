package com.example.mycityai.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
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
fun ItemScreen(
    viewModel: MainViewModel,
    item: Item,
    navController: NavController,
    onClicked: () -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(item.title) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
        LazyColumn {
            items(item.recommendations) { recommendation ->
                Card(
                    onClick = onClicked
                ) {
                    ListItem(
                        leadingContent = { Image(painter = painterResource(id = recommendation.image), contentDescription = recommendation.name) },
                        headlineContent = { Text(recommendation.name) },
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun ItemPrev() {
//    ItemScreen(
//        item = Item(
//            title = "abc",
//            image = R.drawable.tea_shops,
//            recommendations = listOf(
//                Recommendation(
//                    name = "a",
//                    image = R.drawable.recommendation_1,
//                    details = "king"
//                )
//            )
//        ),
//        navController = rememberNavController(),
//        onClicked = {}
//    )
//}