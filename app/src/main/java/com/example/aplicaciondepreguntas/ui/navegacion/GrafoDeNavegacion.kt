package com.example.aplicaciondepreguntas.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicaciondepreguntas.ui.home.PantallaPrincipal
import com.example.aplicaciondepreguntas.ui.modoexamen.PantallaModoExamen
import com.example.aplicaciondepreguntas.ui.modonormal.PantallaMensajeNota
import com.example.aplicaciondepreguntas.ui.modonormal.PantallaModoNormal
import com.example.aplicaciondepreguntas.ui.ruta.Rutas

@Composable
fun GrafoNavegacion(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Rutas.PantallaPrtincipal.ruta) {


        composable(Rutas.PantallaPrtincipal.ruta){
            PantallaPrincipal(navController = navController)
        }

        composable(Rutas.PantallaModoNormal.ruta){
            PantallaModoNormal(navController = navController)
        }
        composable(Rutas.PantallaModoExamen.ruta){
            PantallaModoExamen(navController = navController)
        }
        composable(Rutas.PantallaMensajeNotas.ruta + "/{aciertos}") {
                llamada ->
            val aciertos = llamada.arguments?.getInt("aciertos") ?: 0
            PantallaMensajeNota(aciertos = aciertos)
        }
    }
}