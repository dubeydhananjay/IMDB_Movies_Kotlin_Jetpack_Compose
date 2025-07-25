package com.example.imdb_movies_example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.imdb_movies_example.screens.CategoryScreen
import com.example.imdb_movies_example.screens.MovieDetailScreen
import com.example.imdb_movies_example.ui.theme.IMDB_Movies_ExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMDB_Movies_ExampleTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Movies"

                                )
                            }
                            )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }
        }
    }
    @Composable
    fun App() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "category") {
            composable(route = "category") {
                CategoryScreen {
                    navController.navigate("detail/${it}")
                }
            }
            composable(route = "detail/{category}", arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )) {
                MovieDetailScreen()
            }
        }
    }
}
