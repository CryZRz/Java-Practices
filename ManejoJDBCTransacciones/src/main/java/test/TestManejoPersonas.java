package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

import java.sql.*;

public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            var personaJDBC = new PersonaDAO(conexion);

            var cambioPersona = new Persona(7, "Valiera", "Romo", "valromo@email.com", "45896321");
            personaJDBC.actualizar(cambioPersona);
            var insertarPersona = new Persona("Alfredo", "Granados", "granadios@dios.com", "89562103");
            personaJDBC.insertar(insertarPersona);

            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

    }
}
