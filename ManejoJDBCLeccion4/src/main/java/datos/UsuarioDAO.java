package datos;

import java.sql.*;
import java.util.*;

import domain.Usuario;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT * FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario VALUES(null, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET name = ?, password = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?";

    public List<Usuario> seleccionar(){
        Connection conexionDb = null;
        PreparedStatement statementDb = null;
        ResultSet resultDb = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conexionDb = Conexion.getConection();
            statementDb = conexionDb.prepareCall(SQL_SELECT);
            resultDb = statementDb.executeQuery();
            while(resultDb.next()){
                int id = resultDb.getInt("id");
                String nombre = resultDb.getString("name");
                String apellido = resultDb.getString("password");
                
                usuario = new Usuario(id, nombre, apellido);
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(resultDb);
                Conexion.close(statementDb);
                Conexion.close(conexionDb);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        
        return usuarios;

    }

    public int insertar(Usuario usuario){
        Connection conexionDb = null;
        PreparedStatement statementDb = null;
        var registros = 0;
        try {
            conexionDb = Conexion.getConection();
            statementDb = conexionDb.prepareStatement(SQL_INSERT);
            statementDb.setString(1, usuario.getName());
            statementDb.setString(2, usuario.getPassword());
            registros = statementDb.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(conexionDb);
                Conexion.close(statementDb);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            
        }

        return registros;
    }

    public int actualizar(Usuario usuario){
        Connection conexionDb = null;
        PreparedStatement statementDb = null;
        var actulizacion = 0;
        try {
            conexionDb = Conexion.getConection();
            statementDb = conexionDb.prepareStatement(SQL_UPDATE);
            statementDb.setString(1, usuario.getName());
            statementDb.setString(2, usuario.getPassword());
            statementDb.setInt(3, usuario.getId());
            actulizacion = statementDb.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                Conexion.close(statementDb);
                Conexion.close(conexionDb);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }


        return actulizacion;
    }

    public int delete(Usuario usuario){
        Connection conexcionDb = null;
        PreparedStatement statementDb = null;
        var borrados = 0;
        try {
            conexcionDb = Conexion.getConection();
            statementDb = conexcionDb.prepareStatement(SQL_DELETE);
            statementDb.setInt(1, usuario.getId());
            borrados = statementDb.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                Conexion.close(statementDb);
                Conexion.close(conexcionDb);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }


        return borrados;
    }

}
