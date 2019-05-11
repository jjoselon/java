package quienquiereserpobre;

import co.core.gamesmall.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QuienQuiereSerPobre {

    public static void main(String[] args) {
        
        JSONParser parser = new JSONParser();
        ArrayList<Pregunta> allQuestions = new ArrayList<Pregunta>();

        try (Reader reader = new FileReader("C:\\Users\\APRENDIZ.DESKTOP-6L5LKEE\\Downloads\\Software-master\\Software-master\\JAVA\\QuienQuiereSerPobre\\file.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray questions = (JSONArray) jsonObject.get("preguntas");
            /* Almacenamos en el arraylist allQuestions todas las preguntas*/
            for (int i = 0; i < questions.size(); i++) {
                Pregunta pregunta = new Pregunta();
                PreguntaOpcion preguntaOpciones = new PreguntaOpcion();
                JSONObject j = (JSONObject) questions.get(i);
                pregunta.setEnunciadoPregunta(j.get("enunciado").toString()); //enunciado
                pregunta.setValor(Float.parseFloat(j.get("valor").toString())); // valor
                // Obtenemos las opciones de la pregunta
                JSONArray optionsOfTheQuestion = (JSONArray) j.get("opciones");
                for (int k = 0; k < optionsOfTheQuestion.size(); k++) {
                    //System.out.println(optionsOfTheQuestion.get(k).toString());
                    preguntaOpciones.addCuerpoPreguntaOpcion(optionsOfTheQuestion.get(k).toString());
                }
                pregunta.setPreguntaOpciones(preguntaOpciones);
                int optionCorrect = Integer.parseInt(j.get("opcionCorrecta").toString());
                //System.out.println(optionCorrect);
                //System.out.println(pregunta.getPreguntaOpciones());
                pregunta.setPreguntaOpcionCorrecta(pregunta.getPreguntaOpciones().getCuerpoPreguntaOpcion().get(optionCorrect));
                allQuestions.add(pregunta);
            }
            Iterator<String> iteratorQuestions = questions.iterator();            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        float dineroTotalGanado = 0;
        int numeroDeLaPregunta = 1;
        for (Pregunta pregunta : allQuestions) {
            // limpiamos
            System.out.println("Pregunta #" + numeroDeLaPregunta + " por $ " + pregunta.getValor());
            System.out.println(pregunta.getEnunciadoPregunta());
            ArrayList<String> opcionesDeLaPregunta = pregunta.getPreguntaOpciones().getCuerpoPreguntaOpcion(); 
            for (String cuerpoPreguntaOpcion : opcionesDeLaPregunta) { 		      
                System.out.println(opcionesDeLaPregunta.indexOf(cuerpoPreguntaOpcion) + ". " + cuerpoPreguntaOpcion); 		
            }
            System.out.println("_______________________________");
            Scanner s = new Scanner(System.in);
            System.out.print("Respuesta: ");
            if (s.nextInt() == pregunta.getPreguntaOpcionCorrecta()) {
                System.out.println("RESPUESTA CORRECTA");
                dineroTotalGanado += pregunta.getValor();
                System.out.println("__ Dinero acumulado: $ " + dineroTotalGanado + " __");
            } else {
                System.out.println("RESPUESTA INCORRECTA");
                break;
            }
            numeroDeLaPregunta++;
        }
        System.out.println("__ Total dinero ganado: $ " + dineroTotalGanado + " __");

    }
}
