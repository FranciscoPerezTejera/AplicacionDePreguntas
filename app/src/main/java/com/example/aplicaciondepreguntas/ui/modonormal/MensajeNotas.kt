package com.example.aplicaciondepreguntas.ui.modonormal

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
@Composable
fun MensajeNotas() {

    Text(text = "Has Aprobado")
    Button(onClick = { }) {
        Text(text = "Volver pantalla")
    }


}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMensajeNotas() {
    MensajeNotas()
}