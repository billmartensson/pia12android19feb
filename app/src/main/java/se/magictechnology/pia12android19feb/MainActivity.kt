package se.magictechnology.pia12android19feb

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import se.magictechnology.pia12android19feb.ui.theme.Pia12android19febTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pia12android19febTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost()
                }
            }
        }
    }
}

enum class NavScreen() {
    Welcome,
    Readmore,
    Fancy
}

@Composable
fun AppNavHost(
    navController : NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = NavScreen.Welcome.name) {
        composable(NavScreen.Welcome.name) {
            Welcome(
                goReadmore = {
                    navController.navigate(NavScreen.Readmore.name + "/" + it)
                 },
                goFancy = { navController.navigate(NavScreen.Fancy.name) }
            )
        }
        composable(NavScreen.Readmore.name + "/{fruitname}") {
            val thefruit = it.arguments?.getString("fruitname")
            Readmore(fruit = thefruit!!, goFancy = { navController.navigate(NavScreen.Fancy.name) })
        }
        composable(NavScreen.Fancy.name) {
            Text("Fancy")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavHostPreview() {
    Pia12android19febTheme {
        AppNavHost()
    }
}