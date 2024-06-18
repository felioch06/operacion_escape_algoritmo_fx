package application;
import java.util.List;

public class Pregunta {
    private String pregunta;
    private List<String> opciones;
    private String respuestaCorrecta;

    public Pregunta(String pregunta, List<String> opciones, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public boolean esRespuestaCorrecta(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta.trim());
    }
}
