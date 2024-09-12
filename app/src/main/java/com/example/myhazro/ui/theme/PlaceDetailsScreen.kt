package com.example.myhazro.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myhazro.R
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceTopAppBar(
    navController: NavHostController,
    title: Int,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Icon",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
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
fun PlaceDetailScreen(
    navController: NavHostController,
    title: Int
) {
    Scaffold(
        topBar = {
            PlaceTopAppBar(navController = navController, title = title)
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        if (title == R.string.tea_shop_1) {
            ImgAndText(
                img = painterResource(id = R.drawable.cafeee),
                text = "This is the details of tea shop 1"
            )
        } else if (title == R.string.tea_shop_2) {
            ImgAndText(
                img = painterResource(id = R.drawable.cafeee),
                text = "This is the details of tea shop 2"
            )
        } else if (title == R.string.tea_shop_3) {
            ImgAndText(
                img = painterResource(id = R.drawable.recommendation2),
                text = "This is the details of tea shop 3"
            )
        } else if (title == R.string.pizza_shop_1) {
            ImgAndText(
                img = painterResource(id = R.drawable.recommendation2),
                text = "This is the details of pizza shop 1"
            )
        } else if (title == R.string.pizza_shop_2) {
            ImgAndText(
                img = painterResource(id = R.drawable.recommendation2),
                text = "This is the details of pizza shop 2"
            )
        }

    }
    }
}

@Composable
fun ImgAndText(
    img: Painter,
    contentDesc: String = "",
    text: String
    ) {
    Image(
        painter = img,
        contentDescription = contentDesc,
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp))
    )

    Spacer(modifier = Modifier.height(12.dp))

    Text(
        modifier = Modifier.padding(12.dp),
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold
    )
}