package com.example.mycityai.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mycityai.MainActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
//    navController: NavController,
    onClicked: () -> Unit
) {
    Column {
        TopAppBar(title = { Text("My City") })
        LazyColumn {
            items(viewModel.items) { item ->
                Card(
                    onClick = onClicked,
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                ) {
                ListItem(
                    leadingContent = {
                        Image(painter = painterResource(id = item.image),
                            contentDescription = item.title)
                                     },
                    headlineContent = { Text(item.title) },
                )
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//private fun HomePrev() {
//    val navController = rememberNavController()
//    HomeScreen(viewModel = MainViewModel()
//        ,navController = navController )
//}