package id.my.sendiko.kinnect.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.my.sendiko.kinnect.auth.register.presentation.RegisterScreen
import id.my.sendiko.kinnect.auth.register.presentation.RegisterViewModel
import id.my.sendiko.kinnect.core.navigation.RegisterDestination
import id.my.sendiko.kinnect.core.ui.theme.KinnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KinnectTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = RegisterDestination
                ) {
                    composable<RegisterDestination> {
                        val viewModel = viewModel<RegisterViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        RegisterScreen(
                            state = state,
                            onEvent = viewModel::onEvent
                        )
                    }
                }
            }
        }
    }
}