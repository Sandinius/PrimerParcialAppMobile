package com.example.primerparcialappmobilesantiagoandini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.primerparcialappmobilesantiagoandini.ui.theme.PrimerParcialAppMobileSantiagoAndiniTheme
import androidx.navigation.navArgument
import androidx.navigation.NavType
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimerParcialAppMobileSantiagoAndiniTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "Transferir"){
                    composable("Transferir"){
                        RetirarDineroPage(navController)
                    }
                    composable(
                        route = "MontoRetirado/{monto}",
                        arguments = listOf(
                            navArgument("monto") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val monto = backStackEntry.arguments?.getString("monto") ?: ""
                        MontoRetirado(navController, monto)
                    }
                }
            }
        }
    }
}
