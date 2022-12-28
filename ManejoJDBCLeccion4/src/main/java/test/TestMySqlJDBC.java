package test;

import java.sql.*;


public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "2746");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id, nombre, apellido, email, numero FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("id: " + resultado.getInt("id"));
                System.out.print(" Nombre: " + resultado.getString("nombre") + " ");
                System.out.print("Apellido: " + resultado.getString("apellido") + " ");
                System.out.print("Email: " + resultado.getString("email") + " ");
                System.out.print("Numero: " + resultado.getString("numero") + " ");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
