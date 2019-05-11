package co.core.gamesmall;

public class Pregunta {
   
    private String enunciadoPregunta;
    private String preguntaOpcionCorrecta;
    private PreguntaOpcion preguntaOpcion;
    private float valor;
    
    public void setPreguntaOpciones(PreguntaOpcion preguntaOpcion) {
        this.preguntaOpcion = preguntaOpcion;
    }
    
    public PreguntaOpcion getPreguntaOpciones() {
        return this.preguntaOpcion;
    }
    
    public void setPreguntaOpcionCorrecta(String indexPreguntaOpcion) {
        this.preguntaOpcionCorrecta = indexPreguntaOpcion;
    }
    
    public int getPreguntaOpcionCorrecta() {
        return preguntaOpcion.getCuerpoPreguntaOpcion().indexOf(this.preguntaOpcionCorrecta);
    }
    
    public void setEnunciadoPregunta(String enunciadoPregunta) {
        this.enunciadoPregunta = enunciadoPregunta;
    }

    public String getEnunciadoPregunta() {
        return this.enunciadoPregunta;
    }    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
