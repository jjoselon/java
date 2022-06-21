package com.gamesmall.daos;

import com.gamesmall.entities.Respuesta;
import com.gamesmall.mysql.connection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RespuestaDaoSinHibernate {

    public PreparedStatement guardar(Respuesta objRespuesta) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO respuesta (DescripcionRespuesta, pregunta_idpregunta, OrdenRespuesta, EsCorrecta) VALUES (?, ?, ?, ?)");
            System.out.println(objRespuesta.getDescripcion());
            System.out.println(objRespuesta.getPregunta().getId());
            ps.setString(1, objRespuesta.getDescripcion());
            ps.setInt(2, objRespuesta.getPregunta().getId());
            ps.setInt(3, objRespuesta.getOrden());
            ps.setBoolean(4, objRespuesta.getIsCorrecta());
            ps.executeUpdate();
            return ps;
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return ps;
        }
    }

    public PreparedStatement editar(Respuesta objRespuesta) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("UPDATE respuesta SET DescripcionRespuesta = (?) WHERE idrespuesta = (?)");
            ps.setString(1, objRespuesta.getDescripcion());
            ps.setInt(2, objRespuesta.getId());
            ps.executeUpdate();
            return ps;
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return ps;
        }
    }

    public PreparedStatement eliminar(Respuesta objRespuesta) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("DELETE FROM respuesta WHERE idrespuesta = (?) AND pregunta_idpregunta = (?)");
            ps.setInt(1, objRespuesta.getId());
            ps.setInt(2, objRespuesta.getPregunta().getId());
            ps.executeUpdate();
            return ps;
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
            return ps;
        }
    }

    public ResultSet obtenerPorId(int id) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        ResultSet rs = null;

        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM respuesta WHERE respuesta = " + id);
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
            rs = st.executeQuery("SELECT * FROM respuesta");
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet obtenerNumeroOrdenMaximoDeRespuestaPorId(int id) throws SQLException {
        java.sql.Connection connection = DBConnection.getInstance();
        ResultSet rs = null;

        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT MAX(OrdenRespuesta) AS OrdenRespuesta FROM respuesta WHERE pregunta_idpregunta = " + id);
        } catch (SQLException ex) {
            System.out.println("Error query " + ex.getMessage());
        }
        return rs;
    }
}
