package com.example.myhazro.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myhazro.R
import com.example.myhazro.data.DataSource
import com.example.myhazro.data.categoryList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_top_bar),
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
//                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onTertiaryContainer
        ),
        modifier = modifier
    )
}

//@Preview
@Composable
fun CategoryScreen(
    navController: NavHostController,
) {
    Scaffold(
        topBar = {
            CategoryTopBar()
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { it ->
        LazyColumn(
            contentPadding = it,
        ) {
            items(categoryList) { category ->
                CategoryDisplay(
                    itemList = category,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(
                                route = "recommendation_screen/${category.title}"
                            )
                        }

                )
            }
        }
    }
}

@Composable
fun CategoryDisplay(
    itemList: DataSource,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = modifier
            .padding(
                top = 4.dp,
                bottom = 20.dp,
                start = 12.dp,
                end = 12.dp
            )
    ) {
        Column(
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .size(100.dp)
            ) {
                Image(
                    painter = painterResource(id = itemList.imgRes),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)
                        .size(84.dp)
                )
                Text(
                    text = stringResource(id = itemList.title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

//@Preview
//@Composable
//private fun CateSDis() {
//    MyHazroTheme {
//    Scaffold { it ->
//        LazyColumn(contentPadding = it) {
//            items(categoryList) {
//                CategoryDisplay(
//                    categoryList = it,
//                    modifier = Modifier
//                        .padding(
//                            bottom = 20.dp,
//                            start = 8.dp,
//                            end = 8.dp
//                        )
//                )
//            }
//        }
//    }
//    }
//
//}