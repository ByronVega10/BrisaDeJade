package com.example.evaluaciondos.ui.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.evaluaciondos.viewmodel.UsuarioViewModel

@Composable
fun MainScaffold(
    parentNavController: NavHostController,
    usuarioViewModel: UsuarioViewModel
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("cart") },
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(72.dp) // 👈 más grande y destacado
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carrito",
                        tint = Color.White
                    )
                    Text(
                        text = "Shop",
                        color = Color.White,
                        fontSize = 11.sp
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 6.dp,
                modifier = Modifier.height(70.dp),
                actions = {
                    // HOME (izquierda)
                    IconButton(
                        onClick = { navController.navigate("homeScreen") },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Inicio",
                                tint = if (currentRoute == "homeScreen") MaterialTheme.colorScheme.primary else Color.Gray
                            )
                            Text(
                                text = "Home",
                                fontSize = 12.sp,
                                color = if (currentRoute == "homeScreen") MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        }
                    }

                    // Espacio para el FAB
                    Spacer(modifier = Modifier.weight(1f))

                    // PROFILE (derecha)
                    IconButton(
                        onClick = { navController.navigate("profile") },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Perfil",
                                tint = if (currentRoute == "profile") MaterialTheme.colorScheme.primary else Color.Gray
                            )
                            Text(
                                text = "Perfil",
                                fontSize = 12.sp,
                                color = if (currentRoute == "profile") MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "homeScreen"
            ) {
                composable("homeScreen") { HomeScreen(parentNavController, usuarioViewModel) }
                composable("profile") { ProfileScreen() }
                composable("cart") { CartScreen() }
            }
        }
    }
}