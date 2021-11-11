package independent.dev.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import independent.dev.presentation.Screen
import independent.dev.presentation.theme.GuiaDeEscaladaTheme
import independent.dev.presentation.unit_converter.UnitConverterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GuiaDeEscaladaTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ) {
                    composable(Screen.HomeScreen.route) {
                        MainActivityUI(navController = navController)
                    }
                    composable(Screen.UnitConverterScreen.route){
                        UnitConverterScreen()
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        GuiaDeEscaladaTheme {
            MainActivityUI(navController = navController)
        }
    }
}
