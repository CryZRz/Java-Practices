package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;


public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, numero) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, numero = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id = ?";

    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareCall(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String numero = rs.getString("numero");
                
                persona = new Persona(id, nombre, apellido, email, numero);
                
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    }
    
    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        var registros = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getNumero());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            
        }

        return registros;
    }

    public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        var actulizacion = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getNumero());
            stmt.setInt(5, persona.getId());
            actulizacion = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }


        return actulizacion;
    }

    public int delete(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        var borrados = 0;
        try {
            conn = Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId());
            borrados = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }


        return borrados;
    }
    
}
