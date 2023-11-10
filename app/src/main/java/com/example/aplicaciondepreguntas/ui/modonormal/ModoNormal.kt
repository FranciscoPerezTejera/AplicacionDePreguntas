package com.example.aplicaciondepreguntas.ui.modonormal

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aplicaciondepreguntas.R
import com.example.aplicaciondepreguntas.ui.clase.Pregunta
import com.example.aplicaciondepreguntas.ui.ruta.Rutas
import com.example.aplicaciondepreguntas.ui.themes.MiColor
import kotlin.random.Random

@Composable
fun PantallaModoNormal(navController : NavHostController?) {

    val foto1: Painter = painterResource(id = R.drawable.ronaldo)
    val foto2: Painter = painterResource(id = R.drawable.alemania)
    val foto3: Painter = painterResource(id = R.drawable.madrid)
    val foto4: Painter = painterResource(id = R.drawable.barcelona)
    val foto5: Painter = painterResource(id = R.drawable.messi)
    val foto6: Painter = painterResource(id = R.drawable.haland)
    val foto7: Painter = painterResource(id = R.drawable.benzema)
    val foto8: Painter = painterResource(id = R.drawable.tenerife)
    val foto9: Painter = painterResource(id = R.drawable.messi_cristiano)
    val foto10: Painter = painterResource(id = R.drawable.mbappe)

    var preguntas = listOf<Pregunta>(
        Pregunta("¿Ganó Cristiano Ronaldo el balón de oro en el año 2023?", true, foto1),
        Pregunta("¿Ganó el Alemania el mundial de futbol en el año 2010?", false, foto2),
        Pregunta("¿Tiene el Real Madrid 14 UEFA Champions League?", true, foto3),
        Pregunta("¿El FC Barcelona es el único equipo español en haber ganado un sextete?", true, foto4),
        Pregunta("¿Es Messi el máximo goleador de la historia de la UEFA Champions League?", false, foto5),
        Pregunta("¿Fue Haland el pichichi de la Premier League en 2022?", true, foto6),
        Pregunta("¿Fue Benzema el ganador del balon de oro en 2020?", false, foto7),
        Pregunta("¿Subí el CD Tenerife a primera en la campaña 21/22?", false, foto8),
        Pregunta("¿Ha ganado más balones de oro CR7 que Messi?", true, foto9),
        Pregunta("¿Fichará Mbappe por el Real MAdrid en 2023?", true, foto10))

    var preguntaActual by remember { mutableStateOf(0) }
    var aciertos by remember { mutableStateOf(0) }
    var cantidadPreguntas by remember { mutableStateOf(0) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(28, 99, 155))
    ) {

        Text(
            text = preguntas[preguntaActual].getEnunciado(),
            modifier = Modifier
                .padding(30.dp),
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = preguntas[preguntaActual].getFoto(),
            contentDescription = "",
            modifier = Modifier
                .size(450.dp)
        )

        Row {
            Button(
                onClick = {
                    val respuesta = respuestaCorrecta(preguntas[preguntaActual], true)

                    if (respuesta) {
                        aciertos++
                    }
                    cantidadPreguntas++

                    if (preguntaActual < preguntas.size - 1) {
                        preguntaActual ++
                    }
                    else {
                        preguntaActual = 0
                    }

                    if (cantidadPreguntas == 5){
                        navController?.navigate(Rutas.PantallaMensajeNota.ruta + "/${aciertos.toString()}")
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MiColor
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "VERDADERO")

            }
            Button(
                onClick = {
                    val respuesta = respuestaCorrecta(preguntas[preguntaActual], false)

                    if (respuesta) { aciertos++ }
                    cantidadPreguntas++

                    if (preguntaActual < preguntas.size - 1) {
                        preguntaActual ++
                    }
                    else {
                        preguntaActual = 0
                    }
                    if (cantidadPreguntas == 5) {
                        navController?.navigate(Rutas.PantallaMensajeNota.ruta + "/${aciertos.toString()}")
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MiColor
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "FALSO")
            }
        }
        Row {
            Button(
                onClick = {
                    if (preguntaActual > 0) {
                        preguntaActual--
                    } else {
                        preguntaActual = preguntas.size - 1
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MiColor
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "PREV")
            }
            Button(
                onClick = {
                    preguntaActual = Random.nextInt(0, preguntas.size)
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MiColor
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "RANDOM")
            }
            Button(
                onClick = {
                    if (preguntaActual < preguntas.size - 1) {
                        preguntaActual++
                    } else {
                        preguntaActual = 0
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MiColor
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "NEXT")
            }
        }
    }
}

fun respuestaCorrecta(pregunta: Pregunta, respuestaUsuario: Boolean): Boolean {

    return pregunta.isRespuestaCorrecta.equals(respuestaUsuario)
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewModoNormal() {
    PantallaModoNormal(navController = null)
}