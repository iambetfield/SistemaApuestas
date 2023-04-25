package org.example.persistencia;

import org.example.entidades.Participante;

import java.sql.*;

public abstract class DAO {
    //variables de conexion
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    //constantes de conexion
    private final String USER ="root";
    private final String PASS = "root";
    private final String DATABASE ="apuestas";
    private final String DRIVER  = "com.mysql.cj.jdbc.Driver";

    //Métodos

    //para conectar a la base
    protected void conectarBase() throws ClassNotFoundException, SQLException{
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASS);
            //conexion.setAutoCommit(false); // para no confirmar automáticamente cualquier transacción


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //para desconectar
    protected void desconectarBase() throws SQLException {
        try {
            if(resultado != null){
                resultado.close();
            }
            if(sentencia !=null){
                sentencia.close();
            }
            if(conexion != null){
            conexion.close();
            }


        }catch (Exception e){

        }

    }

    protected void insertarModificarEliminar(String sql) throws SQLException, ClassNotFoundException {
        try {
            conectarBase();

            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        }catch (SQLException ex){
            //conexion.rollback();
            throw ex;

        }finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql)throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado =sentencia.executeQuery(sql);

        }catch (Exception e){
            throw e;
        }
    }


    }


