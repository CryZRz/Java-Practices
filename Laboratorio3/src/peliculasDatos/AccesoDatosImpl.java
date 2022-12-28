package peliculasDatos;

import java.io.*;
import java.util.*;

import Excepciones.AccesoDatosEx;
import Excepciones.EscrituraDatosEx;
import Excepciones.LecturaDatosExcpcion;
import peliculas.Pelicula;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) {
       var archivo = new File(nombreRecurso);


       return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosExcpcion {
       var archivo = new File(nombreRecurso);
       List<Pelicula> peliculas = new ArrayList<>();
       try {
        var entrada = new BufferedReader(new FileReader(archivo));
        String linea = null;
        linea = entrada.readLine();
        while (linea != null) {
            var pelicula = new Pelicula(linea);
            peliculas.add(pelicula);
            linea = entrada.readLine();
        }
        entrada.close();
    } catch (Exception e) {
        e.printStackTrace(System.out);
        throw new LecturaDatosExcpcion("Exepcion al listar peliculas" + e.getMessage());
       }
        

       return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombre, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombre);
        try {
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            System.out.println("se ha escrito informacion al archivo" + pelicula);
            salida.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw new EscrituraDatosEx(e.getMessage());
        }
        
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosExcpcion {
        var archivo = new File(nombreRecurso);
        String resultado = null;

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula: " + linea + "econtrada en el indeice" + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (Exception e) {
            throw new LecturaDatosExcpcion("Excepcion al buscar" + e.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (Exception e) {
            throw new AccesoDatosEx(e.getMessage());
        }
        
    }

    @Override
    public void borrar(String nombreRecurso) {
        var archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("se borro el archivo");    
        } else {
            System.out.println("el archivo no existe");
        }
        
        
    }
    
}
