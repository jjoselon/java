package co.core.gamesmall;

import java.util.ArrayList;

public class PreguntaOpcion {
    
    private ArrayList<String> cuerpoPreguntaOpcion = new ArrayList<String>();
    private Pregunta pregunta;
    
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
    public void addCuerpoPreguntaOpcion(String cuerpoPreguntaOpcion) {
        this.cuerpoPreguntaOpcion.add(cuerpoPreguntaOpcion);
    }
    
    public ArrayList<String> getCuerpoPreguntaOpcion() {
        return this.cuerpoPreguntaOpcion;
    }

    public Pregunta getPregunta() {
        return this.pregunta;
    }
    
    public String getPreguntaOpcion(int index) {
        return this.cuerpoPreguntaOpcion.get(index);
    }
    
}
