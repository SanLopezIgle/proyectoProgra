package com.huerto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {
    private DatabaseManager databaseManager;
    ResultSet resultSet;

    public Consultas(){
        databaseManager = DatabaseManager.getInstance();
    }

    /**
     * Método que inserta un cliente nuevo en la BD
     * @param cliente
     * @return true si podemos insertar el cliente, false si hay algún error
     */
    public boolean insertarCliente(Cliente cliente){
        Connection conexion = databaseManager.getConnection();
        try{
            String consulta = "insert into cliente (dni, nombre) values (?,?)";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, cliente.getDni().toUpperCase());
            st.setString(2, cliente.getNombre().toUpperCase());
            st.execute();
            return true;
        }catch (SQLException e){
            System.err.println(e.getMessage());
            return false;
        }finally {
            cerrarConexion();
        }
    }

    /**
     * Método que realiza la consulta para poder sacar el
     * idHuerto y que plantas tiene este huerto
     * @return lista con los datos del huerto
     */
    public ArrayList<DatosHuerto> listaHuertos(){
        Connection conexion = databaseManager.getConnection();
        ArrayList<DatosHuerto> listaHuertos = new ArrayList<>();
        try{
            String consulta = "SELECT huerto.idHuerto, planta.especie\n" +
                    "FROM huerto\n" +
                    "JOIN tener ON huerto.idHuerto = tener.idHuerto\n" +
                    "JOIN planta ON tener.idPlanta = planta.idPlanta;";
            PreparedStatement st = conexion.prepareStatement(consulta);
            resultSet = st.executeQuery();
            while(resultSet.next()){
                DatosHuerto datos = new DatosHuerto();
                datos.setIdHuerto(resultSet.getInt("idHuerto"));
                datos.setEspecie(resultSet.getString("especie"));
                listaHuertos.add(datos);
            }
        }catch (SQLException e){
            e.getMessage();
        }finally {
            cerrarConexion();
        }
        return listaHuertos;
    }

    public void cerrarConexion(){
        databaseManager.close();
    }
}
