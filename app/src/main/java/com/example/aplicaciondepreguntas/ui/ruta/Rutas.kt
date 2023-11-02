package com.example.aplicaciondepreguntas.ui.ruta

sealed class Rutas(val ruta: String) {

    object PantallaPrtincipal: Rutas("pantallaprincipal")
    object PantallaModoNormal: Rutas("pantallamodnormal")
    object PantallaModoExamen: Rutas("pantallaModoExamen")
    object PantallaEstadisticas: Rutas("pantallaEstadisticas")
}