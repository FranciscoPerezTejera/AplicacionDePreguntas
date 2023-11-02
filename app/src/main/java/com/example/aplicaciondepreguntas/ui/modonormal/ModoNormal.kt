package com.example.aplicaciondepreguntas.ui.modonormal

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicaciondepreguntas.R
import com.example.aplicaciondepreguntas.ui.Clases.Pregunta
import com.example.aplicaciondepreguntas.ui.themes.MiColor

@Composable
fun PantallaModoNormal() {

    val contexto = LocalContext.current
    var preguntas = listOf<Pregunta>(
        Pregunta("¿Ganó Cristiano Ronaldo el balón de oro en el año 2023?",true,"R.drawable.ronaldo"),
        Pregunta("¿Ganó el Alemania el mundial de futbol en el año 2010?",false,"R.drawable.alemania"),
        Pregunta("¿Tiene el Real Madrid 14 UEFA Champions League?",true,"R.drawable.madrid"),
        Pregunta("¿El FC Barcelona es el único equipo español en haber ganado un sextete?",true,"R.drawable.barcelona"),
        Pregunta("¿Es Messi el máximo goleador de la historia de la UEFA Champions League?",false,"R.drawable.messi"))
    var aumenta : Int = 0
    var preguntaTexto : String = preguntas [aumenta].getEnunciado()
    var aciertos : Int = 0
    var fallos : Int = 0



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(28, 99, 155))
    ) {

            Text(
                text = preguntaTexto,
                modifier = Modifier.padding(30.dp),
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        Image(
            painter = painterResource(id = R.drawable.ronaldo),
            contentDescription = "",
            modifier = Modifier
                .size(400.dp)
        )

        Row {
            Button(
                onClick = {
                    if (respuestaCorrecta(preguntas[aumenta].getEnunciado(),true,preguntas) == 1)
                    aumenta++
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
                    respuestaCorrecta(preguntas[aumenta].getEnunciado(),false,preguntas)
                    aumenta++
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
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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
                onClick = { /*TODO*/ },
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

fun respuestaCorrecta(pregunta : String, respuesta : Boolean, preguntas : List <Pregunta>) : Int {

    val preguntaEncontrada = preguntas.find { it.getEnunciado().equals(pregunta) }

    if (preguntaEncontrada != null && preguntaEncontrada.isRespuestaCorrecta.equals(respuesta)) {
        return 1;
    }

    return 0;
}
fun preguntaRandom() {}
fun prevPregunta() {}
fun nextPregunta() {}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewModoNormal() {
    PantallaModoNormal()
}