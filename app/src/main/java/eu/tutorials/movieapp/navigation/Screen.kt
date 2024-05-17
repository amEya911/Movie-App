package eu.tutorials.movieapp.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import eu.tutorials.movieapp.R

sealed class Screen(val route: String) {
    object BannerScreen: Screen("Banner Screen")
    object HomeScreen: Screen("Home Screen")
    object DetailScreen: Screen("Detail Screen")
}

