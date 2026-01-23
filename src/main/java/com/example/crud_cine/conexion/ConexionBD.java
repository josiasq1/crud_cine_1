package com.example.crud_cine.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Cambia según tu versión de driver
    private static final String HOST = "localhost";
    private static final String PORT = "3307";
    private static final String DATABASE = "datoscine";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false";

    public static Connection conectar() {
        Connection conn = null;
        try {
            // Opcional: cargar driver explícitamente (no siempre necesario en Java 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intentar conectar
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de MySQL no encontrado. Agrega el connector/j al proyecto.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar a MySQL: " + e.getMessage());
            e.printStackTrace();
        }

        // Verificar que no sea null
        if (conn == null) {
            System.out.println("No se pudo establecer la conexión.");
        }

        return conn;
    }

}
