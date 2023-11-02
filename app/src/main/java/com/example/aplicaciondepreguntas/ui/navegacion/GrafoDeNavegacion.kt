package com.example.aplicaciondepreguntas.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicaciondepreguntas.ui.home.PantallaPrincipal
import com.example.aplicaciondepreguntas.ui.modonormal.PantallaModoNormal
import com.example.aplicaciondepreguntas.ui.rutas.Rutas

@Composable
fun GrafoNavegacion(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaPrtincipal.ruta) {


        composable(Rutas.PantallaPrtincipal.ruta){
            PantallaPrincipal(navController = navController)
        }

        composable(Rutas.PantallaModoNormal.ruta){
            PantallaModoNormal()
        }
    }
}