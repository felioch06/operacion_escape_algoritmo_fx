package application;
import java.util.List;

public class Pregunta {
    private String pregunta;
    private List<String> opciones;
    private String respuestaCorrecta;
    private String historia; 

    public Pregunta(String pregunta, List<String> opciones, String respuestaCorrecta, String historia) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.historia = historia; 
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

    public String getHistoria() { 
        return historia;
    }
}
