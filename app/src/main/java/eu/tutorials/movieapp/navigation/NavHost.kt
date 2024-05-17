package eu.tutorials.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.BannerScreen.route) {
        composable(Screen.BannerScreen.route) {
            BannerScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable("${Screen.DetailScreen.route}/{id}",
            arguments = listOf(
                navArgument(
                    name = "id"
                ) {
                    type = NavType.IntType
                }
            )

        ) {navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("id")?.let {id->
                DetailScreen(navController = navController, id = id)
            }

        }
    }
}

