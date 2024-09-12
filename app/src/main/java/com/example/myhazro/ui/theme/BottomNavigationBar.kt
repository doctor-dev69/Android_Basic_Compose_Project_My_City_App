package com.example.myhazro.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myhazro.data.BottomNavigation

val items = listOf(
    BottomNavigation(
        title = "Home",
        selectedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavigation(
        title = "Place",
        selectedIcon = Icons.Rounded.Place,
        unselectedIcon = Icons.Outlined.Place
    ),
     BottomNavigation(
         title = "Account",
         selectedIcon = Icons.Rounded.AccountCircle,
         unselectedIcon = Icons.Outlined.AccountCircle
    ),
)
@Composable
fun BottomNavigationBar() {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.tertiaryContainer)) {
            items.forEachIndexed{ index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = { selectedItemIndex = index },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}