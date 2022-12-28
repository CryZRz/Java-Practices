package test;

import datos.Conexion;
import datos.PersonaDao;
import datos.PersonaDaoJDBC;
import domain.PersonaDTO;

import java.sql.*;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            PersonaDao personaDao = new PersonaDaoJDBC(conexion);

            List<PersonaDTO> personas = personaDao.select();

            for (PersonaDTO persona : personas) {
                System.out.println(persona);
            }

            conexion.commit();
            System.out.println("se ha echo commit de la transaccion");
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
