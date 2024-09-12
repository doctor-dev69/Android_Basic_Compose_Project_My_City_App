package com.example.myhazro.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myhazro.R

data class DataSource(
    @StringRes val title: Int,
    @DrawableRes val imgRes: Int,
    @StringRes val imgDesc: Int? = null,
)

val categoryList = listOf(
    DataSource(title = R.string.cat_tea, imgRes = R.drawable.tea_logo),
    DataSource(title = R.string.cat_pizza, imgRes = R.drawable.pizza_logo),
    DataSource(title = R.string.cat_restaurant, imgRes = R.drawable.restaurant_logo),
    DataSource(title = R.string.cat_park, imgRes = R.drawable.park_logo),
)

val recommendationTeaList = listOf(
    DataSource(title = R.string.tea_shop_1, imgRes = R.drawable.tea_logo),
    DataSource(title = R.string.tea_shop_2, imgRes = R.drawable.tea_logo),
    DataSource(title = R.string.tea_shop_3, imgRes = R.drawable.tea_logo),
    DataSource(title = R.string.tea_shop_4, imgRes = R.drawable.tea_logo),
    DataSource(title = R.string.tea_shop_5, imgRes = R.drawable.tea_logo),
)

val recommendationPizzaList = listOf(
    DataSource(R.string.pizza_shop_1, R.drawable.pizza_logo),
    DataSource(R.string.pizza_shop_2, R.drawable.pizza_logo),
    DataSource(R.string.pizza_shop_3, R.drawable.pizza_logo),
    DataSource(R.string.pizza_shop_4, R.drawable.pizza_logo),
    DataSource(R.string.pizza_shop_5, R.drawable.pizza_logo),
)

val recommendationRestaurantList = listOf(
    DataSource(R.string.restaurant_1, R.drawable.restaurant_logo),
    DataSource(R.string.restaurant_2, R.drawable.restaurant_logo),
    DataSource(R.string.restaurant_3, R.drawable.restaurant_logo),
    DataSource(R.string.restaurant_4, R.drawable.restaurant_logo),
    DataSource(R.string.restaurant_5, R.drawable.restaurant_logo),
)

val recommendationParkList = listOf(
    DataSource(R.string.park_1, R.drawable.park_logo),
    DataSource(R.string.park_2, R.drawable.park_logo),
    DataSource(R.string.park_3, R.drawable.park_logo),
    DataSource(R.string.park_4, R.drawable.park_logo),
    DataSource(R.string.park_5, R.drawable.park_logo),
)
