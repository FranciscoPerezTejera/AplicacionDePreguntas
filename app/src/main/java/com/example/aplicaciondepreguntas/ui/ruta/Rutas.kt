package com.example.aplicaciondepreguntas.ui.ruta

sealed class Rutas(val ruta: String) {

    object PantallaPrtincipal: Rutas("pantallaprincipal")
    object PantallaModoNormal: Rutas("pantallamodonormal")
    object PantallaModoExamen: Rutas("pantallamodoexamen")
    object PantallaEstadisticas: Rutas("pantallaestadisticas")
    object PantallaMensajeNotas: Rutas("pantallamensajenotas")
}