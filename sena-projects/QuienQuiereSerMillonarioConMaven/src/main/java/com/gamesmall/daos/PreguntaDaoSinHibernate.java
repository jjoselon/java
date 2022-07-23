package com.gamesmall.daos;

import com.gamesmall.entities.Pregunta;
import com.gamesmall.mysql.connection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreguntaDaoSinHibernate {

    public boolean guardar(Pregunta objPregunta) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        
        try {
            Statement st = connection.createStatement();
            return st.execute("INSERT INTO pregunta (EnunciadoPregunta, ValorPregunta) VALUES (" + "'" + objPregunta.getEnunciado() + "'" + "," + objPregunta.getValor() + ")");
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return false;
        }
    }
    
    public boolean editar(Pregunta objPregunta) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        
        try {
            Statement st = connection.createStatement();
            return st.execute("UPDATE pregunta SET EnunciadoPregunta = " + "'" + objPregunta.getEnunciado() + "'" 
                    + ", ValorPregunta = " + objPregunta.getValor()
                    + " WHERE idpregunta = " + objPregunta.getId()
            );
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminar(Pregunta objPregunta) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        
        try {
            Statement st = connection.createStatement();
            return st.execute("DELETE FROM pregunta WHERE idpregunta = " + objPregunta.getId());
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return false;
        }
    }
    
    public ResultSet obtenerPorId(int id) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        ResultSet rs = null;
        
        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM pregunta WHERE idpregunta = " + id);
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
        }
        return rs;
    }

    public ResultSet obtenerTodas() throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        ResultSet rs = null;
        
        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM pregunta");
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
        }
        return rs;
    }
}
