package peliculasDatos;

import java.util.List;

import Excepciones.AccesoDatosEx;
import Excepciones.EscrituraDatosEx;
import Excepciones.LecturaDatosExcpcion;
import peliculas.Pelicula;

public interface IAccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso)throws LecturaDatosExcpcion;

    void escribir(Pelicula pelicula, String nombre, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcpcion;
    
    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;

}
