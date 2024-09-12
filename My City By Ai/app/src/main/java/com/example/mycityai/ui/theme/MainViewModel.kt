package com.example.mycityai.ui.theme

import androidx.lifecycle.ViewModel
import com.example.mycityai.R

class MainViewModel : ViewModel() {
    val items = listOf(
        Item("Tea Shops", R.drawable.tea_shops, listOf(
            Recommendation("Recommendation 1", R.drawable.recommendation_1, "Great tea taste, also provide snacks with tea like biscuits, cake and many more."),
            Recommendation("Recommendation 2", R.drawable.recommendation_2, "Details about the place."),
            Recommendation("Recommendation 3", R.drawable.recommendation_3, "Details about the place.")
        )),
        Item("Pizza Shops", R.drawable.pizza_shops, listOf(
            Recommendation("Recommendation 1", R.drawable.recommendation_1, "Details about the place."),
            Recommendation("Recommendation 2", R.drawable.recommendation_2, "Details about the place."),
            Recommendation("Recommendation 3", R.drawable.recommendation_3, "Details about the place.")
        )),
        Item("Restaurant", R.drawable.restaurant, listOf(
            Recommendation("Recommendation 1", R.drawable.recommendation_1, "details"),
            Recommendation("Recommendation 2", R.drawable.recommendation_2, "details"),
            Recommendation("Recommendation 3", R.drawable.recommendation_3, "details"),
        )),
        Item("Parks", R.drawable.park, listOf(
            Recommendation("Recommendation 1", R.drawable.recommendation_1, "details"),
            Recommendation("Recommendation 2", R.drawable.recommendation_2, "details"),
            Recommendation("Recommendation 3", R.drawable.recommendation_3, "details"),
        ))
        // ... other items
    )
}
