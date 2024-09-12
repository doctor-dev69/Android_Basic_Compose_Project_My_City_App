package com.example.myhazro.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myhazro.R
import com.example.myhazro.data.DataSource
import com.example.myhazro.data.recommendationParkList
import com.example.myhazro.data.recommendationPizzaList
import com.example.myhazro.data.recommendationRestaurantList
import com.example.myhazro.data.recommendationTeaList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    title: Int
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back icon",
                    modifier = Modifier.clickable { navController.popBackStack() }
                )

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = title),
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic
//                    fontWeight = FontWeight.Bold
                    )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    )
}

//@Preview
@Composable
fun RecommendationScreen(
    navController: NavHostController,
    title: Int
) {
    val topBarTitle = title ?: R.string.default_title
    Scaffold(
        topBar = {
            RecommTopBar(navController = navController, title = topBarTitle)
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) {
        LazyColumn(contentPadding = it) {
            if (title == R.string.cat_tea) { 
                items(recommendationTeaList) { tea ->
                    RecommendationDisplay(
                        itemList = tea,
                        modifier = Modifier.clickable {
                            navController.navigate(route = "place_detail_screen/${tea.title}")
                        }
                    )
                }
            } else if (title == R.string.cat_pizza) { 
                items(recommendationPizzaList) { pizza ->
                    RecommendationDisplay(
                        itemList = pizza,
                        modifier = Modifier.clickable {
                            navController.navigate(route = "place_detail_screen/${pizza.title}")
                        }
                    )
                }
            } else if (title == R.string.cat_restaurant) {
                items(recommendationRestaurantList) { restaurant ->
                    RecommendationDisplay(
                        itemList = restaurant,
                        modifier = Modifier.clickable {
                            navController.navigate(route = "place_detail_screen/${restaurant.title}")
                        }
                    )
                }
            } else {
                items(recommendationParkList) { park ->
                    RecommendationDisplay(
                        itemList = park,
                        modifier = Modifier.clickable {
                            navController.navigate(route = "place_detail_screen/${park.title}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RecommendationDisplay(
    itemList: DataSource,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(
                start = 12.dp,
                top = 4.dp,
                bottom = 20.dp,
                end = 12.dp
            ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .size(100.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = itemList.imgRes),
                    contentDescription = "nothing",
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(84.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                
                Text(
                    text = stringResource(id = itemList.title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
