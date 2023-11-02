package com.example.aplicaciondepreguntas.ui.Clases;

public class Pregunta {

    public String enunciado;
    public boolean respuestaCorrecta;
    public String foto;

    public Pregunta() {

    }

    public Pregunta(String pregunta, boolean respuesta, String foto) {
        this.enunciado = pregunta;
        this.respuestaCorrecta = respuesta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
