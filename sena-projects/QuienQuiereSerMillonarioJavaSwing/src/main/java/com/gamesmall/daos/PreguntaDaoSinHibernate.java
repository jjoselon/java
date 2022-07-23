package com.gamesmall.daos;

import com.gamesmall.entities.Pregunta;
import com.gamesmall.mysql.connection.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreguntaDaoSinHibernate {
    
    final private Connection objConnection = new Connection();
    
    public boolean guardar(Pregunta objPregunta) {
        java.sql.Connection connection = this.objConnection.getConnection();
        
        try {
            Statement st = connection.createStatement();
            return st.execute("INSERT INTO pregunta (EnunciadoPregunta, ValorPregunta) VALUES (" + "'" + objPregunta.getEnunciado() + "'" + "," + objPregunta.getValor() + ")");
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return false;
        }
    }
    
    public boolean editar(Pregunta objPregunta) {
        java.sql.Connection connection = this.objConnection.getConnection();
        
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

    public boolean eliminar(Pregunta objPregunta) {
        java.sql.Connection connection = this.objConnection.getConnection();
        
        try {
            Statement st = connection.createStatement();
            return st.execute("DELETE FROM pregunta WHERE idpregunta = " + objPregunta.getId());
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return false;
        }
    }
    
    public ResultSet obtenerPorId(int id) {
        java.sql.Connection connection = this.objConnection.getConnection();
        ResultSet rs = null;
        
        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM pregunta WHERE idpregunta = " + id);
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
        }
        return rs;
    }

    public ResultSet obtenerTodas() {
        java.sql.Connection connection = this.objConnection.getConnection();
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
