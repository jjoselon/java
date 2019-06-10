package com.gamesmall.quienquieresermillonarioconmaven;

import com.gamesmall.daos.PreguntaDaoSinHibernate;
import com.gamesmall.daos.RespuestaDaoSinHibernate;
import com.gamesmall.entities.Pregunta;
import com.gamesmall.entities.Respuesta;
import com.gamesmall.mysql.connection.Connection;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Program {

    public static Connection connection = new Connection();

    public static void seedData() throws SQLException {

        java.sql.Connection conn = connection.getConnection();

        Statement st = conn.createStatement();

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("src/main/resources/file.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray questions = (JSONArray) jsonObject.get("preguntas");
            String queryToSaveAllAnswersComposed = "";
            // Almacenamos en el arraylist allQuestions todas las preguntas
            for (int i = 0; i < questions.size(); i++) {
                int ordenRespuesta = 0;
                JSONObject jsonPregunta = (JSONObject) questions.get(i);
                Pregunta objPregunta = new Pregunta(
                        jsonPregunta.get("enunciado").toString(),
                        Float.parseFloat(jsonPregunta.get("valor").toString())
                );
                // Obtenemos las opciones de la pregunta
                JSONArray optionsOfTheQuestion = (JSONArray) jsonPregunta.get("opciones");
                Respuesta respuesta = null;
                for (int k = 0; k < optionsOfTheQuestion.size(); k++) {
                    JSONObject detailOption = (JSONObject) optionsOfTheQuestion.get(k);
                    respuesta = new Respuesta();
                    respuesta.setDescripcion(detailOption.get("descripcion").toString());
                    if ((boolean) detailOption.get("correcta")) {
                        respuesta.isCorrecta();
                    }
                    respuesta.setPregunta(objPregunta);
                    objPregunta.addRespuesta(respuesta);
                }
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO pregunta (EnunciadoPregunta, ValorPregunta) VALUES (?,?)",
                        Statement.RETURN_GENERATED_KEYS
                );
                pstmt.setString(1, objPregunta.getEnunciado());
                pstmt.setFloat(2, objPregunta.getValor());
                int rowAffected = pstmt.executeUpdate();
                int idPreguntaGenerado = 0;
                if (rowAffected == 1) {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        idPreguntaGenerado = rs.getInt(1); // column idpregunta
                    }
                }
                ArrayList<Respuesta> respuestas = objPregunta.getRespuestas();
                queryToSaveAllAnswersComposed = "";
                for (Respuesta res : respuestas) {
                    ordenRespuesta++;
                    queryToSaveAllAnswersComposed += "(" + "'" + res.getDescripcion() + "'" + ", " + res.getIsCorrecta() + "," + ordenRespuesta + "," + idPreguntaGenerado + "),";
                }
                queryToSaveAllAnswersComposed = queryToSaveAllAnswersComposed.substring(0, queryToSaveAllAnswersComposed.length() - 1);
                st.execute("INSERT INTO respuesta (DescripcionRespuesta, EsCorrecta, OrdenRespuesta, pregunta_idpregunta) VALUES " + queryToSaveAllAnswersComposed);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        /*
        try {
            seedData();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        */
        
         
        java.sql.Connection conn = connection.getConnection();
        Statement st = conn.createStatement();

        PreguntaDaoSinHibernate pdsh = new PreguntaDaoSinHibernate();
        Pregunta pregunta1 = new Pregunta();
        /*
        pdsh.guardar(
                pregunta1.setEnunciado("enunciado cualquiera").setValor(800)
        );
        */
        /*
        pdsh.editar(
                pregunta1.setId(1).setEnunciado("ahora soy este enunciado cualquiera").setValor(900)
        );
        */
        /*
        pdsh.eliminar(
                pregunta1.setId(2)
        );
        */

        RespuestaDaoSinHibernate respuestaDAO = new RespuestaDaoSinHibernate();

        Respuesta respuesta1 = new Respuesta();
        respuestaDAO.editar(
                respuesta1.setId(1).setDescripcion("IDE (Integrated development Environment)")
        );

        // Obtiene el número maximo del orden de las respuestas relacionadas a la pregunta.
        /*
        ResultSet numeroRespuesta = respuestaDAO.obtenerNumeroOrdenMaximoDeRespuestaPorId(1);
        while (numeroRespuesta.next()) {
            respuestaDAO.guardar(
                    respuesta1.setDescripcion("ERP").setPregunta(
                            new Pregunta().setId(1)
                    ).setNextOrden(numeroRespuesta.getInt("OrdenRespuesta") + 1)
            );
        }
        */
        
        // eliminar
        /*
        respuestaDAO.eliminar(
                respuesta1.setId(6).setPregunta(
                        new Pregunta().setId(1)
                )
        );
        */

        ResultSet todasLasPreguntas = pdsh.obtenerTodas();

        float dineroTotalGanado = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (todasLasPreguntas.next()) {
                System.out.println("Pregunta #" + todasLasPreguntas.getInt("idpregunta") + " por $ " + todasLasPreguntas.getInt("ValorPregunta"));
                System.out.println(todasLasPreguntas.getString("EnunciadoPregunta"));

                ResultSet rs = st.executeQuery(
                        "SELECT r.*, p.* FROM pregunta AS p"
                        + " INNER JOIN respuesta AS r"
                        + " ON r.pregunta_idpregunta = p.idpregunta"
                        + " WHERE p.idpregunta = " + todasLasPreguntas.getInt("idpregunta")
                );

                int respuestaCorrecta = 0;
                while (rs.next()) {
                    System.out.println(rs.getInt("OrdenRespuesta") + ". " + rs.getString("DescripcionRespuesta"));
                    if (rs.getBoolean("EsCorrecta")) {
                        respuestaCorrecta = rs.getInt("OrdenRespuesta");
                    }
                }
                System.out.println("_______________________________");
                System.out.print("Respuesta: ");
                if (sc.nextInt() == respuestaCorrecta) {
                    System.out.println("RESPUESTA CORRECTA");
                    dineroTotalGanado += todasLasPreguntas.getInt("ValorPregunta");
                    System.out.println("__ Dinero acumulado: $ " + dineroTotalGanado + " __");
                } else {
                    System.out.println("RESPUESTA INCORRECTA");
                    break;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("__ Total dinero ganado: $ " + dineroTotalGanado + " __");

        // -- EJEMPLO CON HIBERNATE, NO FUNCIONA EN EL SENA -- //
        /*
        PreguntaDAO preguntaDAO = new PreguntaDAO();

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("G:\\hb-o\\hb\\QuienQuiereSerMillonarioConMaven\\src\\main\\resources\\file.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray questions = (JSONArray) jsonObject.get("preguntas");
            // Almacenamos en el arraylist allQuestions todas las preguntas
            for (int i = 0; i < questions.size(); i++) {
                JSONObject jsonPregunta = (JSONObject) questions.get(i);
                Pregunta objPregunta = new Pregunta(
                        jsonPregunta.get("enunciado").toString(),
                        Float.parseFloat(jsonPregunta.get("valor").toString())
                );
                // Obtenemos las opciones de la pregunta
                JSONArray optionsOfTheQuestion = (JSONArray) jsonPregunta.get("opciones");
                Respuesta respuesta = null;
                for (int k = 0; k < optionsOfTheQuestion.size(); k++) {
                    respuesta = new Respuesta();
                    respuesta.setDescripcion(optionsOfTheQuestion.get(k).toString());
                    objPregunta.addRespuesta(respuesta);
                }
                
                preguntaDAO.save(objPregunta);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
         */
    }
}
