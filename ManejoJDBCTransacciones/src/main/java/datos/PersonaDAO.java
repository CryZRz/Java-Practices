package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;


public class PersonaDAO {

    private Connection conexionTransacional;

    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, numero) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, numero = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id = ?";

    public PersonaDAO(){

    }

    public PersonaDAO(Connection conexionTransacional){
        this.conexionTransacional = conexionTransacional;
    }

    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConection();
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
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }   
        }
        
        return personas;
    }
    
    public int insertar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        var registros = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getNumero());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }

        return registros;
    }

    /**
     * @param persona
     * @return
     * @throws SQLException
     */
    public int actualizar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        var actulizacion = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConection();
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
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }


        return actulizacion;
    }

    public int delete(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        var borrados = 0;
        try {
            conn = this.conexionTransacional != null ? this.conexionTransacional : Conexion.getConection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId());
            borrados = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            Conexion.close(stmt);
            if (this.conexionTransacional == null) {
                Conexion.close(conn);
            }
        }


        return borrados;
    }
    
}
